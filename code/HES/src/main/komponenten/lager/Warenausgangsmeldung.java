package main.komponenten.lager;

import main.technik.persistenzManager.IPersistierbar;

import java.util.Date;
import java.util.UUID;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:39
 */
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

    public String getWarenausgangsmeldungsNr() {
        return warenausgangsmeldungsNr;
    }

    public void setWarenausgangsmeldungsNr(String warenausgangsmeldungsNr) {
        this.warenausgangsmeldungsNr = warenausgangsmeldungsNr;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
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
