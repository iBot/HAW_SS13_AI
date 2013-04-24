package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.AngebotTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:06
 */
public interface ILagerEvent {
    public void schreibeFuerWarenReserviertEventEin(AngebotTyp angebot, ILagerListener listener);
}
