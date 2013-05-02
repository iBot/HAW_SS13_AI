package main.komponenten.buchhaltung;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.RechnungTyp;

import java.util.List;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:21
 */
public class BuchhaltungFassade implements IBuchhaltungManager {

    private BuchhaltungLogik buchhaltungLogik;

    public BuchhaltungFassade() {
        this.buchhaltungLogik = new BuchhaltungLogik();
    }


    @Override
    public RechnungTyp erstelleRechnung(double gesamtbetrag, AuftragTyp auftrag, IBuchhaltungListener listener) {
        return buchhaltungLogik.erstelleRechnung(gesamtbetrag, auftrag, listener);
    }

    @Override
    public void zahlungseingangBuchen(double betrag, String rechnungsNr) {
        buchhaltungLogik.zahlungseingangBuchen(betrag, rechnungsNr);
    }

    @Override
    public List<RechnungTyp> getRechnungenZuKunde(String kundenNr) {
        return buchhaltungLogik.getRechnungenZuKunde(kundenNr);
    }

    @Override
    public RechnungTyp getRechnungZuID(String rechnungsNr) {
        return buchhaltungLogik.getRechnungZuID(rechnungsNr);
    }
}
