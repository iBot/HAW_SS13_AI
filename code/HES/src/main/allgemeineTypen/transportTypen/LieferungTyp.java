package main.allgemeineTypen.transportTypen;

import java.io.Serializable;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:06
 */
public class LieferungTyp  implements Serializable {

   String lieferungNr, transportauftragNr;

    public boolean getLieferungErfolgt() {
        return lieferungErfolgt;
    }

    public void setLieferungErfolgt(boolean lieferungErfolgt) {
        this.lieferungErfolgt = lieferungErfolgt;
    }

    boolean lieferungErfolgt;

    public LieferungTyp(String lieferungNr, String transportauftragNr, boolean lieferungErfolgt) {
        this.lieferungNr = lieferungNr;
        this.transportauftragNr = transportauftragNr;
        this.lieferungErfolgt = lieferungErfolgt;
    }

    public String getLieferungNr() {
        return lieferungNr;
    }

    public void setLieferungNr(String lieferungNr) {
        this.lieferungNr = lieferungNr;
    }

    public String getTransportauftragNr() {
        return transportauftragNr;
    }

    public void setTransportauftragNr(String transportauftragNr) {
        this.transportauftragNr = transportauftragNr;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LieferungTyp{");
        sb.append("lieferungNr='").append(lieferungNr).append('\'');
        sb.append(", transportauftragNr='").append(transportauftragNr).append('\'');
        sb.append(", lieferungErfolgt=").append(lieferungErfolgt);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LieferungTyp that = (LieferungTyp) o;

        if (lieferungErfolgt != that.lieferungErfolgt) return false;
        if (lieferungNr != null ? !lieferungNr.equals(that.lieferungNr) : that.lieferungNr != null) return false;
        if (transportauftragNr != null ? !transportauftragNr.equals(that.transportauftragNr) : that.transportauftragNr != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lieferungNr != null ? lieferungNr.hashCode() : 0;
        result = 31 * result + (transportauftragNr != null ? transportauftragNr.hashCode() : 0);
        result = 31 * result + (lieferungErfolgt ? 1 : 0);
        return result;
    }
}
