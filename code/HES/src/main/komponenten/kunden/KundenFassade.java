package main.komponenten.kunden;

import main.allgemeineTypen.transportTypen.KundenTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:32
 */
public class KundenFassade implements IKundenManager {

    private KundenLogik kundenLogik;

    public KundenFassade() {
        kundenLogik = new KundenLogik();
    }

    @Override
    public void erstelleKunde(KundenTyp kunde) {
        kundenLogik.erstelleKunde(kunde);
    }

    @Override
    public KundenTyp getKunde(String kundenID) {
        return kundenLogik.getKunde(kundenID);
    }
}
