package main.allgemeineTypen.transportTypen;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:02
 */
public class AngebotTyp {
    private String angebotNr, kundenNr;
    private Date gueltigBis, gueltigAb;
    private Map<String, Integer> produktListe;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AngebotTyp{");
        sb.append("angebotNr='").append(angebotNr).append('\'');
        sb.append(", kundenNr='").append(kundenNr).append('\'');
        sb.append(", gueltigBis=").append(gueltigBis);
        sb.append(", gueltigAb=").append(gueltigAb);
        sb.append(", produktListe=").append(produktListe);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AngebotTyp that = (AngebotTyp) o;

        if (angebotNr != null ? !angebotNr.equals(that.angebotNr) : that.angebotNr != null) return false;
        if (gueltigAb != null ? !gueltigAb.equals(that.gueltigAb) : that.gueltigAb != null) return false;
        if (gueltigBis != null ? !gueltigBis.equals(that.gueltigBis) : that.gueltigBis != null) return false;
        if (kundenNr != null ? !kundenNr.equals(that.kundenNr) : that.kundenNr != null) return false;
        if (produktListe != null ? !produktListe.equals(that.produktListe) : that.produktListe != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = angebotNr != null ? angebotNr.hashCode() : 0;
        result = 31 * result + (kundenNr != null ? kundenNr.hashCode() : 0);
        result = 31 * result + (gueltigBis != null ? gueltigBis.hashCode() : 0);
        result = 31 * result + (gueltigAb != null ? gueltigAb.hashCode() : 0);
        result = 31 * result + (produktListe != null ? produktListe.hashCode() : 0);
        return result;
    }

    public String getAngebotNr() {

        return angebotNr;
    }

    public void setAngebotNr(String angebotNr) {
        this.angebotNr = angebotNr;
    }

    public String getKundenNr() {
        return kundenNr;
    }

    public void setKundenNr(String kundenNr) {
        this.kundenNr = kundenNr;
    }

    public Date getGueltigBis() {
        return gueltigBis;
    }

    public void setGueltigBis(Date gueltigBis) {
        this.gueltigBis = gueltigBis;
    }

    public Date getGueltigAb() {
        return gueltigAb;
    }

    public void setGueltigAb(Date gueltigAb) {
        this.gueltigAb = gueltigAb;
    }

    public Map<String, Integer> getProduktListe() {
        return produktListe;
    }

    public void setProduktListe(Map<String, Integer> produktListe) {
        this.produktListe = produktListe;
    }

    public AngebotTyp(String kundenNr, Date gueltigBis, Date gueltigAb, Map<String, Integer> produktListe) {
        this.kundenNr = kundenNr;
        this.gueltigAb = gueltigAb;
        this.gueltigBis = gueltigBis;
        this.produktListe = new HashMap<>(produktListe);
    }

    public AngebotTyp(String angebotNr, String kundenNr, Date gueltigBis, Date gueltigAb, Map<String, Integer> produktListe) {
        this.angebotNr = angebotNr;
        this.kundenNr = kundenNr;
        this.gueltigAb = gueltigAb;
        this.gueltigBis = gueltigBis;
        this.produktListe = new HashMap<>(produktListe);
    }

}
