package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.ProduktTyp;
import main.technik.persistenzManager.IPersistierbar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:39
 */

@Entity
@Table(name = "produkt")
class Produkt implements IPersistierbar {

    String produktNr;
    String name;
    int lagerbestand;
    double preis;


    Produkt() {

    }

    Produkt(String name) {
        this.produktNr = "PROD-"+ UUID.randomUUID();
        this.name = name;
        this.lagerbestand = 1000000;
    }


    //Getter und Setter
    @Id
    String getProduktNr() {
        return produktNr;
    }

    private void setProduktNr(String produktNr) {
        this.produktNr = produktNr;
    }

    double getPreis() {
        return preis;
    }

    void setPreis(double preis) {
        this.preis = preis;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getLagerbestand() {
        return lagerbestand;
    }

    void setLagerbestand(int lagerbestand) {
        this.lagerbestand = lagerbestand;
    }


    public void erhoeheLagerbestand(int menge) {
        this.lagerbestand += menge;
    }

    public void verringereLagerbestand(int menge) {
        this.lagerbestand -= menge;
    }

    public ProduktTyp holeProduktTyp() {
        return new ProduktTyp(produktNr,name,lagerbestand,preis);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produkt produkt = (Produkt) o;

        if (!produktNr.equals(produkt.produktNr)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return produktNr.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Produkt{");
        sb.append("produktNr='").append(produktNr).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", lagerbestand=").append(lagerbestand);
        sb.append(", preis=").append(preis);
        sb.append('}');
        return sb.toString();
    }

}
