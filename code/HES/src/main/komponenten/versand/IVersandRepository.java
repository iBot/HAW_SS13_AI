package main.komponenten.versand;

import main.allgemeineTypen.transportTypen.AuftragTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:17
 */
public interface IVersandRepository {
    public void erstelleLieferung(AuftragTyp auftrag);
}
