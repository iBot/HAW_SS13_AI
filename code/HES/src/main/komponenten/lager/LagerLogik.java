package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.*;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:34
 */
class LagerLogik implements ILagerEvent, ILagerManager {


    private ProduktRepository produktRepository;
    private WarenausgangsmeldungRepository warenausgangsmeldungRepository;
    private WareneingangsmeldungRepository wareneingangsmeldungRepository;

    @Override
    public void schreibeFuerWarenReserviertEventEin(AuftragTyp auftrag, ILagerListener listener) {
        produktRepository.schreibeFuerWarenReserviertEventEin(auftrag, listener);
    }

    @Override
    public void bucheWareneingang(LieferscheinTyp lieferschein) {
        produktRepository.bucheWareneingang(lieferschein);
    }

    @Override
    public void reserviereProdukteFuerAuftrag(AuftragTyp auftrag, AngebotTyp angebot) {
        produktRepository.reserviereProdukteFuerAuftrag(auftrag, angebot);
    }

    @Override
    public ProduktTyp getProduktZuID(String produktNr) {
        return produktRepository.getProduktZuID(produktNr);
    }

    @Override
    public WareneingangsmeldungTyp getWareneingangsmeldungZuID(String wareneingangsmeldungsNr) {
        return wareneingangsmeldungRepository.getWareneingangsmeldungZuID(wareneingangsmeldungsNr);
    }
}
