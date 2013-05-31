package main.allgemeineTypen.transportTypen;

import java.io.Serializable;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:03
 */
public class KundenTyp  implements Serializable {
    private String kundenNr;
    private String name;
    private String adresse;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("KundenTyp{");
        sb.append("kundenNr='").append(kundenNr).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", adresse='").append(adresse).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KundenTyp kundenTyp = (KundenTyp) o;

        if (adresse != null ? !adresse.equals(kundenTyp.adresse) : kundenTyp.adresse != null) return false;
        if (name != null ? !name.equals(kundenTyp.name) : kundenTyp.name != null) return false;
        if (kundenNr != null ? !kundenNr.equals(kundenTyp.kundenNr) : kundenTyp.kundenNr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kundenNr != null ? kundenNr.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        return result;
    }

    public KundenTyp(String kundenNr, String name, String adresse) {
        this.kundenNr = kundenNr;
        this.name = name;
        this.adresse = adresse;
    }

    public KundenTyp(String name, String adresse) {
        this.name = name;
        this.adresse = adresse;
    }

    public String getKundenNr() {
        return kundenNr;
    }

    public void setKundenNr(String kundenNr) {
        this.kundenNr = kundenNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
