package main.allgemeineTypen.transportTypen;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 02.05.13
 * Time: 16:17
 * To change this template use File | Settings | File Templates.
 */
public class TransportauftragTyp  implements Serializable {
    String transportauftragNr;
    Date ausgangsDatum;

    public TransportauftragTyp(String transportauftragNr, Date ausgangsDatum) {
        this.transportauftragNr = transportauftragNr;
        this.ausgangsDatum = ausgangsDatum;
    }

    public String getTransportauftragNr() {
        return transportauftragNr;
    }

    public void setTransportauftragNr(String transportauftragNr) {
        this.transportauftragNr = transportauftragNr;
    }

    public Date getAusgangsDatum() {
        return ausgangsDatum;
    }

    public void setAusgangsDatum(Date ausgangsDatum) {
        this.ausgangsDatum = ausgangsDatum;
    }

    @Override
    public String toString() {
        return "TransportauftragTyp{" +
                "transportauftragNr='" + transportauftragNr + '\'' +
                ", ausgangsDatum=" + ausgangsDatum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransportauftragTyp that = (TransportauftragTyp) o;

        if (ausgangsDatum != null ? !ausgangsDatum.equals(that.ausgangsDatum) : that.ausgangsDatum != null)
            return false;
        if (transportauftragNr != null ? !transportauftragNr.equals(that.transportauftragNr) : that.transportauftragNr != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transportauftragNr != null ? transportauftragNr.hashCode() : 0;
        result = 31 * result + (ausgangsDatum != null ? ausgangsDatum.hashCode() : 0);
        return result;
    }
}
