package main.allgemeineTypen.transportTypen;

import java.io.Serializable;
import java.util.Date;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:00
 */
public class WareneingangsmeldungTyp  implements Serializable {
    String wareneingsmeldungNr;
    String lieferscheinNr;
    Date datum;

    public WareneingangsmeldungTyp(String wareneingsmeldungNr, String lieferscheinNr, Date datum) {
        this.wareneingsmeldungNr = wareneingsmeldungNr;
        this.lieferscheinNr = lieferscheinNr;
        this.datum = datum;
    }

    public WareneingangsmeldungTyp() {
    }

    public String getLieferscheinNr() {
        return lieferscheinNr;
    }

    public void setLieferscheinNr(String lieferscheinNr) {
        this.lieferscheinNr = lieferscheinNr;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WareneingangsmeldungTyp{");
        sb.append("wareneingsmeldungNr='").append(wareneingsmeldungNr).append('\'');
        sb.append(", lieferscheinNr='").append(lieferscheinNr).append('\'');
        sb.append(", datum=").append(datum);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WareneingangsmeldungTyp that = (WareneingangsmeldungTyp) o;

        if (datum != null ? !datum.equals(that.datum) : that.datum != null) return false;
        if (lieferscheinNr != null ? !lieferscheinNr.equals(that.lieferscheinNr) : that.lieferscheinNr != null)
            return false;
        if (wareneingsmeldungNr != null ? !wareneingsmeldungNr.equals(that.wareneingsmeldungNr) : that.wareneingsmeldungNr != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = wareneingsmeldungNr != null ? wareneingsmeldungNr.hashCode() : 0;
        result = 31 * result + (lieferscheinNr != null ? lieferscheinNr.hashCode() : 0);
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        return result;
    }

    public String getWareneingsmeldungNr() {

        return wareneingsmeldungNr;
    }

    public void setWareneingsmeldungNr(String wareneingsmeldungNr) {
        this.wareneingsmeldungNr = wareneingsmeldungNr;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }


}
