package main.komponenten.versand;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.technik.persistenzManager.PersistenzManager;

import java.util.List;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:54
 */
class LieferungRepository {

    PersistenzManager persistenzManager = PersistenzManager.getInstance();

    public Lieferung erstelleLieferung(AuftragTyp auftrag) {
        Lieferung lieferung = new Lieferung(auftrag);
        persistenzManager.create(lieferung);
        return lieferung;
    }
    public Lieferung erstelleLieferung(AuftragTyp auftrag, Transportauftrag transportauftrag) {
        Lieferung lieferung = new Lieferung(auftrag,transportauftrag);
        persistenzManager.create(lieferung);
        return lieferung;
    }

    public Lieferung getLieferungZuID(String lieferungNr) {
        Lieferung lieferung = persistenzManager.access(Lieferung.class, lieferungNr);
        return  lieferung;
    }

    public List<Lieferung> holeAlleLieferungenZuAuftrag(AuftragTyp auftrag) {
        String query = "from Lieferung where auftragsNr = '"+auftrag.getAuftragsNr()+"'";
        List<Lieferung> lieferungen = persistenzManager.getAllByQuery(query);

        return lieferungen;
    }
}
