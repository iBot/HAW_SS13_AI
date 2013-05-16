package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.*;

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

    LagerLogik() {
        this.produktRepository = new ProduktRepository();
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

        if (bestellListenerMap.containsKey(bestellNr)){
            bestellListenerMap.get(bestellNr).fuehreAktionAus(produkt);
        }
    }

    //Um euren Fehler, dessen Namen ich nicht weiß :P, hier zu vermeiden habe ich jetzt zwei Listener benutzt. Der eine kommt vom
    //Auftrag und wartet darauf dass die Ware reservier ist. Der andere wird im Lager selbst angelegt und wartet darauf dass die
    //Ware da ist um sie anschließend zu reservieren. So schließen wir aus, das nachdem die Ware da ist jemand anders sie benutzt
    //bevor wir sie reservieren können. ODER??????
    public void reserviereProdukteFuerAuftrag(final AngebotTyp angebot, final IReserviertListener reserviertListener) {
        boolean warenDa = true;
        //listener  --->>>>>> richtig kack lösung!!!!
        ILagerListener listener = new ILagerListener() {
            @Override
            public void fuehreAktionAus(Produkt produkt) {
                produktRepository.reserviereProduktFuerAuftrag(produkt, angebot);

                boolean wareDa = true;
                Map<String, Integer> produktListe = angebot.getProduktListe();
                for(String key : produktListe.keySet())
                {
                    if(!istLagerBestandAusreichend(key, produktListe.get(key)))
                    {
                        wareDa =  false;
                    }
                }
                if(wareDa) reserviertListener.fuehreAktionAus();
            }
        };

        Map<String, Integer> produktListe = angebot.getProduktListe();
        for(String key : produktListe.keySet())
        {
            if(!istLagerBestandAusreichend(key, produktListe.get(key)))
            {
                warenDa =  false;
                //Einkauf muss Ware bestellen und bestellnummer zurückgeben
                String bestellNr = "BEST-"+ UUID.randomUUID();
                //produktRepository.schreibeFuerWareGeliefertEventEin(bestellnummer, listener);
                bestellListenerMap.put(bestellNr, listener);
            }
        }
        if(warenDa) reserviertListener.fuehreAktionAus();

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
