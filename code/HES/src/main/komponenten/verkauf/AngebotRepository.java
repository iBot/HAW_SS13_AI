package main.komponenten.verkauf;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.allgemeineTypen.transportTypen.KundenTyp;
import main.allgemeineTypen.transportTypen.ProduktTyp;

import java.util.Date;
import java.util.Map;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:50
 */
class AngebotRepository {
    public AngebotTyp erstelleAngebot(String kundenNr, Date gueltigBis, Date gueltigAb, Map<ProduktTyp, Integer> produktListe) {
        Angebot angebot = new Angebot(kundenNr, gueltigBis, gueltigAb, produktListe);
        //TODO: Persistiere Angebot
        return angebot.getAngebotTyp();
    }

    public AngebotTyp getAngebotZuID(String angebotNr) {
        Angebot angebot = null;
        //TODO: Lese angebot au Datenbank
        return angebot.getAngebotTyp();
    }
}
