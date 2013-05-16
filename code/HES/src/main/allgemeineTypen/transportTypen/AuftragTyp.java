package main.allgemeineTypen.transportTypen;

import java.util.Date;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 12:56
 */
public class AuftragTyp {

    private String auftragsNr, angebotsNr;
    private boolean istAbgeschlossen;
    private Date beaufragtAm;

    public String getAuftragsNr() {
        return auftragsNr;
    }

    public void setAuftragsNr(String auftragsNr) {
        this.auftragsNr = auftragsNr;
    }

    public String getAngebotsNr() {
        return angebotsNr;
    }

    public void setAngebotsNr(String angebotsNr) {
        this.angebotsNr = angebotsNr;
    }

    public boolean getIstAbgeschlossen() {
        return istAbgeschlossen;
    }

    public void setIstAbgeschlossen(boolean istAbgeschlossen) {
        this.istAbgeschlossen = istAbgeschlossen;
    }

    public Date getBeaufragtAm() {
        return beaufragtAm;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AuftragTyp{");
        sb.append("auftragsNr='").append(auftragsNr).append('\'');
        sb.append(", angebotsNr='").append(angebotsNr).append('\'');
        sb.append(", istAbgeschlossen=").append(istAbgeschlossen);
        sb.append(", beaufragtAm=").append(beaufragtAm);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuftragTyp that = (AuftragTyp) o;

        if (istAbgeschlossen != that.istAbgeschlossen) return false;
        if (angebotsNr != null ? !angebotsNr.equals(that.angebotsNr) : that.angebotsNr != null) return false;
        if (auftragsNr != null ? !auftragsNr.equals(that.auftragsNr) : that.auftragsNr != null) return false;
        if (beaufragtAm != null ? !beaufragtAm.equals(that.beaufragtAm) : that.beaufragtAm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = auftragsNr != null ? auftragsNr.hashCode() : 0;
        result = 31 * result + (angebotsNr != null ? angebotsNr.hashCode() : 0);
        result = 31 * result + (istAbgeschlossen ? 1 : 0);
        result = 31 * result + (beaufragtAm != null ? beaufragtAm.hashCode() : 0);
        return result;
    }

    public void setBeaufragtAm(Date beaufragtAm) {

        this.beaufragtAm = beaufragtAm;
    }
    public AuftragTyp(String angebotsNr, boolean istAbgeschlossen, Date beaufragtAm) {
        this.angebotsNr = angebotsNr;
        this.istAbgeschlossen = istAbgeschlossen;
        this.beaufragtAm = beaufragtAm;
    }
    public AuftragTyp(String auftragsNr, String angebotsNr, boolean istAbgeschlossen, Date beaufragtAm) {
        this.auftragsNr = auftragsNr;
        this.angebotsNr = angebotsNr;
        this.istAbgeschlossen = istAbgeschlossen;
        this.beaufragtAm = beaufragtAm;
    }
}
