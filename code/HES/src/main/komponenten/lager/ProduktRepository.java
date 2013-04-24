package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.*;
import main.technik.persistenzManager.PersistenzManager;

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
    PersistenzManager persistenzManager = PersistenzManager.getInstance();



    public void schreibeFuerWarenReserviertEventEin(AngebotTyp angebot, ILagerListener listener) {
        String angebotsNr = angebot.getAngebotNr();

        if (lagerListenerMap.containsKey(angebotsNr)) {
            lagerListenerMap.get(angebotsNr).add(0, listener);
        } else {
            List<ILagerListener> listenerList = new LinkedList<>();
            listenerList.add(listener);
            lagerListenerMap.put(angebotsNr, listenerList);
        }
    }

    public void bucheWareneingang(LieferscheinTyp lieferschein) {
        Produkt produkt = persistenzManager.access(Produkt.class, lieferschein.getProduktNr());
        produkt.erhoeheLagerbestand(lieferschein.getMenge());
        persistenzManager.update(produkt);

        if (lagerListenerMap.containsKey(lieferschein.getProduktNr())){
            for (ILagerListener  listener : lagerListenerMap.get(lieferschein.getProduktNr())){
                listener.fuehreAktionAus();
            }
        }
    }

    public void reserviereProdukteFuerAuftrag(AuftragTyp auftrag, AngebotTyp angebot) {
        Map<String, Integer> produkte = angebot.getProduktListe();
        for (Map.Entry<String, Integer> entry : produkte.entrySet() ){
            Produkt p = persistenzManager.access(Produkt.class, entry.getKey());
            p.verringereLagerbestand(entry.getValue());
            persistenzManager.update(p);
        }

    }


    public ProduktTyp getProduktZuID(String produktNr) {
        Produkt produkt = persistenzManager.access(Produkt.class, produktNr);
        return produkt.holeProduktTyp();
    }

    public ProduktTyp erstelleProdukt(String produktName) {
        Produkt produkt = new Produkt(produktName);
        persistenzManager.create(produkt);
        return produkt.holeProduktTyp();
    }
}
