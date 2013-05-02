package main.komponenten.verkauf;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.KundenTyp;
import main.allgemeineTypen.transportTypen.ProduktTyp;
import main.komponenten.buchhaltung.IBuchhaltungManager;
import main.komponenten.lager.ILagerEvent;
import main.komponenten.lager.ILagerManager;
import main.komponenten.versand.IVersandManager;

import java.util.Date;
import java.util.Map;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:48
 */
public class VerkaufFassade implements IVerkaufManager {
    private AngebotLogik angebotLogik;
    private AuftragLogik auftragLogik;
    private IBuchhaltungManager buchhaltungManager;
    private ILagerEvent lagerEvent;
    private ILagerManager lagerManager;
    private IVersandManager versandManager;

    public VerkaufFassade(IBuchhaltungManager buchhaltungManager, ILagerEvent lagerEvent, ILagerManager lagerManager, IVersandManager versandManager) {

        this.buchhaltungManager = buchhaltungManager;
        this.lagerEvent = lagerEvent;
        this.lagerManager = lagerManager;
        this.angebotLogik = new AngebotLogik(lagerManager);
        this.auftragLogik = new AuftragLogik(buchhaltungManager,lagerEvent,lagerManager, versandManager);
    }


    @Override
    public AngebotTyp erstelleAngebot(String kundenNr, Date gueltigBis, Date gueltigAb, Map<String, Integer> produktListe) {
        return angebotLogik.erstelleAngebot(kundenNr, gueltigBis, gueltigAb, produktListe);
    }

    @Override
    public AuftragTyp erstelleAuftrag(AngebotTyp angebot) {
        AuftragTyp auftrag = auftragLogik.erstelleAuftrag(angebot);
        return auftrag;
    }

    @Override
    public AuftragTyp getAuftragZuID(String auftragsNr) {
        return auftragLogik.getAuftragZuID(auftragsNr);
    }

    @Override
    public AngebotTyp getAngebotZuID(String angebotNr) {
        return angebotLogik.getAngebotZuID(angebotNr);
    }
}
