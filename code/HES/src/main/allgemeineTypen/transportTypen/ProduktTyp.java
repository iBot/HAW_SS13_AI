package main.allgemeineTypen.transportTypen;

import java.io.Serializable;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:00
 */
public class ProduktTyp  implements Serializable {
    String produktNr;
    String name;
    int lagerbestand;

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    double preis;

    public ProduktTyp(String name, int lagerbestand, double preis) {
        this.name = name;
        this.lagerbestand = lagerbestand;
        this.preis = preis;
    }

    public ProduktTyp(String produktNr, String name, int lagerbestand, double preis) {
        this.produktNr = produktNr;
        this.name = name;
        this.lagerbestand = lagerbestand;
        this.preis = preis;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProduktTyp{");
        sb.append("produktNr='").append(produktNr).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", lagerbestand=").append(lagerbestand);
        sb.append(", preis=").append(preis);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProduktTyp that = (ProduktTyp) o;

        if (lagerbestand != that.lagerbestand) return false;
        if (Double.compare(that.preis, preis) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (produktNr != null ? !produktNr.equals(that.produktNr) : that.produktNr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = produktNr != null ? produktNr.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + lagerbestand;
        temp = Double.doubleToLongBits(preis);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getProduktNr() {

        return produktNr;
    }

    public void setProduktNr(String produktNr) {
        this.produktNr = produktNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLagerbestand() {
        return lagerbestand;
    }

    public void setLagerbestand(int lagerbestand) {
        this.lagerbestand = lagerbestand;
    }

    public ProduktTyp(String name, int lagerbestand) {

        this.name = name;
        this.lagerbestand = lagerbestand;
    }
}
