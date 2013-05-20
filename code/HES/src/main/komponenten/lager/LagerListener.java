package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.komponenten.verkauf.IVerkaufManager;
import main.komponenten.verkauf.ReserviertListener;
import main.komponenten.verkauf.VerkaufFassade;
import main.technik.persistenzManager.PersistenzManager;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 20.05.13
 * Time: 20:28
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "lagerListener")

class LagerListener implements ILagerListener {
    //Siehe TODO in LagerLogik.bucheWareneingang(...);!!!!

    private String angebotNr;
    private String reserviertListenerNr;
    @ElementCollection( fetch = FetchType.EAGER)
    private Map<String, Integer> produktListe;

    @Id
    private String lagerListenerNr;

    public LagerListener(AngebotTyp angebot, String reserviertListenerNr) {
        this.angebotNr = angebot.getAngebotNr();
        this.reserviertListenerNr = reserviertListenerNr;
        this.lagerListenerNr = "LaLi-"+ UUID.randomUUID();
        this.produktListe = angebot.getProduktListe();
    }

    @Override
    public void fuehreAktionAus(Produkt produkt) {
        ProduktRepository.getInstance().reserviereProduktFuerAuftrag(produkt, produktListe);

        boolean wareDa = true;
        for(String key : produktListe.keySet())
        {
            if(!LagerLogik.getInstance().istLagerBestandAusreichend(key, produktListe.get(key)))
            {
                wareDa =  false;
            }
        }
        if(wareDa) PersistenzManager.getInstance().access(ReserviertListener.class, reserviertListenerNr).fuehreAktionAus();
    }

    String getAngebotNr() {
        return angebotNr;
    }

    void setAngebotNr(String angebotNr) {
        this.angebotNr = angebotNr;
    }

    String getReserviertListenerNr() {
        return reserviertListenerNr;
    }

    void setReserviertListenerNr(String reserviertListenerNr) {
        this.reserviertListenerNr = reserviertListenerNr;
    }

    Map<String, Integer> getProduktListe() {
        return produktListe;
    }

    void setProduktListe(Map<String, Integer> produktListe) {
        this.produktListe = produktListe;
    }

    String getLagerListenerNr() {
        return lagerListenerNr;
    }

    void setLagerListenerNr(String lagerListenerNr) {
        this.lagerListenerNr = lagerListenerNr;
    }
}
