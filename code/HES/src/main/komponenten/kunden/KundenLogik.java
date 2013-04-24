package main.komponenten.kunden;

import main.allgemeineTypen.transportTypen.KundenTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:32
 */
class KundenLogik{

    KundenRepository kundenrepository;

    KundenLogik() {
        this.kundenrepository = new KundenRepository();
    }

    public KundenTyp erstelleKunde(KundenTyp kunde) {
        return this.kundenrepository.erstelleKunde(kunde);
    }

    public KundenTyp getKundeZuID(String kundenID) {
        return this.kundenrepository.getKundeZuID(kundenID);
    }
}
