package main.allgemeineTypen.transportTypen;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 23.04.13
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
public class LieferscheinTyp  implements Serializable {

    private String lieferscheinNr;
    private String produktNr;
    private int menge;

    public String getProduktNr() {
        return produktNr;
    }

    public void setProduktNr(String produktNr) {
        this.produktNr = produktNr;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LieferscheinTyp{");
        sb.append("lieferscheinNr='").append(lieferscheinNr).append('\'');
        sb.append(", menge=").append(menge);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LieferscheinTyp that = (LieferscheinTyp) o;

        if (menge != that.menge) return false;
        if (lieferscheinNr != null ? !lieferscheinNr.equals(that.lieferscheinNr) : that.lieferscheinNr != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lieferscheinNr != null ? lieferscheinNr.hashCode() : 0;
        result = 31 * result + menge;
        return result;
    }

    public String getLieferscheinNr() {

        return lieferscheinNr;
    }

    public void setLieferscheinNr(String lieferscheinNr) {
        this.lieferscheinNr = lieferscheinNr;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public LieferscheinTyp(int menge) {

        this.menge = menge;
    }

    public LieferscheinTyp(String lieferscheinNr, int menge) {

        this.lieferscheinNr = lieferscheinNr;
        this.menge = menge;
    }
}
