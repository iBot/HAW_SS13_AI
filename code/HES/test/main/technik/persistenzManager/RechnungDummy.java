package main.technik.persistenzManager;

import main.allgemeineTypen.transportTypen.RechnungTyp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:25
 */
@Entity
@Table(name = "rechnungDummy")
class RechnungDummy implements IPersistierbar {

    @Id
    private String rechnungsNr;
    private boolean istBezahlt;
    private Date rechnungsDatum;
    private String auftragsNr;
    private int gesamtbetrag;

    int getGesamtbetrag() {
        return gesamtbetrag;
    }

    void setGesamtbetrag(int gesamtbetrag) {
        this.gesamtbetrag = gesamtbetrag;
    }

    RechnungDummy(int gesamtbetrag) {
        this.rechnungsNr = "RE-" + UUID.randomUUID();
        this.istBezahlt = false;
        this.rechnungsDatum = new Date();
        this.gesamtbetrag = gesamtbetrag;

    }

    private RechnungDummy() {
    }

    String getRechnungsNr() {
        return rechnungsNr;
    }

    void setRechnungsNr(String rechnungsNr) {
        this.rechnungsNr = rechnungsNr;
    }

    boolean getIstBezahlt() {
        return istBezahlt;
    }

    void setIstBezahlt(boolean istBezahlt) {
        this.istBezahlt = istBezahlt;
    }

    String getAuftragsNr() {
        return auftragsNr;
    }

    void setAuftragsNr(String auftragsNr) {
        this.auftragsNr = auftragsNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RechnungDummy rechnung = (RechnungDummy) o;

        if (!rechnungsNr.equals(rechnung.rechnungsNr)) return false;

        return true;
    }

    Date getRechnungsDatum() {

        return rechnungsDatum;
    }

    void setRechnungsDatum(Date rechnungsDatum) {
        this.rechnungsDatum = rechnungsDatum;
    }

    RechnungTyp holeRechnungTyp() {

        //TODO:
//        return new RechnungTyp(rechnungsNr, istBezahlt, new Date(rechnungsDatum.getTime()), auftragsNr);
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rechnung{");
        sb.append("rechnungsNr='").append(rechnungsNr).append('\'');
        sb.append(", istBezahlt=").append(istBezahlt);
        sb.append(", rechnungsDatum=").append(rechnungsDatum);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return rechnungsNr.hashCode();
    }

}
