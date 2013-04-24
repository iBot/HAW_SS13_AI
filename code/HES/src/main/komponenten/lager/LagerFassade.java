package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.*;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:34
 */
public class LagerFassade implements ILagerEvent, ILagerManager {

    private LagerLogik lagerlogik;

    public LagerFassade() {
        lagerlogik=new LagerLogik();
    }

    @Override
    public void schreibeFuerWarenReserviertEventEin(AngebotTyp angebot, ILagerListener listener) {
        lagerlogik.schreibeFuerWarenReserviertEventEin(angebot,listener);
    }

    @Override
    public ProduktTyp erstelleProdukt(String produktName) {
        return lagerlogik.erstelleProdukt(produktName);
    }

    @Override
    public void bucheWareneingang(LieferscheinTyp lieferschein) {
        lagerlogik.bucheWareneingang(lieferschein);
    }

    @Override
    public void reserviereProdukteFuerAuftrag(AuftragTyp auftrag, AngebotTyp angebot) {
        lagerlogik.reserviereProdukteFuerAuftrag(auftrag, angebot);
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
