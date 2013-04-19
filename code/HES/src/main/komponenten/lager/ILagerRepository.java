package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.LieferscheinTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:04
 */
public interface ILagerRepository {
    public void bucheWareneingang(LieferscheinTyp lieferschein);

    public void reserviereProdukteFuerAuftrag(AuftragTyp auftrag);
}
