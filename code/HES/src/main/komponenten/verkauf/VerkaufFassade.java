package main.komponenten.verkauf;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.KundenTyp;
import main.allgemeineTypen.transportTypen.ProduktTyp;

import java.util.Date;
import java.util.Map;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:48
 */
public class VerkaufFassade implements IVerkaufManager {
    @Override
    public AngebotTyp erstelleAngebot(String kundenNr, Date gueltigBis, Date gueltigAb, Map<ProduktTyp, Integer> produktListe, KundenTyp kunde) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AuftragTyp erstelleAuftrag(AngebotTyp angebot) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
