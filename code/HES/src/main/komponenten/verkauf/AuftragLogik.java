package main.komponenten.verkauf;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.komponenten.buchhaltung.IBuchhaltungListener;
import main.komponenten.buchhaltung.IBuchhaltungManager;
import main.komponenten.lager.ILagerManager;
import main.komponenten.lager.IReserviertListener;
import main.komponenten.versand.IVersandManager;

import java.util.Date;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:50
 */
class AuftragLogik {

    private AuftragRepository auftragRepository;
    private IBuchhaltungManager buchhaltungManager;
    private ILagerManager lagerManager;
    private IVersandManager versandManager;


    AuftragLogik(IBuchhaltungManager buchhaltungManager, ILagerManager lagerManager,IVersandManager versandManager) {
        this.buchhaltungManager = buchhaltungManager;
        this.lagerManager = lagerManager;
        this.auftragRepository = new AuftragRepository();
        this.versandManager = versandManager;
    }

    public AuftragTyp erstelleAuftrag(final AngebotTyp angebot, Date beauftragtAm) {
        final Auftrag auftrag = auftragRepository.erstelleAuftrag(angebot, beauftragtAm);
        lagerManager.reserviereProdukteFuerAuftrag(angebot, new IReserviertListener() {
            @Override
            public void fuehreAktionAus() {
                warenSindVorhanden(auftrag, angebot);
            }
        });
        return auftrag.holeAuftragTyp();
    }

    public AuftragTyp getAuftragZuID(String auftragsNr) {
        return auftragRepository.getAuftragZuID(auftragsNr).holeAuftragTyp();
    }

    private void warenSindVorhanden(final Auftrag auftrag, AngebotTyp angebot){
        // lieferung erstellen
        System.out.println("Auftrag:>>>>>>>>>>>>>>>>>>>>>>>>  "+auftrag);
        System.out.println("AuftragTyp:>>>>>>>>>>>>>>>>>>>>>>>>  "+auftrag.holeAuftragTyp());
        versandManager.erstelleLieferung(auftrag.holeAuftragTyp());
        // rechnung erstellen und einschreiben
        IBuchhaltungListener listener = new IBuchhaltungListener() {
            @Override
            public void fuehreAktionAus() {
                rechnungIstBezahlt(auftrag);
            }
        };
        buchhaltungManager.erstelleRechnung(angebot.getGesamtpreis(),auftrag.holeAuftragTyp(),listener);
    }

    private void rechnungIstBezahlt(Auftrag auftrag) {
        // auftrag abschließen
        auftrag.setIstAbgeschlossen(true);
        auftragRepository.speicherAuftrag(auftrag);
    }


}
