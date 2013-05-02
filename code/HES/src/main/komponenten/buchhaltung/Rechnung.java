package main.komponenten.buchhaltung;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.RechnungTyp;
import main.technik.persistenzManager.IPersistierbar;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:25
 */
@Entity
@Table(name = "rechnung")
class Rechnung implements IPersistierbar {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Zahlungseingang> zahlungseingaenge;
    @Id
    private String rechnungsNr;
    private boolean istBezahlt;
    private Date rechnungsDatum;
    private String auftragsNr;

    double getGesamtbetrag() {
        return gesamtbetrag;
    }

    void setGesamtbetrag(double gesamtbetrag) {
        this.gesamtbetrag = gesamtbetrag;
    }

    private double gesamtbetrag;


    Rechnung(double gesamtbetrag, AuftragTyp auftrag) {
        this.rechnungsNr = "RE-"+ UUID.randomUUID();
        this.zahlungseingaenge = new ArrayList<>();
        this.istBezahlt = false;
        this.rechnungsDatum = new Date();
        this.gesamtbetrag = gesamtbetrag;
        this.auftragsNr = auftrag.getAuftragsNr();

    }

    private Rechnung() {
    }

    void zahlungseingangHinzufuegen(Zahlungseingang zahlungseingang) {
        zahlungseingaenge.add(zahlungseingang);
        double summe = gesamtbetrag;
        for (Zahlungseingang ze : zahlungseingaenge){
            summe -= ze.getBetrag();
        }
        if (summe<=0){
            istBezahlt=true;
        }
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

    String getAuftragsNr() {
        return auftragsNr;
    }

    void setAuftragsNr(String auftragsNr){
        this.auftragsNr = auftragsNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rechnung rechnung = (Rechnung) o;

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
        return new RechnungTyp(rechnungsNr, istBezahlt, new Date(rechnungsDatum.getTime()),auftragsNr,gesamtbetrag);
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
