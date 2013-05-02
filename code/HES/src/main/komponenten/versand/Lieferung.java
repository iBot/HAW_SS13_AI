package main.komponenten.versand;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.LieferungTyp;
import main.technik.persistenzManager.IPersistierbar;

import javax.persistence.*;
import java.util.UUID;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:54
 */
@Entity
@Table(name = "lieferung")
class Lieferung implements IPersistierbar {

    @Id
    private String lieferungNr;

    @OneToOne(cascade = CascadeType.ALL)
    private Transportauftrag transportauftrag;

    private String auftragsNr;
    boolean lieferungErfolgt;


    Lieferung() {
    }

    Lieferung(AuftragTyp auftrag) {
        this.auftragsNr = auftrag.getAuftragsNr();
        lieferungNr = "LIEFERUNG-"+ UUID.randomUUID();
        lieferungErfolgt = true;
    }

    public Lieferung(AuftragTyp auftrag, Transportauftrag transportauftrag) {
        this(auftrag);
        this.transportauftrag = transportauftrag;
    }

    //Getter und Setter
    String getLieferungNr() {

        return lieferungNr;
    }

    private void setLieferungNr(String lieferungNr) {
        this.lieferungNr = lieferungNr;
    }

    boolean getLieferungErfolgt() {
        return lieferungErfolgt;
    }

    private void setLieferungErfolgt(boolean lieferungErfolgt) {
        this.lieferungErfolgt = lieferungErfolgt;
    }

    String getAuftragsNr() {
        return auftragsNr;
    }

    private void setAuftragsNr(String auftragsNr) {
        this.auftragsNr = auftragsNr;
    }

    Transportauftrag getTransportauftrag() {
        return transportauftrag;
    }

    void setTransportauftrag(Transportauftrag transportauftrag) {
        this.transportauftrag = transportauftrag;
    }

    public LieferungTyp holeLieferungTyp(){
        String taNr = null;
        if (transportauftrag!=null){
            taNr = transportauftrag.getTransportAuftragNr();
        }
        return new LieferungTyp(lieferungNr,taNr,lieferungErfolgt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lieferung lieferung = (Lieferung) o;

        if (!lieferungNr.equals(lieferung.lieferungNr)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return lieferungNr.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Lieferung{");
        sb.append("lieferungNr='").append(lieferungNr).append('\'');
        sb.append(", transportauftrag=").append(transportauftrag);
        sb.append(", auftragsNr='").append(auftragsNr).append('\'');
        sb.append(", lieferungErfolgt=").append(lieferungErfolgt);
        sb.append('}');
        return sb.toString();
    }


}
