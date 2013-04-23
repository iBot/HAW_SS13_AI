package main.komponenten.verkauf;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.allgemeineTypen.transportTypen.KundenTyp;
import main.allgemeineTypen.transportTypen.ProduktTyp;

import java.util.Date;
import java.util.Map;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:49
 */
class AngebotLogik {
     private  AngebotRepository angebotRepository;

    AngebotLogik() {
        this.angebotRepository = new AngebotRepository();
    }

    public AngebotTyp erstelleAngebot(String kundenNr, Date gueltigBis, Date gueltigAb, Map<String,Integer> produktListe) {
        return this.angebotRepository.erstelleAngebot(kundenNr, gueltigBis, gueltigAb, produktListe);
    }

    public AngebotTyp getAngebotZuID(String angebotNr) {
        return this.angebotRepository.getAngebotZuID(angebotNr);
    }
}
