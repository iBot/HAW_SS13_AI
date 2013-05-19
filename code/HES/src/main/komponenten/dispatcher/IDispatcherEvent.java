package main.komponenten.dispatcher;

import main.komponenten.monitor.IMonitorListener;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 19.05.13
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */
public interface IDispatcherEvent {


    void schreibeFürAnzahlDerFunktionsaufrufeDerSystemInstanzEin (IMonitorListener listener, UUID systemInstanzID);
}
