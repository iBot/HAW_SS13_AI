package main.komponenten.monitor;

import main.allgemeineTypen.enums.StatusEnum;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 19.05.13
 * Time: 14:04
 * To change this template use File | Settings | File Templates.
 */
public interface IStatusMonitorListener {

    void fuehreAktionAus(StatusEnum status);
}
