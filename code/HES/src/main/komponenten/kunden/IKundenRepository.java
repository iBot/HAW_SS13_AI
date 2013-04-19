package main.komponenten.kunden;

import main.allgemeineTypen.transportTypen.KundenTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 12:58
 */
interface IKundenRepository {
    public void erstelleKunde(KundenTyp kunde);

    public KundenTyp getKunde(String kundenID);
}
