package main.komponenten.verkauf;

import main.komponenten.buchhaltung.IBuchhaltungListener;

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
@Table(name = "buchhaltungListener")

public class BuchhaltungListener implements IBuchhaltungListener{

    @Id
    private String buchhaltungslistenerNr;

    private String auftrag;

    public BuchhaltungListener(String auftrag){
        this.auftrag=auftrag;
        this.buchhaltungslistenerNr = "BHLi-"+ UUID.randomUUID();
    }

    private BuchhaltungListener(){}

    @Override
    public void fuehreAktionAus() {
        AuftragLogik al = AuftragLogik.getInstance();
        al.rechnungIstBezahlt(al.getAuftragZuID(auftrag));
    }

    public String getAuftrag() {
        return auftrag;
    }

    public void setAuftrag(String auftrag) {
        this.auftrag = auftrag;
    }


    public String getBuchhaltungslistenerNr() {
        return buchhaltungslistenerNr;
    }

    public void setBuchhaltungslistenerNr(String buchhaltungslistenerNr) {
        this.buchhaltungslistenerNr = buchhaltungslistenerNr;
    }
}
