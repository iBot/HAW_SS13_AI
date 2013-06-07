package main.komponenten.versand;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.KundenTyp;
import main.allgemeineTypen.transportTypen.LieferungTyp;

import java.util.List;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:17
 */
public interface IVersandManager {
    public LieferungTyp erstelleLieferung(AuftragTyp auftrag, KundenTyp kunde);

    public LieferungTyp getLieferungZuID(String lieferungNr);

    public List<LieferungTyp> holeAlleLieferungenZuAuftrag(AuftragTyp auftrag);
}
