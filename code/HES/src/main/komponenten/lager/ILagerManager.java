package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.LieferungTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:04
 */
public interface ILagerManager {
    public void bucheWareneingang(LieferungTyp lieferschein);

    public void reserviereProdukteFuerAuftrag(AuftragTyp auftrag);
}
