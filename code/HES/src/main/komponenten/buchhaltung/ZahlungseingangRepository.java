package main.komponenten.buchhaltung;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 21.04.13
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 */
public class ZahlungseingangRepository {
    public Zahlungseingang erstelleZahlungseingang(double betrag) {
        Zahlungseingang zahlungseingang = new Zahlungseingang(betrag);
        //TODO: Persistiere Zahlungseingang
        return zahlungseingang;
    }
}
