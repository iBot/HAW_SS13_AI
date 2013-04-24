package main.komponenten.buchhaltung;

import main.allgemeineTypen.transportTypen.RechnungTyp;

import java.util.List;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:24
 */
class BuchhaltungLogik {

    RechnungRepository rechnungRepository;
    ZahlungseingangRepository zahlungseingangRepository;

    BuchhaltungLogik() {
        this.rechnungRepository = new RechnungRepository();
        this.zahlungseingangRepository = new ZahlungseingangRepository();
    }

    public void schreibeFuerRechnungBezahltEventEin(String rechnungsNr, IBuchhaltungListener listener) {
        //TODO funktionalität checken

        listener.fuehreAktionAus();
        //rechnungRepository.schreibeFuerRechnungBezahltEventEin(rechnungsNr, listener);
    }

    public RechnungTyp erstelleRechnung(int gesamtbetrag) {
        return rechnungRepository.erstelleRechnung(gesamtbetrag);
    }

    public void zahlungseingangBuchen(double betrag, String rechnungsNr) {
        Zahlungseingang zahlungseingang = zahlungseingangRepository.erstelleZahlungseingang(betrag);
        rechnungRepository.zahlungseingangBuchen(zahlungseingang, rechnungsNr);

    }

    public List<RechnungTyp> getRechnungenZuKunde(String kundenNr) {
        return rechnungRepository.getRechnungenZuKunde(kundenNr);
    }

    public RechnungTyp getRechnungZuID(String rechnungsNr) {
        return rechnungRepository.getRechnungZuID(rechnungsNr);
    }
}
