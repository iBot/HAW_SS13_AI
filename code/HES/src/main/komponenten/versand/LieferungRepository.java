package main.komponenten.versand;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.LieferungTyp;
import main.technik.persistenzManager.PersistenzManager;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:54
 */
class LieferungRepository {

    PersistenzManager persistenzManager = PersistenzManager.getInstance();

    public LieferungTyp erstelleLieferung(AuftragTyp auftrag) {
        Lieferung lieferung = new Lieferung(auftrag);
        persistenzManager.create(lieferung);
        return lieferung.holeLieferungTyp();
    }
    public LieferungTyp erstelleLieferung(AuftragTyp auftrag, Transportauftrag transportauftrag) {
        Lieferung lieferung = new Lieferung(auftrag,transportauftrag);
        persistenzManager.create(lieferung);
        return lieferung.holeLieferungTyp();
    }

    public LieferungTyp getLieferungZuID(String lieferungNr) {
        Lieferung lieferung = persistenzManager.access(Lieferung.class, lieferungNr);
        return  lieferung.holeLieferungTyp();
    }

    public List<LieferungTyp> holeAlleLieferungenZuAuftrag(AuftragTyp auftrag) {
        String query = "from Lieferung where auftragsNr = '"+auftrag.getAuftragsNr()+"'";
        List<Lieferung> lieferungen = persistenzManager.getAllByQuery(query);
        List<LieferungTyp> result = new ArrayList<>();
        for (Lieferung lieferung :lieferungen ){
            result.add(lieferung.holeLieferungTyp());
        }
        return result;
    }
}
