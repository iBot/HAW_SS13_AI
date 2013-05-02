package main.komponenten.versand;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.LieferungTyp;
import main.allgemeineTypen.transportTypen.TransportauftragTyp;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:54
 */
class VersandLogik {

    LieferungRepository lieferungRepository;
    TransportauftragRepository transportauftragRepository;

    VersandLogik() {
        this.lieferungRepository = new LieferungRepository();
        this.transportauftragRepository = new TransportauftragRepository();
    }

    LieferungTyp erstelleLieferung(AuftragTyp auftrag) {
        return lieferungRepository.erstelleLieferung(auftrag, transportauftragRepository.erstelleTransportauftrag()).holeLieferungTyp();
    }

    TransportauftragTyp erstelleTransportauftrag(){
        return this.transportauftragRepository.erstelleTransportauftrag().holeTransportauftragTyp();
    }

    public LieferungTyp getLieferungZuID(String lieferungNr) {
        return this.lieferungRepository.getLieferungZuID(lieferungNr).holeLieferungTyp();
    }

    public List<LieferungTyp> holeAlleLieferungenZuAuftrag(AuftragTyp auftrag) {
        List<Lieferung> lieferungen = this.lieferungRepository.holeAlleLieferungenZuAuftrag(auftrag);
        List<LieferungTyp> result = new ArrayList<>();
        for (Lieferung lieferung :lieferungen ){
            result.add(lieferung.holeLieferungTyp());
        }
        return result;
    }
}
