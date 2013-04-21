package main.komponenten.kunden;

import main.allgemeineTypen.transportTypen.KundenTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:32
 */
class KundenLogik implements IKundenManager {

    KundenRepository kundenrepository;

    KundenLogik() {
        this.kundenrepository = new KundenRepository();
    }

    @Override
    public void erstelleKunde(KundenTyp kunde) {
        this.kundenrepository.erstelleKunde(kunde);
    }

    @Override
    public KundenTyp getKunde(String kundenID) {
        return this.kundenrepository.getKunde(kundenID);
    }
}
