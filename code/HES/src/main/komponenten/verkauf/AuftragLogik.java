package main.komponenten.verkauf;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.komponenten.buchhaltung.IBuchhaltungListener;
import main.komponenten.buchhaltung.IBuchhaltungManager;
import main.komponenten.lager.ILagerEvent;
import main.komponenten.lager.ILagerListener;
import main.komponenten.lager.ILagerManager;
import main.komponenten.versand.IVersandManager;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:50
 */
class AuftragLogik {

    private AuftragRepository auftragRepository;
    private IBuchhaltungManager buchhaltungManager;
    private ILagerEvent lagerEvent;
    private ILagerManager lagerManager;
    private IVersandManager versandManager;


    AuftragLogik(IBuchhaltungManager buchhaltungManager, ILagerEvent lagerEvent, ILagerManager lagerManager,IVersandManager versandManager) {
        this.buchhaltungManager = buchhaltungManager;
        this.lagerEvent = lagerEvent;
        this.lagerManager = lagerManager;
        this.auftragRepository = new AuftragRepository();
        this.versandManager = versandManager;
    }

    public AuftragTyp erstelleAuftrag(final AngebotTyp angebot) {
        final Auftrag auftrag = auftragRepository.erstelleAuftrag(angebot);
        lagerEvent.schreibeFuerWarenReserviertEventEin(angebot, new ILagerListener() {
            @Override
            public void fuehreAktionAus() {
                warenSindVorhanden(auftrag, angebot);
            }
        });
        return auftragRepository.erstelleAuftrag(angebot).holeAuftragTyp();
    }

    public AuftragTyp getAuftragZuID(String auftragsNr) {
        return auftragRepository.getAuftragZuID(auftragsNr);
    }

    private void warenSindVorhanden(final Auftrag auftrag, AngebotTyp angebot){
        // lieferung tun
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
