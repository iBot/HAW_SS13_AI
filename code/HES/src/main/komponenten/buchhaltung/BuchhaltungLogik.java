package main.komponenten.buchhaltung;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.RechnungTyp;

import java.util.List;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:24
 */
class BuchhaltungLogik implements IBuchhaltungManager, IBuchhaltungEvent  {

    RechnungRepository rechnungRepository;
    ZahlungseingangRepository zahlungseingangRepository;

    BuchhaltungLogik() {
        this.rechnungRepository = new RechnungRepository();
        this.zahlungseingangRepository = new ZahlungseingangRepository();
    }

    @Override
    public void schreibeFuerRechnungBezahltEventEin(String rechnungsNr, IBuchhaltungListener listener) {
        rechnungRepository.schreibeFuerRechnungBezahltEventEin(rechnungsNr,listener);
    }

    @Override
    public RechnungTyp erstelleRechnung() {
        return rechnungRepository.erstelleRechnung();
    }

    @Override
    public void zahlungseingangBuchen(double betrag, String rechnungsNr) {
        Zahlungseingang zahlungseingang = zahlungseingangRepository.erstelleZahlungseingang(betrag);
        rechnungRepository.zahlungseingangBuchen(zahlungseingang,rechnungsNr);
    }

    @Override
    public List<RechnungTyp> getRechnungenZuKunde(String kundenNr) {
       return rechnungRepository.getRechnungenZuKunde(kundenNr);
    }
}
