package main.komponenten.verkauf;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.allgemeineTypen.transportTypen.KundenTyp;
import main.allgemeineTypen.transportTypen.ProduktTyp;
import main.komponenten.lager.ILagerManager;

import java.util.Date;
import java.util.Map;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:49
 */
class AngebotLogik {
     private  AngebotRepository angebotRepository;
    private ILagerManager lager;

    AngebotLogik(ILagerManager lager) {
        this.lager=lager;
        this.angebotRepository = new AngebotRepository();
    }

    public AngebotTyp erstelleAngebot(String kundenNr, Date gueltigBis, Date gueltigAb, Map<String,Integer> produktListe) {
        double gesamtpreis = 0.0;
        for(Map.Entry<String,Integer> entry : produktListe.entrySet()){
            ProduktTyp produkt = lager.getProduktZuID(entry.getKey());
            gesamtpreis += produkt.getPreis() * entry.getValue();
        }
        return this.angebotRepository.erstelleAngebot(kundenNr, gueltigBis, gueltigAb, produktListe,gesamtpreis);
    }

    public AngebotTyp getAngebotZuID(String angebotNr) {
        return this.angebotRepository.getAngebotZuID(angebotNr);
    }
}
