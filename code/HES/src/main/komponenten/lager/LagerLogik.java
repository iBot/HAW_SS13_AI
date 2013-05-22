package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.*;
import main.komponenten.verkauf.BuchhaltungListener;
import main.komponenten.verkauf.ReserviertListener;
import main.technik.persistenzManager.PersistenzManager;

import java.util.Map;
import java.util.UUID;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:34
 */
class LagerLogik {


    private ProduktRepository produktRepository;
    private WarenausgangsmeldungRepository warenausgangsmeldungRepository;
    private WareneingangsmeldungRepository wareneingangsmeldungRepository;
    private Map<String, ILagerListener> bestellListenerMap;

    private static LagerLogik instance;

    public static LagerLogik getInstance(){
        if (instance== null){
            instance = new LagerLogik();
        }
        return instance;
    }

    private LagerLogik() {
        this.produktRepository = ProduktRepository.getInstance();
        this.warenausgangsmeldungRepository = new WarenausgangsmeldungRepository();
        this.wareneingangsmeldungRepository = new WareneingangsmeldungRepository();
    }


    public ProduktTyp erstelleProdukt(String produktName) {
        return produktRepository.erstelleProdukt(produktName).holeProduktTyp();
    }

    public void bucheWareneingang(LieferscheinTyp lieferschein, String bestellNr) {
        //produktRepository.bucheWareneingang(lieferschein, bestellNr);
        //angeliefertes Produkt aus der Datenbank holen
        Produkt produkt = produktRepository.getProduktZuID(lieferschein.getProduktNr());

        //Lagerbestand um Menge der gelieferten Produkte erhöhen
        produkt.erhoeheLagerbestand(lieferschein.getMenge());
        produktRepository.speicherProdukt(produkt);

        wareneingangsmeldungRepository.erstelleWareneingangsmeldung(lieferschein);

//        if (bestellListenerMap.containsKey(bestellNr)){
//            bestellListenerMap.get(bestellNr).fuehreAktionAus(produkt);
//        }
        //TODO: Wie ersetze ich die opere M;ap durch das auslesen aus der DB?
//        ILagerListener lagerListener = PersistenzManager.getInstance().access(LagerListener.class, );
//        lagerListener.fuehreAktionAus(produkt);
    }

    //Um euren Fehler, dessen Namen ich nicht weiß :P, hier zu vermeiden habe ich jetzt zwei Listener benutzt. Der eine kommt vom
    //Auftrag und wartet darauf dass die Ware reservier ist. Der andere wird im Lager selbst angelegt und wartet darauf dass die
    //Ware da ist um sie anschließend zu reservieren. So schließen wir aus, das nachdem die Ware da ist jemand anders sie benutzt
    //bevor wir sie reservieren können. ODER??????
    public void reserviereProdukteFuerAuftrag(final AngebotTyp angebot, final String reserviertListenerNr) {
        boolean warenDa = true;
        //listener  --->>>>>> richtig kack lösung!!!!
        LagerListener lagerListener = new LagerListener(angebot, reserviertListenerNr);
//        ILagerListener listener = new ILagerListener() {
//            @Override
//            public void fuehreAktionAus(Produkt produkt) {
//                produktRepository.reserviereProduktFuerAuftrag(produkt, angebot);
//
//                boolean wareDa = true;
//                Map<String, Integer> produktListe = angebot.getProduktListe();
//                for(String key : produktListe.keySet())
//                {
//                    if(!istLagerBestandAusreichend(key, produktListe.get(key)))
//                    {
//                        wareDa =  false;
//                    }
//                }
//                if(wareDa) PersistenzManager.getInstance().access(ReserviertListener.class, reserviertListenerNr).fuehreAktionAus();
//            }
//        };

        PersistenzManager.getInstance().create(lagerListener);

        Map<String, Integer> produktListe = angebot.getProduktListe();
        for(String key : produktListe.keySet())
        {
            if(!istLagerBestandAusreichend(key, produktListe.get(key)))
            {
                warenDa =  false;
                //Einkauf muss Ware bestellen und bestellnummer zurückgeben
                String bestellNr = "BEST-"+ UUID.randomUUID();
                //produktRepository.schreibeFuerWareGeliefertEventEin(bestellnummer, listener);
                bestellListenerMap.put(bestellNr, lagerListener);
            }
        }
        if(warenDa) PersistenzManager.getInstance().access(ReserviertListener.class, reserviertListenerNr).fuehreAktionAus();

    }


    public boolean istLagerBestandAusreichend(String produktNr, int Menge) {
        ProduktTyp produkt = getProduktZuID(produktNr);
        if(produkt.getLagerbestand()>Menge)return true;
        return false;
    }

    public ProduktTyp getProduktZuID(String produktNr) {
        return produktRepository.getProduktZuID(produktNr).holeProduktTyp();
    }

    public WareneingangsmeldungTyp getWareneingangsmeldungZuID(String wareneingangsmeldungsNr) {
        return wareneingangsmeldungRepository.getWareneingangsmeldungZuID(wareneingangsmeldungsNr);
    }

}
