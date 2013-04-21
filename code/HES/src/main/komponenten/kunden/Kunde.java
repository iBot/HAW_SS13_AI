package main.komponenten.kunden;

import main.allgemeineTypen.transportTypen.KundenTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:33
 */
class Kunde {
    private String kundenNr;
    private String name;
    private String adresse;

    Kunde() {
    }

    Kunde(String name, String adresse) {
        this.name = name;
        this.adresse = adresse;
    }

    KundenTyp getKundenTyp() {
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
}
