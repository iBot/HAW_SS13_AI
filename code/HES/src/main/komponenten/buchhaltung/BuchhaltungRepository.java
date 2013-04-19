package main.komponenten.buchhaltung;

import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.allgemeineTypen.transportTypen.AuftragTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:22
 */
class BuchhaltungRepository implements IBuchhaltungEvent, IBuchhaltungRepository {
    @Override
    public void schreibeFuerRechnungBezahltEventEin(AngebotTyp angebot, IBuchhaltungListener listener) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void erstelleRechnung(AuftragTyp auftrag) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void zahlungseingangBuchen(double betrag, String kundenNr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
