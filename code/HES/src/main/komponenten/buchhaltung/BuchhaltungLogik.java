package main.komponenten.buchhaltung;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.RechnungTyp;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:24
 */
class BuchhaltungLogik {

    RechnungRepository rechnungRepository;
    ZahlungseingangRepository zahlungseingangRepository;
    Map<String, IBuchhaltungListener> buchhaltungListenerMap;

    private static BuchhaltungLogik instanz;

    public static BuchhaltungLogik getInstance(){
        if (instanz==null){
            instanz = new BuchhaltungLogik();
        }
        return instanz;
    }

    private BuchhaltungLogik() {
        this.buchhaltungListenerMap = new HashMap<>();
        this.rechnungRepository = new RechnungRepository();
        this.zahlungseingangRepository = new ZahlungseingangRepository();
    }

    private void schreibeFuerRechnungBezahltEventEin(String rechnungsNr, IBuchhaltungListener listener) {
       buchhaltungListenerMap.put(rechnungsNr, listener);
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
            if (buchhaltungListenerMap.containsKey(rechnungsNr)) {
                buchhaltungListenerMap.get(rechnungsNr).fuehreAktionAus();
                }
            }
        }



    public RechnungTyp getRechnungZuAuftrag(String auftragsNr) {
       return rechnungRepository.getRechnungZuAuftrag(auftragsNr).holeRechnungTyp();
    }

    public RechnungTyp getRechnungZuID(String rechnungsNr) {
        return rechnungRepository.getRechnungZuID(rechnungsNr).holeRechnungTyp();
    }
}
