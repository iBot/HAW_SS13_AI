package main.komponenten.buchhaltung;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.RechnungTyp;
import main.komponenten.verkauf.BuchhaltungListener;
import main.technik.persistenzManager.PersistenzManager;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:24
 */
class BuchhaltungLogik {

    private static BuchhaltungLogik instanz;
    RechnungRepository rechnungRepository;
    ZahlungseingangRepository zahlungseingangRepository;
//    Map<String, IBuchhaltungListener> buchhaltungListenerMap;

    private BuchhaltungLogik() {
//        this.buchhaltungListenerMap = new HashMap<>();
        this.rechnungRepository = new RechnungRepository();
        this.zahlungseingangRepository = new ZahlungseingangRepository();


    }

    public static BuchhaltungLogik getInstance() {
        if (instanz == null) {
            instanz = new BuchhaltungLogik();
        }
        return instanz;
    }

//    private void schreibeFuerRechnungBezahltEventEin(String rechnungsNr, IBuchhaltungListener listener) {
//        buchhaltungListenerMap.put(rechnungsNr, listener);
//    }

    public RechnungTyp erstelleRechnung(double gesamtbetrag, AuftragTyp auftrag, String buchhaltungsListenerID) {
        Rechnung rechnung = rechnungRepository.erstelleRechnung(gesamtbetrag, auftrag, buchhaltungsListenerID);
//        schreibeFuerRechnungBezahltEventEin(rechnung.getRechnungsNr(), listener);
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
//                buchhaltungListenerMap.get(rechnungsNr).fuehreAktionAus();
//            }
            IBuchhaltungListener bhl = PersistenzManager.getInstance().access(BuchhaltungListener.class, rechnung.getBuchhaltungsListenerNr());
            bhl.fuehreAktionAus();
        }


    }

    public RechnungTyp getRechnungZuAuftrag(String auftragsNr) {
        return rechnungRepository.getRechnungZuAuftrag(auftragsNr).holeRechnungTyp();
    }

    public RechnungTyp getRechnungZuID(String rechnungsNr) {
        return rechnungRepository.getRechnungZuID(rechnungsNr).holeRechnungTyp();
    }
}
