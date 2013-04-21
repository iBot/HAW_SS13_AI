package main.komponenten.buchhaltung;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.RechnungTyp;

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

    Map<String,List<IBuchhaltungListener>> buchhaltungListenerMap;

    RechnungRepository() {
        this.buchhaltungListenerMap = new HashMap<>();
    }

    public void schreibeFuerRechnungBezahltEventEin(String rechnungsNr, IBuchhaltungListener listener) {
        if (buchhaltungListenerMap.containsKey(rechnungsNr)){
            buchhaltungListenerMap.get(rechnungsNr).add(0,listener);
        } else {
            List<IBuchhaltungListener> listenerList = new LinkedList<>();
            listenerList.add(listener);
            buchhaltungListenerMap.put(rechnungsNr,listenerList);
        }
    }

    public RechnungTyp erstelleRechnung() {
        Rechnung rechnung = new Rechnung();
        //TODO: Persistiere Rechnung
        return rechnung.getRechnungTyp();
    }

    public void zahlungseingangBuchen(Zahlungseingang zahlungseingang, String rechnungsNr) {
        Rechnung rechnung = null;
        //TODO: Lese Rechnung aus Datenbank aus.
        rechnung.zahlungseingangHinzufuegen(zahlungseingang);
        if (rechnung.getIstBezahlt()){
            if (buchhaltungListenerMap.containsKey(rechnungsNr)){
                for (IBuchhaltungListener listener : buchhaltungListenerMap.get(rechnungsNr)){
                    listener.fuehreAktionAus();
                }
            }
        }
    }

    public List<RechnungTyp> getRechnungenZuKunde(String kundenNr) {
        List<RechnungTyp> rechnungen = null;
        //TODO: Lese Rechnungen aus Datenbank aus, getRechnungTypen und füge diese zur liste hinzu
        return rechnungen;
    }
}
