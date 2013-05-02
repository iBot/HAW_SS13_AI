package main.komponenten.lager;

import main.technik.persistenzManager.IPersistierbar;
import main.allgemeineTypen.transportTypen.WarenausgangsmeldungTyp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:39
 */
@Entity
@Table(name = "warenausgangsmeldung")
class Warenausgangsmeldung implements IPersistierbar {
    String warenausgangsmeldungsNr;
    Date datum;
    int menge;

    public Warenausgangsmeldung() {
    }

    public Warenausgangsmeldung(Date datum, int menge) {
        this.warenausgangsmeldungsNr = "WAM-"+ UUID.randomUUID();
        this.datum = datum;
        this.menge = menge;
    }

    //Getter und Setter
    @Id
    public String getWarenausgangsmeldungsNr() {
        return warenausgangsmeldungsNr;
    }

    private void setWarenausgangsmeldungsNr(String warenausgangsmeldungsNr) {
        this.warenausgangsmeldungsNr = warenausgangsmeldungsNr;
    }

    public Date getDatum() {
        return datum;
    }

    private void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getMenge() {
        return menge;
    }

    private void setMenge(int menge) {
        this.menge = menge;
    }

    public WarenausgangsmeldungTyp holeWarenausgangsmeldungTyp()
    {
        return new WarenausgangsmeldungTyp(warenausgangsmeldungsNr, datum, menge);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Warenausgangsmeldung that = (Warenausgangsmeldung) o;

        if (!warenausgangsmeldungsNr.equals(that.warenausgangsmeldungsNr)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return warenausgangsmeldungsNr.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WarenausgangsmeldungRepository{");
        sb.append("warenausgangsmeldungsNr='").append(warenausgangsmeldungsNr).append('\'');
        sb.append(", datum=").append(datum);
        sb.append(", menge=").append(menge);
        sb.append('}');
        return sb.toString();
    }
}
