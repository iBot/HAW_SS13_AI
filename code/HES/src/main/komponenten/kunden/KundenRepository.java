package main.komponenten.kunden;

import main.allgemeineTypen.transportTypen.KundenTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:33
 */
class KundenRepository implements IKundenManager {
    @Override
    public void erstelleKunde(KundenTyp kunde) {
        Kunde result = new Kunde();
        //TODO: Persisitiere Kunde
    }

    @Override
    public KundenTyp getKunde(String kundenID) {
        Kunde kunde = null;
        //TODO: lese Kunde aus Datenbank
        return kunde.getKundenTyp();
    }
}
