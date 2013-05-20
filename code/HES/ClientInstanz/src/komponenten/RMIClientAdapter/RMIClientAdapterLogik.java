package komponenten.RMIClientAdapter;

import komponenten.AktiveRedundanz.dispatcher.IDispatcherManager;
import main.allgemeineTypen.transportTypen.*;
import main.komponenten.RMIServerAdapter.IRemoteAWK;
import main.komponenten.lager.IReserviertListener;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 20.05.13
 * Time: 17:46
 * To change this template use File | Settings | File Templates.
 */
public class RMIClientAdapterLogik {
    IRemoteAWK remoteAWK1;
    IRemoteAWK remoteAWK2;
    IDispatcherManager dispatcherManager;



    public RMIClientAdapterLogik(IDispatcherManager dispatcherManager) throws MalformedURLException, NotBoundException, RemoteException {
        this.dispatcherManager = dispatcherManager;
        String url1 = "remoteAWK1";
        String url2 = "remoteAWK2";
        remoteAWK1 = (IRemoteAWK) Naming.lookup(url1);
        remoteAWK2 = (IRemoteAWK) Naming.lookup(url2);
    }

    private IRemoteAWK getAwk(){
        if(dispatcherManager.getZuVerwendendeSystemInstanzID()==1){
            return remoteAWK1;
        }
        else{
            return remoteAWK2;
        }
    }

    public KundenTyp erstelleKunde(KundenTyp kunde) throws RemoteException {
        return getAwk().erstelleKunde(kunde);
    }

    public KundenTyp getKundeZuID(String kundenID) throws RemoteException {
        return getAwk().getKundeZuID(kundenID);
    }

    public ProduktTyp erstelleProdukt(String produktName) throws RemoteException  {
        return getAwk().erstelleProdukt(produktName);
    }

    public void bucheWareneingang(LieferscheinTyp lieferschein, String bestellNr) throws RemoteException {
        getAwk().bucheWareneingang(lieferschein,bestellNr);
    }

    public void reserviereProdukteFuerAuftrag(AngebotTyp angebot, String reserviertListener) throws RemoteException {
        getAwk().reserviereProdukteFuerAuftrag(angebot,reserviertListener);
    }

    public ProduktTyp getProduktZuID(String produktNr) throws RemoteException {
        return getAwk().getProduktZuID(produktNr);
    }

    public WareneingangsmeldungTyp getWareneingangsmeldungZuID(String wareneingangsmeldungsNr) throws RemoteException {
        return getAwk().getWareneingangsmeldungZuID(wareneingangsmeldungsNr);
    }

    public AngebotTyp erstelleAngebot(String kundenNr, Date gueltigBis, Date gueltigAb, Map<String, Integer> produktListe) throws RemoteException {
        return getAwk().erstelleAngebot(kundenNr,gueltigBis,gueltigAb,produktListe);
    }

    public AuftragTyp erstelleAuftrag(AngebotTyp angebot, Date beauftragtAm) throws RemoteException {
        return getAwk().erstelleAuftrag(angebot,beauftragtAm);
    }

    public AuftragTyp getAuftragZuID(String auftragsNr) throws RemoteException {
        return getAwk().getAuftragZuID(auftragsNr);
    }

    public AngebotTyp getAngebotZuID(String angebotNr) throws RemoteException {
        return getAwk().getAngebotZuID(angebotNr);
    }
}
