package main.komponenten.verkauf;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.allgemeineTypen.transportTypen.AuftragTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:50
 */
class AuftragLogik {

    private AuftragRepository auftragRepository;

    AuftragLogik() {
        this.auftragRepository = new AuftragRepository();
    }

    public AuftragTyp erstelleAuftrag(AngebotTyp angebot) {
        return auftragRepository.erstelleAuftrag(angebot);
    }

    public AuftragTyp getAuftragZuID(String auftragsNr) {
        return auftragRepository.getAuftragZuID(auftragsNr);
    }
}
