package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.*;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:04
 */
public interface ILagerManager {

    public ProduktTyp erstelleProdukt(String produktName);

    public void bucheWareneingang(LieferscheinTyp lieferschein);

    public void reserviereProdukteFuerAuftrag(AuftragTyp auftrag, AngebotTyp angebot);

    public ProduktTyp getProduktZuID(String produktNr);

    public WareneingangsmeldungTyp getWareneingangsmeldungZuID(String wareneingangsmeldungsNr);
}
