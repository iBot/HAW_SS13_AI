package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.*;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:34
 */
public class LagerFassade implements ILagerManager {

    private LagerLogik lagerlogik;

    public LagerFassade() {
        lagerlogik= LagerLogik.getInstance();
    }

    @Override
    public ProduktTyp erstelleProdukt(String produktName) {
        return lagerlogik.erstelleProdukt(produktName);
    }

    @Override
    public void bucheWareneingang(LieferscheinTyp lieferschein, String bestellNr) {
        lagerlogik.bucheWareneingang(lieferschein, bestellNr);
    }

    @Override
    public void reserviereProdukteFuerAuftrag(AngebotTyp angebot, String reserviertListenerNr) {
        lagerlogik.reserviereProdukteFuerAuftrag(angebot, reserviertListenerNr);
    }

    @Override
    public ProduktTyp getProduktZuID(String produktNr) {
        return lagerlogik.getProduktZuID(produktNr);
    }

    @Override
    public WareneingangsmeldungTyp getWareneingangsmeldungZuID(String wareneingangsmeldungsNr) {
        return lagerlogik.getWareneingangsmeldungZuID(wareneingangsmeldungsNr);
    }
}
