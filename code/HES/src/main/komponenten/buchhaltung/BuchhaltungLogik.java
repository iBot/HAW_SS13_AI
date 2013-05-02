package main.komponenten.buchhaltung;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.RechnungTyp;

import java.util.ArrayList;
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
        Rechnung rechnung = rechnungRepository.getRechnungZuID(rechnungsNr);

        rechnung.zahlungseingangHinzufuegen(zahlungseingang);
        rechnungRepository.speicherRechnung(rechnung);

        if (rechnung.getIstBezahlt()) {
            //TODO: wohin soll die Map?
//            if (buchhaltungListenerMap.containsKey(rechnungsNr)) {
//                for (IBuchhaltungListener listener : buchhaltungListenerMap.get(rechnungsNr)) {
//                    listener.fuehreAktionAus();
//                }
//            }
        }

    }

    public List<RechnungTyp> getRechnungenZuKunde(String kundenNr) {
        List<RechnungTyp> transportRechnungen = new ArrayList<>();
        for(Rechnung r : rechnungRepository.getRechnungenZuKunde(kundenNr))
        {
            transportRechnungen.add(r.holeRechnungTyp());
        }
        return transportRechnungen;
    }

    public RechnungTyp getRechnungZuID(String rechnungsNr) {
        return rechnungRepository.getRechnungZuID(rechnungsNr).holeRechnungTyp();
    }
}
