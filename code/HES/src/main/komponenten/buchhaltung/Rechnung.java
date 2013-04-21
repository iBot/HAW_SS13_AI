package main.komponenten.buchhaltung;

import main.allgemeineTypen.transportTypen.RechnungTyp;
import main.technik.persistenzManager.IPersistierbar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:25
 */
class Rechnung implements IPersistierbar {

    private List<Zahlungseingang> zahlungseingaenge;
    private String rechnungsNr;
    private boolean istBezahlt;
    private Date rechnungsDatum;


    Rechnung() {
        this.zahlungseingaenge = new ArrayList<>();
        //TODO: Eindeutige RechnungsNr generieren
        this.istBezahlt = false;
        this.rechnungsDatum = new Date();
    }


    List<Zahlungseingang> getZahlungseingaenge() {
        return zahlungseingaenge;
    }

    void setZahlungseingaenge(List<Zahlungseingang> zahlungseingaenge) {
        this.zahlungseingaenge = zahlungseingaenge;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rechnung rechnung = (Rechnung) o;

        if (!rechnungsNr.equals(rechnung.rechnungsNr)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return rechnungsNr.hashCode();
    }

    Date getRechnungsDatum() {

        return rechnungsDatum;
    }

    void setRechnungsDatum(Date rechnungsDatum) {
        this.rechnungsDatum = rechnungsDatum;
    }

    RechnungTyp getRechnungTyp() {
        return new RechnungTyp(rechnungsNr, istBezahlt, new Date(rechnungsDatum.getTime()));
    }

    void zahlungseingangHinzufuegen(Zahlungseingang zahlungseingang) {
        zahlungseingaenge.add(zahlungseingang);
        //TODO: IF (Gesamtpreis des Angebots - (Summe aller ZahlungseingangBeträge) THEN setze istBezahlt = true;
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
}
