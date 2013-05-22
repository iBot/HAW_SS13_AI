package komponenten.RMIClientAdapter;

import main.allgemeineTypen.transportTypen.*;
import main.komponenten.lager.IReserviertListener;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 20.05.13
 * Time: 16:55
 * To change this template use File | Settings | File Templates.
 */
public class RMIClientAdapterFassade implements  IRMIClientAdapterManager {
    private RMIClientAdapterLogik logik;

    public RMIClientAdapterFassade(RMIClientAdapterLogik logik) {
        this.logik = logik;
    }

    @Override
    public KundenTyp erstelleKunde(KundenTyp kunde) {
        try {
            return logik.erstelleKunde(kunde);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public KundenTyp getKundeZuID(String kundenID) {
        try {
            return logik.getKundeZuID(kundenID);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public ProduktTyp erstelleProdukt(String produktName) {
        try {
            return logik.erstelleProdukt(produktName);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public void bucheWareneingang(LieferscheinTyp lieferschein, String bestellNr) {
        try {
            logik.bucheWareneingang(lieferschein, bestellNr);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public void reserviereProdukteFuerAuftrag(AngebotTyp angebot, String reserviertListener) {
        try {
            logik.reserviereProdukteFuerAuftrag(angebot, reserviertListener);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public ProduktTyp getProduktZuID(String produktNr) {
        try {
            return logik.getProduktZuID(produktNr);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public WareneingangsmeldungTyp getWareneingangsmeldungZuID(String wareneingangsmeldungsNr) {
        try {
            return logik.getWareneingangsmeldungZuID(wareneingangsmeldungsNr);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public AngebotTyp erstelleAngebot(String kundenNr, Date gueltigBis, Date gueltigAb, Map<String, Integer> produktListe) {
        try {
            return logik.erstelleAngebot(kundenNr, gueltigBis, gueltigAb, produktListe);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public AuftragTyp erstelleAuftrag(AngebotTyp angebot, Date beauftragtAm) {
        try {
            return logik.erstelleAuftrag(angebot, beauftragtAm);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public AuftragTyp getAuftragZuID(String auftragsNr) {
        try {
            return logik.getAuftragZuID((auftragsNr));
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public AngebotTyp getAngebotZuID(String angebotNr) {
        try {
            return logik.getAngebotZuID(angebotNr);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
}
