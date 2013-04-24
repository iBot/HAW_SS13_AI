package main.komponenten.verkauf;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.technik.persistenzManager.PersistenzManager;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:51
 */
public class AuftragRepository {

    PersistenzManager persistenzManager = PersistenzManager.getInstance();

    public AuftragTyp erstelleAuftrag(AngebotTyp angebot) {
        Auftrag auftrag = new Auftrag(angebot);
        persistenzManager.create(auftrag);
        return auftrag.getAuftragTyp();
    }

    public AuftragTyp getAuftragZuID(String auftragsNr) {
        Auftrag auftrag = persistenzManager.access(Auftrag.class, auftragsNr);
        return auftrag.getAuftragTyp();
    }
}
