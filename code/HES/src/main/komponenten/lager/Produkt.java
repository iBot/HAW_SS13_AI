package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.ProduktTyp;
import main.technik.persistenzManager.IPersistierbar;

import java.util.UUID;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:39
 */
class Produkt implements IPersistierbar {

    String produktNr;
    String name;
    int lagerbestand;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Produkt{");
        sb.append("produktNr='").append(produktNr).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", lagerbestand=").append(lagerbestand);
        sb.append('}');
        return sb.toString();
    }

    String getProduktNr() {
        return produktNr;
    }

    void setProduktNr(String produktNr) {
        this.produktNr = produktNr;
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

    Produkt() {

    }

    Produkt(String name) {
        this.produktNr = "PROD-"+ UUID.randomUUID();
        this.name = name;
        this.lagerbestand = 1000000;
    }

    public void erhoeheLagerbestand(int menge) {
        this.lagerbestand += menge;
    }

    public void verringereLagerbestand(int menge) {
        this.lagerbestand -= menge;
    }

    public ProduktTyp getProduktTyp() {
        return new ProduktTyp(produktNr,name,lagerbestand);
    }
}
