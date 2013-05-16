package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.WareneingangsmeldungTyp;
import main.technik.persistenzManager.IPersistierbar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:39
 */
@Entity
@Table(name = "wareneingangsmeldung")
class Wareneingangsmeldung implements IPersistierbar {

    String wareneingsmeldungNr;
    String lieferscheinNr;
    Date datum;

    Wareneingangsmeldung(String lieferscheinNr, Date datum) {
        this.wareneingsmeldungNr = "WEM-"+ UUID.randomUUID();
        this.lieferscheinNr = lieferscheinNr;
        this.datum = datum;
    }

    Wareneingangsmeldung() {
    }


    @Id
    String getWareneingsmeldungNr() {
        return wareneingsmeldungNr;
    }

    private void setWareneingsmeldungNr(String wareneingsmeldungNr) {
        this.wareneingsmeldungNr = wareneingsmeldungNr;
    }

    String getLieferscheinNr() {
        return lieferscheinNr;
    }

    private void setLieferscheinNr(String lieferscheinNr) {
        this.lieferscheinNr = lieferscheinNr;
    }

    Date getDatum() {
        return datum;
    }

    private void setDatum(Date datum) {
        this.datum = datum;
    }


    WareneingangsmeldungTyp holeWareneingangsmeldungTyp(){
        return new WareneingangsmeldungTyp(wareneingsmeldungNr, lieferscheinNr, new Date(datum.getTime()));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wareneingangsmeldung that = (Wareneingangsmeldung) o;

        if (!wareneingsmeldungNr.equals(that.wareneingsmeldungNr)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return wareneingsmeldungNr.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Wareneingangsmeldung{");
        sb.append("wareneingsmeldungNr='").append(wareneingsmeldungNr).append('\'');
        sb.append(", lieferscheinNr='").append(lieferscheinNr).append('\'');
        sb.append(", datum=").append(datum);
        sb.append('}');
        return sb.toString();
    }
}
