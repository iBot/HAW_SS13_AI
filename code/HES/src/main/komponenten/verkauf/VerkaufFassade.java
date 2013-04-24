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
    private AngebotLogik angebotLogik;
    private AuftragLogik auftragLogik;

    public VerkaufFassade() {
        this.angebotLogik = new AngebotLogik();
        this.auftragLogik = new AuftragLogik();
    }

    @Override
    public AngebotTyp erstelleAngebot(String kundenNr, Date gueltigBis, Date gueltigAb, Map<String, Integer> produktListe) {
        return angebotLogik.erstelleAngebot(kundenNr, gueltigBis, gueltigAb, produktListe);
    }

    @Override
    public AuftragTyp erstelleAuftrag(AngebotTyp angebot) {
        return auftragLogik.erstelleAuftrag(angebot);
    }

    @Override
    public AuftragTyp getAuftragZuID(String auftragsNr) {
        return auftragLogik.getAuftragZuID(auftragsNr);
    }

    @Override
    public AngebotTyp getAngebotZuID(String angebotNr) {
        return angebotLogik.getAngebotZuID(angebotNr);
    }
}
