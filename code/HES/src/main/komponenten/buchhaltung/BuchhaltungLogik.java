package main.komponenten.buchhaltung;

import main.allgemeineTypen.transportTypen.AuftragTyp;
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

    private void schreibeFuerRechnungBezahltEventEin(String rechnungsNr, IBuchhaltungListener listener) {
        rechnungRepository.schreibeFuerRechnungBezahltEventEin(rechnungsNr, listener);
    }

    public RechnungTyp erstelleRechnung(double gesamtbetrag, AuftragTyp auftrag, IBuchhaltungListener listener) {
        Rechnung rechnung = rechnungRepository.erstelleRechnung(gesamtbetrag, auftrag);
        schreibeFuerRechnungBezahltEventEin(rechnung.getRechnungsNr(), listener);
        //sende Rechnung an Kunde
        return rechnung.holeRechnungTyp();
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
