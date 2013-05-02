package main.komponenten.verkauf;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.technik.persistenzManager.PersistenzManager;

import java.util.Date;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:51
 */
public class AuftragRepository {

    PersistenzManager persistenzManager = PersistenzManager.getInstance();

    public Auftrag erstelleAuftrag(AngebotTyp angebot, Date beauftragtAm) {
        Auftrag auftrag = new Auftrag(angebot, beauftragtAm);
        persistenzManager.create(auftrag);
        return auftrag;
    }

    public Auftrag getAuftragZuID(String auftragsNr) {
        Auftrag auftrag = persistenzManager.access(Auftrag.class, auftragsNr);
        return auftrag;
    }

    public void speicherAuftrag(Auftrag auftrag) {
        persistenzManager.update(auftrag);
    }

}
