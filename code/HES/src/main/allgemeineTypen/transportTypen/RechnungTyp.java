package main.allgemeineTypen.transportTypen;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 21.04.13
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */
public class RechnungTyp {
    private String rechnungsNr;
    private boolean istBezahlt;
    private Date rechnungsDatum;

    public RechnungTyp(boolean istBezahlt, Date rechnungsDatum) {

        this.istBezahlt = istBezahlt;
        this.rechnungsDatum = rechnungsDatum;
    }

    public RechnungTyp(String rechnungsNr, boolean istBezahlt, Date rechnungsDatum) {

        this.rechnungsNr = rechnungsNr;
        this.istBezahlt = istBezahlt;
        this.rechnungsDatum = rechnungsDatum;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RechnungTyp{");
        sb.append("rechnungsNr='").append(rechnungsNr).append('\'');
        sb.append(", istBezahlt=").append(istBezahlt);
        sb.append(", rechnungsDatum=").append(rechnungsDatum);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RechnungTyp that = (RechnungTyp) o;

        if (istBezahlt != that.istBezahlt) return false;
        if (rechnungsDatum != null ? !rechnungsDatum.equals(that.rechnungsDatum) : that.rechnungsDatum != null)
            return false;
        if (rechnungsNr != null ? !rechnungsNr.equals(that.rechnungsNr) : that.rechnungsNr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rechnungsNr != null ? rechnungsNr.hashCode() : 0;
        result = 31 * result + (istBezahlt ? 1 : 0);
        result = 31 * result + (rechnungsDatum != null ? rechnungsDatum.hashCode() : 0);
        return result;
    }

    public String getRechnungsNr() {
        return rechnungsNr;
    }

    public void setRechnungsNr(String rechnungsNr) {
        this.rechnungsNr = rechnungsNr;
    }

    public boolean isIstBezahlt() {
        return istBezahlt;
    }

    public void setIstBezahlt(boolean istBezahlt) {
        this.istBezahlt = istBezahlt;
    }

    public Date getRechnungsDatum() {
        return rechnungsDatum;
    }

    public void setRechnungsDatum(Date rechnungsDatum) {
        this.rechnungsDatum = rechnungsDatum;
    }
}
