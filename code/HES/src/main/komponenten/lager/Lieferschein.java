package main.komponenten.lager;

import main.technik.persistenzManager.IPersistierbar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 23.04.13
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "lieferschein")
public class Lieferschein implements IPersistierbar{

    private String lieferscheinNr;
    private int menge;
    String produktNr;

    public Lieferschein() {
    }

    public Lieferschein(String lieferscheinNr, int menge, String produktNr) {
        this.lieferscheinNr = lieferscheinNr;
        this.menge = menge;
        this.produktNr = produktNr;
    }

    public Lieferschein(int menge, String produktNr) {
        this.lieferscheinNr = "LISCH-"+ UUID.randomUUID();
        this.menge = menge;
        this.produktNr = produktNr;
    }


    @Id
    public String getLieferscheinNr() {
        return lieferscheinNr;
    }

    private void setLieferscheinNr(String lieferscheinNr) {
        this.lieferscheinNr = lieferscheinNr;
    }

    public int getMenge() {

        return menge;
    }

    private void setMenge(int menge) {
        this.menge = menge;
    }

    public String getProduktNr() {
        return produktNr;
    }

    private void setProduktNr(String produktNr) {
        this.produktNr = produktNr;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lieferschein that = (Lieferschein) o;

        if (menge != that.menge) return false;
        if (!lieferscheinNr.equals(that.lieferscheinNr)) return false;
        if (!produktNr.equals(that.produktNr)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lieferscheinNr.hashCode();
        result = 31 * result + menge;
        result = 31 * result + produktNr.hashCode();
        return result;
    }


}
