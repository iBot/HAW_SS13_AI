package main.komponenten.verkauf;

import main.komponenten.lager.IReserviertListener;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 20.05.13
 * Time: 16:40
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "ReserviertListener")
public class ReserviertListener implements IReserviertListener{

    @Id
    private String reserviertListenerNr;

    private String auftrag;
    private String angebot;

    public ReserviertListener(String auftrag, String angebot){
        this.auftrag=auftrag;
        this.angebot=angebot;
        this.reserviertListenerNr = "LRLi-"+ UUID.randomUUID();
    }


    private ReserviertListener(){}

    @Override
    public void fuehreAktionAus() {
        AuftragLogik auftragLogik = AuftragLogik.getInstance();
        auftragLogik.warenSindVorhanden(auftragLogik.getAuftragZuID(auftrag), AngebotLogik.getInstance().getAngebotZuID(angebot));
    }

    public String getAuftrag() {
        return auftrag;
    }

    public void setAuftrag(String auftrag) {
        this.auftrag = auftrag;
    }

    public String getAngebot() {
        return angebot;
    }

    public void setAngebot(String angebot) {
        this.angebot = angebot;
    }

    public String getReserviertListenerNr() {
        return reserviertListenerNr;
    }

    public void setReserviertListenerNr(String reserviertListenerNr) {
        this.reserviertListenerNr = reserviertListenerNr;
    }
}
