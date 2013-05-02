package main.komponenten.verkauf;

import main.technik.persistenzManager.PersistenzManager;

import java.util.Date;
import java.util.Map;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:50
 */
class AngebotRepository {

    PersistenzManager persistenzManager = PersistenzManager.getInstance();

    public Angebot erstelleAngebot(String kundenNr, Date gueltigBis, Date gueltigAb, Map<String, Integer> produktListe, double gesamtpreis) {
        Angebot angebot = new Angebot(kundenNr, gueltigBis, gueltigAb, produktListe, gesamtpreis);
        persistenzManager.create(angebot);
        return angebot;
    }

    public Angebot getAngebotZuID(String angebotNr) {
        Angebot angebot = persistenzManager.access(Angebot.class, angebotNr);
        return angebot;
    }
}
