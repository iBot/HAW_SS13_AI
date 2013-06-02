package komponenten.RMIClientAdapter;

import komponenten.AktiveRedundanz.dispatcher.IDispatcherManager;
import komponenten.AktiveRedundanz.dispatcher.noServerAvailableException;
import main.allgemeineTypen.transportTypen.*;
import main.komponenten.RMIServerAdapter.IRemoteAWK;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 20.05.13
 * Time: 17:46
 */
public class RMIClientAdapterLogik {
    IRemoteAWK remoteAWK1;
    IRemoteAWK remoteAWK2;
    IDispatcherManager dispatcherManager;


    public RMIClientAdapterLogik(IDispatcherManager dispatcherManager) {
        this.dispatcherManager = dispatcherManager;
        TimerTask tt = new BinderTask(this);
        Timer timer = new Timer();
        timer.schedule(tt, 5000, 5000);
        if ((remoteAWK1 != null) && (remoteAWK2 != null)) {
            timer.cancel();
        }
    }

    public void bind() throws RemoteException, NotBoundException, MalformedURLException {
        final String url1 = "remoteAWK_1";
        final String url2 = "remoteAWK_2";
        if (remoteAWK1 == null) {
            remoteAWK1 = (IRemoteAWK) Naming.lookup(url1);
        }
        if (remoteAWK2 == null) {
            remoteAWK2 = (IRemoteAWK) Naming.lookup(url2);
        }
    }

    private IRemoteAWK getAwk() throws NoRemoteAWKAvailableException {
        IRemoteAWK result = null;
        int systemInstanzID;
        try {
            systemInstanzID = dispatcherManager.getZuVerwendendeSystemInstanzID();
            if (systemInstanzID == 1) {
                result =  remoteAWK1;
            } else if (systemInstanzID == 2) {
                result = remoteAWK2;
            }
        } catch (noServerAvailableException e) {
            System.out.println("Kein Remote AWK verfügbar. Bitte wiederholen Sie den Vorgang.");
            throw new NoRemoteAWKAvailableException();
        }
        return result;
    }

    public KundenTyp erstelleKunde(KundenTyp kunde) throws RemoteException {
        IRemoteAWK awk = getAwk();
        return awk.erstelleKunde(kunde);
    }

    public KundenTyp getKundeZuID(String kundenID) throws RemoteException {
        return getAwk().getKundeZuID(kundenID);
    }

    public ProduktTyp erstelleProdukt(String produktName) throws RemoteException {
        return getAwk().erstelleProdukt(produktName);
    }

    public void bucheWareneingang(LieferscheinTyp lieferschein, String bestellNr) throws RemoteException {
        getAwk().bucheWareneingang(lieferschein, bestellNr);
    }

    public void reserviereProdukteFuerAuftrag(AngebotTyp angebot, String reserviertListener) throws RemoteException {
        getAwk().reserviereProdukteFuerAuftrag(angebot, reserviertListener);
    }

    public ProduktTyp getProduktZuID(String produktNr) throws RemoteException {
        return getAwk().getProduktZuID(produktNr);
    }

    public WareneingangsmeldungTyp getWareneingangsmeldungZuID(String wareneingangsmeldungsNr) throws RemoteException {
        return getAwk().getWareneingangsmeldungZuID(wareneingangsmeldungsNr);
    }

    public AngebotTyp erstelleAngebot(String kundenNr, Date gueltigBis, Date gueltigAb, Map<String, Integer> produktListe) throws RemoteException {
        return getAwk().erstelleAngebot(kundenNr, gueltigBis, gueltigAb, produktListe);
    }

    public AuftragTyp erstelleAuftrag(AngebotTyp angebot, Date beauftragtAm) throws RemoteException {
        return getAwk().erstelleAuftrag(angebot, beauftragtAm);
    }

    public AuftragTyp getAuftragZuID(String auftragsNr) throws RemoteException {
        return getAwk().getAuftragZuID(auftragsNr);
    }

    public AngebotTyp getAngebotZuID(String angebotNr) throws RemoteException {
        return getAwk().getAngebotZuID(angebotNr);
    }
}
