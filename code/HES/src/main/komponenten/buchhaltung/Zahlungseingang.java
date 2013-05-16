package main.komponenten.buchhaltung;

import main.technik.persistenzManager.IPersistierbar;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:25
 */
@Entity
@Table(name = "zahlungseingang")
class Zahlungseingang implements IPersistierbar {

    @Id
    private String zahlungsEingangID;

    private double betrag;
    private Date eingangsdatum;


    public Zahlungseingang(double betrag) {
        this.zahlungsEingangID = "ZAHLEIN-"+ UUID.randomUUID();
        this.betrag = betrag;
        this.eingangsdatum = new Date();
    }

    Zahlungseingang() {
    }

    //Getter und Setter
    String getZahlungsEingangID() {
        return zahlungsEingangID;
    }

    private void setZahlungsEingangID(String zahlungsEingangID) {
        this.zahlungsEingangID = zahlungsEingangID;
    }

    double getBetrag() {
        return betrag;
    }

    private void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    Date getEingangsdatum() {
        return eingangsdatum;
    }

    void setEingangsdatum(Date eingangsdatum) {
        this.eingangsdatum = eingangsdatum;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zahlungseingang that = (Zahlungseingang) o;

        if (!zahlungsEingangID.equals(that.zahlungsEingangID)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return zahlungsEingangID.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Zahlungseingang{");
        sb.append("zahlungsEingangID='").append(zahlungsEingangID).append('\'');
        sb.append(", betrag=").append(betrag);
        sb.append(", eingangsdatum=").append(eingangsdatum);
        sb.append('}');
        return sb.toString();
    }
}
