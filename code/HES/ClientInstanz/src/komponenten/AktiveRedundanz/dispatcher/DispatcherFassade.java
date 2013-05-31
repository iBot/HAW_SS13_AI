package komponenten.AktiveRedundanz.dispatcher;

import komponenten.AktiveRedundanz.monitor.IMonitorEvent;
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

    public DispatcherFassade(IMonitorEvent monitorEvent){
        dispatcherLogik = new DispatcherLogik(monitorEvent);
    }

    @Override
    public void schreibeFürAnzahlDerFunktionsaufrufeDerSystemInstanzEin(IDispatcherListener listener, int systemInstanzID) {
             dispatcherLogik.schreibeFürAnzahlDerFunktionsaufrufeDerSystemInstanzEin(listener, systemInstanzID);
    }

    @Override
    public int getZuVerwendendeSystemInstanzID() {
        try {
            return dispatcherLogik.getZuVerwendendeSystemInstanzID();
        } catch (noServerAvailableException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return -1;
    }
}
