package main.komponenten.verkauf;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.komponenten.buchhaltung.IBuchhaltungManager;
import main.komponenten.kunden.IKundenManager;
import main.komponenten.kunden.KundenFassade;
import main.komponenten.lager.ILagerManager;
import main.komponenten.lager.IReserviertListener;
import main.komponenten.versand.IVersandManager;
import main.technik.persistenzManager.PersistenzManager;

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
    private IKundenManager kundenManager;

    private static AuftragLogik instance;

    public static AuftragLogik getInstance(IBuchhaltungManager buchhaltungManager, ILagerManager lagerManager,IVersandManager versandManager){
        if (instance== null){
            instance = new AuftragLogik(buchhaltungManager,lagerManager,versandManager);
        }
        return instance;
    }

    public static AuftragLogik getInstance(){
        return instance;
    }

    public static boolean existsInstance(){
        return (instance==null) ? false :true;
    }

    private AuftragLogik(IBuchhaltungManager buchhaltungManager, ILagerManager lagerManager,IVersandManager versandManager) {
        this.buchhaltungManager = buchhaltungManager;
        this.lagerManager = lagerManager;
        this.auftragRepository = new AuftragRepository();
        this.versandManager = versandManager;
        this.kundenManager = new KundenFassade();
    }

    public AuftragTyp erstelleAuftrag(final AngebotTyp angebot, Date beauftragtAm) {
        final Auftrag auftrag = auftragRepository.erstelleAuftrag(angebot, beauftragtAm);
        ReserviertListener reserviertListener = new ReserviertListener(auftrag.getAuftragsNr(),angebot.getAngebotNr());
        PersistenzManager.getInstance().create(reserviertListener);
        lagerManager.reserviereProdukteFuerAuftrag(angebot, reserviertListener.getReserviertListenerNr());

        return auftrag.holeAuftragTyp();
    }

    public AuftragTyp getAuftragTypZuID(String auftragsNr) {
        return auftragRepository.getAuftragZuID(auftragsNr).holeAuftragTyp();
    }

    Auftrag getAuftragZuID(String auftragsNr) {
        return auftragRepository.getAuftragZuID(auftragsNr);
    }

    void warenSindVorhanden(final Auftrag auftrag, AngebotTyp angebot){
        // lieferung erstellen
        System.out.println("Auftrag:>>>>>>>>>>>>>>>>>>>>>>>>  "+auftrag);
        System.out.println("AuftragTyp:>>>>>>>>>>>>>>>>>>>>>>>>  "+auftrag.holeAuftragTyp());
        versandManager.erstelleLieferung(auftrag.holeAuftragTyp(),kundenManager.getKundeZuID(angebot.getKundenNr()));
        // rechnung erstellen und einschreiben
        BuchhaltungListener listener = new BuchhaltungListener(auftrag.getAuftragsNr());
        PersistenzManager.getInstance().create(listener);
        buchhaltungManager.erstelleRechnung(angebot.getGesamtpreis(), auftrag.holeAuftragTyp(), listener.getBuchhaltungslistenerNr());

    }

    void rechnungIstBezahlt(Auftrag auftrag) {
        // auftrag abschließen
        auftrag.setIstAbgeschlossen(true);
        auftragRepository.speicherAuftrag(auftrag);
    }





}
