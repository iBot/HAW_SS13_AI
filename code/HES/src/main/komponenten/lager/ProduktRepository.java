package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.*;
import main.komponenten.buchhaltung.IBuchhaltungListener;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:35
 */
class ProduktRepository {

    Map<String, List<ILagerListener>> lagerListenerMap;

    public void schreibeFuerWarenReserviertEventEin(AuftragTyp auftrag, ILagerListener listener) {
        String auftragsNr = auftrag.getAuftragsNr();
        if (lagerListenerMap.containsKey(auftragsNr)) {
            lagerListenerMap.get(auftragsNr).add(0, listener);
        } else {
            List<ILagerListener> listenerList = new LinkedList<>();
            listenerList.add(listener);
            lagerListenerMap.put(auftragsNr, listenerList);
        }
    }

    public void bucheWareneingang(LieferscheinTyp lieferschein) {
        Produkt produkt = null;
        //TODO: Lese Produkt aus Datenbank: lieferschein.getProduktNr()
        produkt.erhoeheLagerbestand(lieferschein.getMenge());
        //TODO: Persistiere produkt

        if (lagerListenerMap.containsKey(lieferschein.getProduktNr())){
            for (ILagerListener  listener : lagerListenerMap.get(lieferschein.getProduktNr())){
                listener.fuehreAktionAus();
            }
        }
    }

    public void reserviereProdukteFuerAuftrag(AuftragTyp auftrag, AngebotTyp angebot) {
        Map<ProduktTyp, Integer> produkte = angebot.getProduktListe();
        for (Map.Entry<ProduktTyp, Integer> entry : produkte.entrySet() ){
            Produkt p = null;
            //TODO: Lese Produkt aus Datenbank: entry.getKey().getProduktNr();
            p.verringereLagerbestand(entry.getValue());
            //TODO: Persistiere Produkt
        }

    }


    public ProduktTyp getProduktZuID(String produktNr) {
        Produkt produkt = null;
        //TODO: Lese Produkt aus Datenbank aus.
        return produkt.getProduktTyp();
    }
}
