package main.komponenten.monitor;

import main.allgemeineTypen.enums.StatusEnum;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 19.05.13
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */
public interface IMonitorManager {

    void setInstanceStatus(StatusEnum status,UUID systemInstanzID);

}
