package main.komponenten.verkauf;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.technik.persistenzManager.IPersistierbar;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:50
 */
@Entity
@Table(name = "angebot")
class Angebot implements IPersistierbar {

    @Id
    private String angebotNr;

    private String kundenNr;
    private Date gueltigBis, gueltigAb;
    private double gesamtpreis;

    @ElementCollection( fetch = FetchType.EAGER)
    private Map<String, Integer> produktListe;


    public Angebot(String kundenNr, Date gueltigBis, Date gueltigAb, Map<String, Integer> produktListe, double gesamtpreis) {
        this.angebotNr = "ANG-" + UUID.randomUUID();
        this.kundenNr = kundenNr;
        this.gueltigAb = gueltigAb;
        this.gueltigBis = gueltigBis;
        this.produktListe = new HashMap<>(produktListe);
        this.gesamtpreis = gesamtpreis;
    }

    private Angebot() {

    }


    public AngebotTyp holeAngebotTyp() {
        return new AngebotTyp(angebotNr, kundenNr, new Date(gueltigBis.getTime()), new Date(gueltigAb.getTime()), new HashMap<>(produktListe),gesamtpreis);
    }

    //Getter und Setter
    String getAngebotNr() {
        return angebotNr;
    }

    private void setAngebotNr(String angebotNr) {
        this.angebotNr = angebotNr;
    }

    String getKundenNr() {
        return kundenNr;
    }

    private void setKundenNr(String kundenNr) {
        this.kundenNr = kundenNr;
    }

    Date getGueltigBis() {
        return gueltigBis;
    }

    private void setGueltigBis(Date gueltigBis) {
        this.gueltigBis = gueltigBis;
    }

    Date getGueltigAb() {
        return gueltigAb;
    }

    private void setGueltigAb(Date gueltigAb) {
        this.gueltigAb = gueltigAb;
    }

    Map<String, Integer> getProduktListe() {
        return produktListe;
    }

    private void setProduktListe(Map<String, Integer> produktListe) {
        this.produktListe = produktListe;
    }

    double getGesamtpreis() {
        return gesamtpreis;
    }

    private void setGesamtpreis(double gesamtpreis) {
        this.gesamtpreis = gesamtpreis;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Angebot{");
        sb.append("angebotNr='").append(angebotNr).append('\'');
        sb.append(", kundenNr='").append(kundenNr).append('\'');
        sb.append(", gueltigBis=").append(gueltigBis);
        sb.append(", gueltigAb=").append(gueltigAb);
        sb.append(", gesamtpreis=").append(gesamtpreis);
        sb.append(", produktListe=").append(produktListe);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Angebot angebot = (Angebot) o;

        if (!angebotNr.equals(angebot.angebotNr)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return angebotNr.hashCode();
    }

}
