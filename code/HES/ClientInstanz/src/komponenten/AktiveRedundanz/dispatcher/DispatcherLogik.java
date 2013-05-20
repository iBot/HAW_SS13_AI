package komponenten.AktiveRedundanz.dispatcher;

import komponenten.AktiveRedundanz.monitor.IMonitorListener;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 20.05.13
 * Time: 20:42
 * To change this template use File | Settings | File Templates.
 */
public class DispatcherLogik {

    Map<Integer, IMonitorListener> monitorListenerMap;
    int anzahlAufrufeInstanz1, anzahlAufrufeInstanz2;

    public DispatcherLogik() {
        anzahlAufrufeInstanz1 = 0;
        anzahlAufrufeInstanz2 = 0;


    }

    public void schreibeFürAnzahlDerFunktionsaufrufeDerSystemInstanzEin(IMonitorListener listener, int systemInstanzID) {
         monitorListenerMap.put(systemInstanzID, listener);
    }

    public int getZuVerwendendeSystemInstanzID() {
        int aktiv = 0;

        //RoundRobin

        if(aktiv == 1)  {
            anzahlAufrufeInstanz1++;
            wirfMonitorEvent(1);
        }
        else if(aktiv == 2)  {
            anzahlAufrufeInstanz2++;
            wirfMonitorEvent(2);
        }

         return aktiv;
    }

    private void wirfMonitorEvent(int id) {
        if(id == 1)
        monitorListenerMap.get(id).führeAktionAus(anzahlAufrufeInstanz1);
        else if (id == 2)
        monitorListenerMap.get(id).führeAktionAus(anzahlAufrufeInstanz2);
    }


}
