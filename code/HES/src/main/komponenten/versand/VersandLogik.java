package main.komponenten.versand;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.LieferungTyp;

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
        return lieferungRepository. erstelleLieferung(auftrag, erstelleTransportauftrag());
    }

    Transportauftrag erstelleTransportauftrag(){
        return this.transportauftragRepository.erstelleTransportauftrag();
    }

    public LieferungTyp getLieferungZuID(String lieferungNr) {
        return this.lieferungRepository.getLieferungZuID(lieferungNr);
    }

    public List<LieferungTyp> holeAlleLieferungenZuAuftrag(AuftragTyp auftrag) {
        return this.lieferungRepository.holeAlleLieferungenZuAuftrag(auftrag);
    }
}
