package main.komponenten.verkauf;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.technik.persistenzManager.IPersistierbar;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:50
 */
@Entity
@Table(name = "auftrag")
class Auftrag implements IPersistierbar {

    @Id
    private String auftragsNr;

    private String angebotsNr;

    private boolean istAbgeschlossen;
    private Date beaufragtAm;

    private Auftrag() {
    }

    public Auftrag(AngebotTyp angebot) {
        this.angebotsNr = angebot.getAngebotNr();
        this.auftragsNr = "AUFT-"+ UUID.randomUUID();
        this.istAbgeschlossen = false;
        this.beaufragtAm = new Date();

    }

    String getAuftragsNr() {

        return auftragsNr;
    }

    void setAuftragsNr(String auftragsNr) {
        this.auftragsNr = auftragsNr;
    }

    String getAngebotsNr() {
        return angebotsNr;
    }

    void setAngebotsNr(String angebotsNr) {
        this.angebotsNr = angebotsNr;
    }

    boolean isIstAbgeschlossen() {
        return istAbgeschlossen;
    }

    void setIstAbgeschlossen(boolean istAbgeschlossen) {
        this.istAbgeschlossen = istAbgeschlossen;
    }

    Date getBeaufragtAm() {
        return beaufragtAm;
    }

    void setBeaufragtAm(Date beaufragtAm) {
        this.beaufragtAm = beaufragtAm;
    }

    public AuftragTyp getAuftragTyp() {
        return new AuftragTyp(auftragsNr, angebotsNr, istAbgeschlossen, new Date(beaufragtAm.getTime()));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Auftrag{");
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

        Auftrag auftrag = (Auftrag) o;

        if (!auftragsNr.equals(auftrag.auftragsNr)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return auftragsNr.hashCode();
    }
}
