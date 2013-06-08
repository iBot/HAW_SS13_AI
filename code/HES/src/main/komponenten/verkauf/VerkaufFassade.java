package main.komponenten.verkauf;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.komponenten.buchhaltung.IBuchhaltungManager;
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
//    private ILagerManager lagerManager;
//    private IVersandManager versandManager;

    public VerkaufFassade(IBuchhaltungManager buchhaltungManager, ILagerManager lagerManager, IVersandManager versandManager) {

        this.buchhaltungManager = buchhaltungManager;
//        this.lagerManager = lagerManager;
        this.angebotLogik = AngebotLogik.getInstance(lagerManager);
        this.auftragLogik = AuftragLogik.getInstance(buchhaltungManager,lagerManager, versandManager);
    }


    @Override
    public AngebotTyp erstelleAngebot(String kundenNr, Date gueltigBis, Date gueltigAb, Map<String, Integer> produktListe) {
        return angebotLogik.erstelleAngebot(kundenNr, gueltigBis, gueltigAb, produktListe);
    }

    @Override
    public AuftragTyp erstelleAuftrag(AngebotTyp angebot, Date beauftragtAm) {
        AuftragTyp auftrag = auftragLogik.erstelleAuftrag(angebot, beauftragtAm);
        return auftrag;
    }

    @Override
    public AuftragTyp getAuftragZuID(String auftragsNr) {
        return auftragLogik.getAuftragTypZuID(auftragsNr);
    }

    @Override
    public AngebotTyp getAngebotZuID(String angebotNr) {
        return angebotLogik.getAngebotZuID(angebotNr);
    }
}
