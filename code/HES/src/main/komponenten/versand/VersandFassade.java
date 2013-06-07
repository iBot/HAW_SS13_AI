package main.komponenten.versand;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.KundenTyp;
import main.allgemeineTypen.transportTypen.LieferungTyp;

import java.util.List;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:53
 */
public class VersandFassade implements IVersandManager {

    VersandLogik versandLogik;

    public VersandFassade(int portExtention) {
        this.versandLogik = new VersandLogik(portExtention);
    }

    @Override
    public LieferungTyp erstelleLieferung(AuftragTyp auftrag, KundenTyp kunde) {
        return this.versandLogik.erstelleLieferung(auftrag, kunde);
    }

    @Override
    public LieferungTyp getLieferungZuID(String lieferungNr) {
        return this.versandLogik.getLieferungZuID(lieferungNr);
    }

    @Override
    public List<LieferungTyp> holeAlleLieferungenZuAuftrag(AuftragTyp auftrag) {
        return this.versandLogik.holeAlleLieferungenZuAuftrag(auftrag);
    }
}
