package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.WareneingangsmeldungTyp;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 23.04.13
 * Time: 15:22
 * To change this template use File | Settings | File Templates.
 */
class WareneingangsmeldungRepository {
    public WareneingangsmeldungTyp getWareneingangsmeldungZuID(String wareneingangsmeldungsNr) {
       Wareneingangsmeldung wareneingangsmeldung = null;
       //TODO: Lese Wareneingangsmeldung aus Datenbank
       return wareneingangsmeldung.getWareneingangsmeldungTyp();
    }

}
