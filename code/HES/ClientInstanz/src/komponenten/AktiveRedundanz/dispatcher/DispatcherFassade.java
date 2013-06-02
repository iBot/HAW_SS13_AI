package komponenten.AktiveRedundanz.dispatcher;

import komponenten.AktiveRedundanz.monitor.IMonitorEvent;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 20.05.13
 * Time: 16:50
 */
public class DispatcherFassade implements IDispatcherManager, IDispatcherEvent {

    private DispatcherLogik dispatcherLogik;

    public DispatcherFassade(IMonitorEvent monitorEvent){
        dispatcherLogik = new DispatcherLogik(monitorEvent);
    }

    @Override
    public void schreibeFürAnzahlDerFunktionsaufrufeDerSystemInstanzEin(IDispatcherListener listener, int systemInstanzID) {
             dispatcherLogik.schreibeFürAnzahlDerFunktionsaufrufeDerSystemInstanzEin(listener, systemInstanzID);
    }

    @Override
    public int getZuVerwendendeSystemInstanzID() throws noServerAvailableException {
            return dispatcherLogik.getZuVerwendendeSystemInstanzID();

    }
}
