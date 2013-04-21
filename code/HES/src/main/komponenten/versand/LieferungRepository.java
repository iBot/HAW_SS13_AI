package main.komponenten.versand;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.LieferungTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:54
 */
class LieferungRepository {
    public LieferungTyp erstelleLieferung(AuftragTyp auftrag) {
        Lieferung lieferung = new Lieferung(auftrag);
        //TODO: Lieferung persisitieren
        return lieferung.getLieferungTyp();
    }
    public LieferungTyp erstelleLieferung(AuftragTyp auftrag, Transportauftrag transportauftrag) {
        Lieferung lieferung = new Lieferung(auftrag,transportauftrag);
        //TODO: Lieferung persisitieren
        return lieferung.getLieferungTyp();
    }

    public LieferungTyp getLieferungZuID(String lieferungNr) {
        Lieferung lieferung = null;
        //TODO: Lese Lieferung aus Datenbank
        return  lieferung.getLieferungTyp();
    }
}
