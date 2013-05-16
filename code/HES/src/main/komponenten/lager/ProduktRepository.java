package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.technik.persistenzManager.PersistenzManager;

import java.util.Map;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:35
 */
class ProduktRepository {

    //Map<String, ILagerListener> bestellListenerMap;
    PersistenzManager persistenzManager = PersistenzManager.getInstance();


    public void reserviereProduktFuerAuftrag(Produkt produkt, AngebotTyp angebot) {
        Map<String, Integer> produkte = angebot.getProduktListe();
        int menge = produkte.get(produkt.getProduktNr());
        produkt.verringereLagerbestand(menge);
        persistenzManager.update(produkt);

    }

    public Produkt getProduktZuID(String produktNr) {
        Produkt produkt = persistenzManager.access(Produkt.class, produktNr);
        return produkt;
    }

    public Produkt erstelleProdukt(String produktName) {
        Produkt produkt = new Produkt(produktName);
        persistenzManager.create(produkt);
        return produkt;
    }

    public void speicherProdukt(Produkt produkt) {
        persistenzManager.update(produkt);
    }


//    public void schreibeFuerWarenImLagerEventEin(AngebotTyp angebot, ILagerListener listener) {
//        String angebotsNr = angebot.getAngebotNr();
//
//        if (lagerListenerMap.containsKey(angebotsNr)) {
//            lagerListenerMap.get(angebotsNr).add(0, listener);
//        } else {
//            List<ILagerListener> listenerList = new LinkedList<>();
//            listenerList.add(listener);
//            lagerListenerMap.put(angebotsNr, listenerList);
//        }
//    }

//    public void schreibeFuerWareGeliefertEventEin(String bestellNr, ILagerListener listener) {
//        bestellListenerMap.put(bestellNr, listener);
//    }
//
//    public void bucheWareneingang(LieferscheinTyp lieferschein, String bestellNr) {
//        //angeliefertes Produkt aus der Datenbank holen
//        Produkt produkt = persistenzManager.access(Produkt.class, lieferschein.getProduktNr());
//
//        //Lagerbestand um Menge der gelieferten Produkte erhöhen
//        produkt.erhoeheLagerbestand(lieferschein.getMenge());
//        persistenzManager.update(produkt);
//
//
//        if (bestellListenerMap.containsKey(bestellNr)){
//            bestellListenerMap.get(bestellNr).fuehreAktionAus(produkt.holeProduktTyp());
//        }
//    }
}
