package main.komponenten.kunden;

import main.allgemeineTypen.transportTypen.KundenTyp;
import main.technik.persistenzManager.PersistenzManager;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:33
 */
class KundenRepository implements IKundenManager {

    PersistenzManager persistenzManager = PersistenzManager.getInstance();

    @Override
    public void erstelleKunde(KundenTyp kunde) {
        Kunde neuerKunde = new Kunde(kunde.getName(), kunde.getAdresse());
        persistenzManager.create(neuerKunde);
    }

    @Override
    public KundenTyp getKundeZuID(String kundenID) {
        Kunde kunde = persistenzManager.access(Kunde.class, kundenID);
        return kunde.getKundenTyp();
    }
}
