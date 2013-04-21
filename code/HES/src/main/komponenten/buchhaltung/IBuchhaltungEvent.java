package main.komponenten.buchhaltung;

import main.allgemeineTypen.transportTypen.AngebotTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 12:57
 */
public interface IBuchhaltungEvent {
    public void schreibeFuerRechnungBezahltEventEin(String rechnungsNr, IBuchhaltungListener listener);
}
