package main.komponenten.verkauf;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.allgemeineTypen.transportTypen.AuftragTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:51
 */
public class AuftragRepository {
    public AuftragTyp erstelleAuftrag(AngebotTyp angebot) {
        Auftrag auftrag = new Auftrag(angebot);
        //TODO: Persistiere auftrag
        return auftrag.getAuftragTyp();
    }

    public AuftragTyp getAuftragZuID(String auftragsNr) {
        Auftrag auftrag = null;
        //TODO: Lese auftrag aus Datenbank;
        return auftrag.getAuftragTyp();
    }
}
