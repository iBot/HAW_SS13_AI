package main.allgemeineTypen.transportTypen;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 02.05.13
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */
public class WarenausgangsmeldungTyp  implements Serializable {
    String warenausgangsmeldungsNr;
    Date datum;
    int menge;


    public WarenausgangsmeldungTyp(String warenausgangsmeldungsNr, Date datum, int menge)
    {
        this.warenausgangsmeldungsNr = warenausgangsmeldungsNr;
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
    public String toString() {
        return "WarenausgangsmeldungTyp{" +
                "warenausgangsmeldungsNr='" + warenausgangsmeldungsNr + '\'' +
                ", datum=" + datum +
                ", menge=" + menge +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WarenausgangsmeldungTyp that = (WarenausgangsmeldungTyp) o;

        if (menge != that.menge) return false;
        if (datum != null ? !datum.equals(that.datum) : that.datum != null) return false;
        if (warenausgangsmeldungsNr != null ? !warenausgangsmeldungsNr.equals(that.warenausgangsmeldungsNr) : that.warenausgangsmeldungsNr != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = warenausgangsmeldungsNr != null ? warenausgangsmeldungsNr.hashCode() : 0;
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        result = 31 * result + menge;
        return result;
    }
}
