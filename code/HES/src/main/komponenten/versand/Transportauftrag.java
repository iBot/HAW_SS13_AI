package main.komponenten.versand;

import main.allgemeineTypen.transportTypen.TransportauftragTyp;
import main.technik.persistenzManager.IPersistierbar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:55
 */
@Entity
@Table(name = "transportauftrag")
class Transportauftrag implements IPersistierbar {

    @Id
    private String transportAuftragNr;
    private String transportDienstleister;
    private Date ausgangsDatum, lieferDatum;


    Transportauftrag() {
        this.transportAuftragNr = "TraAuft-"+ UUID.randomUUID();
        this.ausgangsDatum = new Date();

    }

    String getTransportAuftragNr() {
        return transportAuftragNr;
    }

    void setTransportAuftragNr(String transportAuftragNr) {
        this.transportAuftragNr = transportAuftragNr;
    }

    String getTransportDienstleister() {
        return transportDienstleister;
    }

    void setTransportDienstleister(String transportDienstleister) {
        this.transportDienstleister = transportDienstleister;
    }

    Date getAusgangsDatum() {
        return ausgangsDatum;
    }

    void setAusgangsDatum(Date ausgangsDatum) {
        this.ausgangsDatum = ausgangsDatum;
    }

    Date getLieferDatum() {
        return lieferDatum;
    }

    void setLieferDatum(Date lieferDatum) {
        this.lieferDatum = lieferDatum;
    }

    public TransportauftragTyp holeTransportauftragTyp()
    {
        return new TransportauftragTyp(transportAuftragNr, ausgangsDatum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transportauftrag that = (Transportauftrag) o;

        if (transportAuftragNr != null ? !transportAuftragNr.equals(that.transportAuftragNr) : that.transportAuftragNr != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return transportAuftragNr != null ? transportAuftragNr.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transportauftrag{");
        sb.append("transportAuftragNr='").append(transportAuftragNr).append('\'');
        sb.append(", transportDienstleister='").append(transportDienstleister).append('\'');
        sb.append(", ausgangsDatum=").append(ausgangsDatum);
        sb.append(", lieferDatum=").append(lieferDatum);
        sb.append('}');
        return sb.toString();
    }
}
