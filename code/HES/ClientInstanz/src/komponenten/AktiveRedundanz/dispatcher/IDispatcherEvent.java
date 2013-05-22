package komponenten.AktiveRedundanz.dispatcher;

import komponenten.AktiveRedundanz.monitor.IMonitorListener;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 19.05.13
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */
public interface IDispatcherEvent {


    void schreibeFürAnzahlDerFunktionsaufrufeDerSystemInstanzEin (IMonitorListener listener, int systemInstanzID);
}
