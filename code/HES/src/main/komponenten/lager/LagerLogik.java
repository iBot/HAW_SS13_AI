package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.*;

import java.util.Map;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:34
 */
class LagerLogik {


    private ProduktRepository produktRepository;
    private WarenausgangsmeldungRepository warenausgangsmeldungRepository;
    private WareneingangsmeldungRepository wareneingangsmeldungRepository;

    public void schreibeFuerWarenReserviertEventEin(AngebotTyp angebot, ILagerListener listener) {
        boolean wareDa = true;
        Map<String, Integer> produktListe = angebot.getProduktListe();
        for(String key : produktListe.keySet())
        {
            if(!istLagerBestandAusreichend(key, produktListe.get(key)))
            {
                wareDa =  false;
                produktRepository.schreibeFuerWarenReserviertEventEin(angebot, listener);
                break;
            }
        }
        if(wareDa) listener.fuehreAktionAus();
    }

    public ProduktTyp erstelleProdukt(String produktName) {
        return produktRepository.erstelleProdukt(produktName);
    }

    public void bucheWareneingang(LieferscheinTyp lieferschein) {
        produktRepository.bucheWareneingang(lieferschein);
    }

    public void reserviereProdukteFuerAuftrag(AuftragTyp auftrag, AngebotTyp angebot) {
        produktRepository.reserviereProdukteFuerAuftrag(auftrag, angebot);
    }

    public ProduktTyp getProduktZuID(String produktNr) {
        return produktRepository.getProduktZuID(produktNr);
    }

    public WareneingangsmeldungTyp getWareneingangsmeldungZuID(String wareneingangsmeldungsNr) {
        return wareneingangsmeldungRepository.getWareneingangsmeldungZuID(wareneingangsmeldungsNr);
    }

    public boolean istLagerBestandAusreichend(String produktNr, int Menge) {
        ProduktTyp produkt = getProduktZuID(produktNr);
        if(produkt.getLagerbestand()>Menge)return true;
        return false;
    }
}
