package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.LieferungTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:34
 */
class LagerLogik implements ILagerEvent, ILagerManager {
    @Override
    public void schreibeFuerWarenReserviertEventEin(AuftragTyp auftrag, ILagerListener listener) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void bucheWareneingang(LieferungTyp lieferschein) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void reserviereProdukteFuerAuftrag(AuftragTyp auftrag) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
