package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.LieferscheinTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:34
 */
public class LagerFassade implements ILagerEvent, ILagerRepository {
    @Override
    public void schreibeFuerWarenReserviertEventEin(AuftragTyp auftrag, ILagerListener listener) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void bucheWareneingang(LieferscheinTyp lieferschein) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void reserviereProdukteFuerAuftrag(AuftragTyp auftrag) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
