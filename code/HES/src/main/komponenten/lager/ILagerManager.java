package main.komponenten.lager;

import main.allgemeineTypen.allgemeineTypen.*;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:04
 */
public interface ILagerManager {

    public ProduktTyp erstelleProdukt(String produktName);

    public void bucheWareneingang(LieferscheinTyp lieferschein, String bestellNr);

    public void reserviereProdukteFuerAuftrag(AngebotTyp angebot, IReserviertListener reserviertListener);

    public ProduktTyp getProduktZuID(String produktNr);

    public WareneingangsmeldungTyp getWareneingangsmeldungZuID(String wareneingangsmeldungsNr);
}
