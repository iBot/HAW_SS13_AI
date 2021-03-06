package main.komponenten.versand;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.KundenTyp;
import main.allgemeineTypen.transportTypen.LieferungTyp;
import main.allgemeineTypen.transportTypen.TransportauftragTyp;
import main.technik.transportDienstlAdapter.ITransportAuftragListener;
import main.technik.transportDienstlAdapter.ITransportDienstleisterManager;
import main.technik.transportDienstlAdapter.TransportDienstleister;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:54
 */
class VersandLogik {

    LieferungRepository lieferungRepository;
    TransportauftragRepository transportauftragRepository;
    ITransportDienstleisterManager transportDienstleisterManager;

    VersandLogik(int portExtention) {
        this.lieferungRepository = new LieferungRepository();
        this.transportauftragRepository = new TransportauftragRepository();
        this.transportDienstleisterManager = TransportDienstleister.getInstance(portExtention);
        System.out.println("########Abbonieren für Transportbestätigung");

        transportDienstleisterManager.abboniereTransportauftragsBestaetigungen(new ITransportAuftragListener() {
            @Override
            public void bestaetigeTransportauftrag(String transportAuftragsNummer, Date datum) {
                Transportauftrag transportauftrag = transportauftragRepository.holeTransportauftrag(transportAuftragsNummer);
                transportauftrag.setLieferDatum(datum);
                transportauftragRepository.speicherTransportauftrag(transportauftrag);
            }
        });
    }

    LieferungTyp erstelleLieferung(AuftragTyp auftrag, KundenTyp kunde) {
        Transportauftrag transportauftrag = transportauftragRepository.erstelleTransportauftrag();
        this.transportDienstleisterManager.sendeTransportauftrag(transportauftrag.holeTransportauftragTyp(), kunde);
        return lieferungRepository.erstelleLieferung(auftrag, transportauftrag).holeLieferungTyp();
    }

    TransportauftragTyp erstelleTransportauftrag(KundenTyp kunde) {
        return this.transportauftragRepository.erstelleTransportauftrag().holeTransportauftragTyp();
    }

    public LieferungTyp getLieferungZuID(String lieferungNr) {
        return this.lieferungRepository.getLieferungZuID(lieferungNr).holeLieferungTyp();
    }

    public List<LieferungTyp> holeAlleLieferungenZuAuftrag(AuftragTyp auftrag) {
        List<Lieferung> lieferungen = this.lieferungRepository.holeAlleLieferungenZuAuftrag(auftrag);
        List<LieferungTyp> result = new ArrayList<>();
        for (Lieferung lieferung : lieferungen) {
            result.add(lieferung.holeLieferungTyp());
        }
        return result;
    }
}
