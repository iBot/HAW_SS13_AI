package main.komponenten.kunden;

import main.allgemeineTypen.transportTypen.KundenTyp;
import main.technik.persistenzManager.IPersistierbar;

import javax.persistence.*;
import java.util.UUID;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:33
 */
@Entity
@Table(name = "kunde")
class Kunde implements IPersistierbar {

    @Id
    private String kundenNr;

    private String name;
    private String adresse;

    private Kunde() {
    }

    public Kunde(String name, String adresse) {
        this.kundenNr = "KUN-"+ UUID.randomUUID();
        this.name = name;
        this.adresse = adresse;
    }

    public KundenTyp getKundenTyp() {
        return new KundenTyp(kundenNr, name, adresse);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kunde kunde = (Kunde) o;

        if (!kundenNr.equals(kunde.kundenNr)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return kundenNr.hashCode();
    }

    String getKundenNr() {
        return kundenNr;
    }

    void setKundenNr(String kundenNr) {
        this.kundenNr = kundenNr;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getAdresse() {
        return adresse;
    }

    void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Kunde{");
        sb.append("kundenNr='").append(kundenNr).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", adresse='").append(adresse).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
