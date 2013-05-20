package komponenten.AktiveRedundanz.dispatcher;

import komponenten.AktiveRedundanz.monitor.IMonitorListener;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 20.05.13
 * Time: 16:50
 * To change this template use File | Settings | File Templates.
 */
public class DispatcherFassade implements IDispatcherManager, IDispatcherEvent {
    @Override
    public void schreibeFürAnzahlDerFunktionsaufrufeDerSystemInstanzEin(IMonitorListener listener, UUID systemInstanzID) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getZuVerwendendeSystemInstanzID() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
