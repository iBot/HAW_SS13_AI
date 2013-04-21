package main.komponenten.buchhaltung;

import main.technik.persistenzManager.IPersistierbar;

import java.util.Date;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:25
 */
class Zahlungseingang implements IPersistierbar {

    private String zahlungsEingangID;
    private double betrag;
    private Date eingangsdatum;

    public Zahlungseingang(double betrag) {
        //TODO: Autogenerierte zahlungseingangsID
        this.betrag = betrag;
        this.eingangsdatum = new Date();
    }

    Zahlungseingang() {
    }

    String getZahlungsEingangID() {
        return zahlungsEingangID;
    }

    void setZahlungsEingangID(String zahlungsEingangID) {
        this.zahlungsEingangID = zahlungsEingangID;
    }

    double getBetrag() {
        return betrag;
    }

    void setBetrag(double betrag) {
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
