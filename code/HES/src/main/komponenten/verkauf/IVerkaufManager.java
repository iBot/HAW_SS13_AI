package main.komponenten.verkauf;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.KundenTyp;
import main.allgemeineTypen.transportTypen.ProduktTyp;

import java.util.Date;
import java.util.Map;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:15
 */
public interface IVerkaufManager {
    public AngebotTyp erstelleAngebot(String kundenNr, Date gueltigBis, Date gueltigAb, Map<ProduktTyp, Integer> produktListe);

    public AuftragTyp erstelleAuftrag(AngebotTyp angebot);

    public AuftragTyp getAuftragZuID(String auftragsNr);

    public AngebotTyp getAngebotZuID(String angebotNr);
}
