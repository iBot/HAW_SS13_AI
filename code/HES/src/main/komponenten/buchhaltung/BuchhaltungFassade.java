package main.komponenten.buchhaltung;

import main.allgemeineTypen.transportTypen.RechnungTyp;

import java.util.List;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:21
 */
public class BuchhaltungFassade implements IBuchhaltungManager, IBuchhaltungEvent {

    private BuchhaltungLogik buchhaltungLogik;

    public BuchhaltungFassade() {
        this.buchhaltungLogik = new BuchhaltungLogik();
    }

    @Override
    public void schreibeFuerRechnungBezahltEventEin(String rechnungsNr, IBuchhaltungListener listener) {
        buchhaltungLogik.schreibeFuerRechnungBezahltEventEin(rechnungsNr, listener);
    }

    @Override
    public RechnungTyp erstelleRechnung(int gesamtbetrag) {
        return buchhaltungLogik.erstelleRechnung(gesamtbetrag);
    }

    @Override
    public void zahlungseingangBuchen(double betrag, String rechnungsNr) {
        buchhaltungLogik.zahlungseingangBuchen(betrag, rechnungsNr);
    }

    @Override
    public List<RechnungTyp> getRechnungenZuKunde(String kundenNr) {
        return buchhaltungLogik.getRechnungenZuKunde(kundenNr);
    }

    @Override
    public RechnungTyp getRechnungZuID(String rechnungsNr) {
        return buchhaltungLogik.getRechnungZuID(rechnungsNr);
    }
}
