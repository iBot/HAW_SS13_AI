package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.WareneingangsmeldungTyp;
import main.technik.persistenzManager.PersistenzManager;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 23.04.13
 * Time: 15:22
 * To change this template use File | Settings | File Templates.
 */
class WareneingangsmeldungRepository {

    PersistenzManager persistenzManager = PersistenzManager.getInstance();

    public WareneingangsmeldungTyp getWareneingangsmeldungZuID(String wareneingangsmeldungsNr) {
       Wareneingangsmeldung wareneingangsmeldung = persistenzManager.access(Wareneingangsmeldung.class, wareneingangsmeldungsNr);
       return wareneingangsmeldung.holeWareneingangsmeldungTyp();
    }

}
