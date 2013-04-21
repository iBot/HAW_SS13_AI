package main.komponenten.versand;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.LieferungTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:53
 */
public class VersandFassade implements IVersandManager {

    VersandLogik versandLogik;

    public VersandFassade() {
        this.versandLogik = new VersandLogik();
    }

    @Override
    public LieferungTyp erstelleLieferung(AuftragTyp auftrag) {
        return this.versandLogik.erstelleLieferung(auftrag);
    }

    @Override
    public LieferungTyp getLieferungZuID(String lieferungNr) {
        return this.versandLogik.getLieferungZuID(lieferungNr);
    }
}
