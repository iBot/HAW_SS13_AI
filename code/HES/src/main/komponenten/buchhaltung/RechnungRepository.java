package main.komponenten.buchhaltung;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.technik.persistenzManager.PersistenzManager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    public Rechnung erstelleRechnung(double gesamtbetrag, AuftragTyp auftrag) {
        Rechnung rechnung = new Rechnung(gesamtbetrag, auftrag);
        persistenzManager.create(rechnung);
        return rechnung;
    }

    public void zahlungseingangBuchen(Zahlungseingang zahlungseingang, String rechnungsNr) {

    }

    public List<Rechnung> getRechnungenZuKunde(String kundenNr) {
        String queryString= "from Rechnung where Rechnung.KundenNr = '"+kundenNr+"'";
        List<Rechnung> rechnungen = persistenzManager.getAllByQuery(queryString);
        return rechnungen;
    }

    public Rechnung getRechnungZuID(String rechnungsNr) {
        Rechnung rechnung = persistenzManager.access(Rechnung.class, rechnungsNr);
        return rechnung;
    }

    public void speicherRechnung(Rechnung rechnung) {
        persistenzManager.update(rechnung);
    }
}
