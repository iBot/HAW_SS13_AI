package main.komponenten.buchhaltung;

import main.technik.persistenzManager.PersistenzManager;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 21.04.13
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 */
public class ZahlungseingangRepository {

    PersistenzManager persistenzManager = PersistenzManager.getInstance();

    public Zahlungseingang erstelleZahlungseingang(double betrag) {
        Zahlungseingang zahlungseingang = new Zahlungseingang(betrag);
        persistenzManager.create(zahlungseingang);
        return zahlungseingang;
    }


}
