package komponenten.RMIClientAdapter;

import main.allgemeineTypen.transportTypen.*;
import main.komponenten.lager.IReserviertListener;

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
    @Override
    public KundenTyp erstelleKunde(KundenTyp kunde) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public KundenTyp getKundeZuID(String kundenID) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ProduktTyp erstelleProdukt(String produktName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void bucheWareneingang(LieferscheinTyp lieferschein, String bestellNr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void reserviereProdukteFuerAuftrag(AngebotTyp angebot, IReserviertListener reserviertListener) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ProduktTyp getProduktZuID(String produktNr) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public WareneingangsmeldungTyp getWareneingangsmeldungZuID(String wareneingangsmeldungsNr) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AngebotTyp erstelleAngebot(String kundenNr, Date gueltigBis, Date gueltigAb, Map<String, Integer> produktListe) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AuftragTyp erstelleAuftrag(AngebotTyp angebot, Date beauftragtAm) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AuftragTyp getAuftragZuID(String auftragsNr) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AngebotTyp getAngebotZuID(String angebotNr) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
