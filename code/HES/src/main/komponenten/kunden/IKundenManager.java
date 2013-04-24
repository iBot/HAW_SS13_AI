package main.komponenten.kunden;

import main.allgemeineTypen.transportTypen.KundenTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 12:58
 */
public interface IKundenManager {
    public KundenTyp erstelleKunde(KundenTyp kunde);

    public KundenTyp getKundeZuID(String kundenID);
}
