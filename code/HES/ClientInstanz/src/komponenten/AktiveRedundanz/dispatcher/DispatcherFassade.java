package komponenten.AktiveRedundanz.dispatcher;

import komponenten.AktiveRedundanz.monitor.IMonitorListener;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 20.05.13
 * Time: 16:50
 * To change this template use File | Settings | File Templates.
 */
public class DispatcherFassade implements IDispatcherManager, IDispatcherEvent {

    private DispatcherLogik dispatcherLogik;

    @Override
    public void schreibeFürAnzahlDerFunktionsaufrufeDerSystemInstanzEin(IMonitorListener listener, int systemInstanzID) {
             dispatcherLogik.schreibeFürAnzahlDerFunktionsaufrufeDerSystemInstanzEin(listener, systemInstanzID);
    }

    @Override
    public int getZuVerwendendeSystemInstanzID() {
        return dispatcherLogik.getZuVerwendendeSystemInstanzID();
    }
}
