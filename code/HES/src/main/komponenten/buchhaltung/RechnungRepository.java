package main.komponenten.buchhaltung;

import main.allgemeineTypen.transportTypen.RechnungTyp;
import main.technik.persistenzManager.PersistenzManager;

import java.util.*;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:22
 */
class RechnungRepository {

    Map<String, List<IBuchhaltungListener>> buchhaltungListenerMap;
    PersistenzManager persistenzManager = PersistenzManager.getInstance();
    RechnungRepository() {
        this.buchhaltungListenerMap = new HashMap<String, List<IBuchhaltungListener>>();
    }

    public void schreibeFuerRechnungBezahltEventEin(String rechnungsNr, IBuchhaltungListener listener) {
        if (buchhaltungListenerMap.containsKey(rechnungsNr)) {
            buchhaltungListenerMap.get(rechnungsNr).add(0, listener);
        } else {
            List<IBuchhaltungListener> listenerList = new LinkedList<>();
            listenerList.add(listener);
            buchhaltungListenerMap.put(rechnungsNr, listenerList);
        }
    }

    public RechnungTyp erstelleRechnung(int gesamtbetrag) {
        Rechnung rechnung = new Rechnung(gesamtbetrag);
        persistenzManager.create(rechnung);
        return rechnung.getRechnungTyp();
    }

    public void zahlungseingangBuchen(Zahlungseingang zahlungseingang, String rechnungsNr) {
        Rechnung rechnung = persistenzManager.access(Rechnung.class, rechnungsNr);
//        System.out.print(zahlungseingang);
        System.out.print(rechnung);
        rechnung.zahlungseingangHinzufuegen(zahlungseingang);
        persistenzManager.update(rechnung);

        if (rechnung.getIstBezahlt()) {
            if (buchhaltungListenerMap.containsKey(rechnungsNr)) {
                for (IBuchhaltungListener listener : buchhaltungListenerMap.get(rechnungsNr)) {
                    listener.fuehreAktionAus();
                }
            }
        }
    }

    public List<RechnungTyp> getRechnungenZuKunde(String kundenNr) {
        List<RechnungTyp> transportRechnungen = null;
        List<Rechnung> rechnungen = persistenzManager.returnQuery("from Rechnung where Rechnung.KundenNr = "+kundenNr).list();
        for(Rechnung r : rechnungen)
        {
            transportRechnungen.add(r.getRechnungTyp());
        }
        return transportRechnungen;
    }

    public RechnungTyp getRechnungZuID(String rechnungsNr) {
        Rechnung rechnung = persistenzManager.access(Rechnung.class, rechnungsNr);
        return rechnung.getRechnungTyp();
    }
}
