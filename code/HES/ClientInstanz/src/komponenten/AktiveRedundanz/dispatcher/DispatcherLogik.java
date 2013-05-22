package komponenten.AktiveRedundanz.dispatcher;

import enums.StatusEnum;
import komponenten.AktiveRedundanz.monitor.IMonitorEvent;
import komponenten.AktiveRedundanz.monitor.IStatusMonitorListener;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 20.05.13
 * Time: 20:42
 * To change this template use File | Settings | File Templates.
 */
public class DispatcherLogik {

    Map<Integer, List<IDispatcherListener>> monitorListenerMap = new HashMap<>();
    int anzahlAufrufeInstanz1, anzahlAufrufeInstanz2;
    Timer timer = new Timer();
    RRTimerTask timerTask1 = new RRTimerTask(this);
    int instanz;
    StatusEnum statusInstanz1, statusInstanz2;

    public DispatcherLogik(IMonitorEvent monitorEvent) {
        statusInstanz1 = StatusEnum.DEAD;
        statusInstanz2 = StatusEnum.DEAD;
        monitorEvent.schreibeFürInstanzStatusListenerEin(new IStatusMonitorListener() {
            @Override
            public void fuehreAktionAus(StatusEnum status) {
                statusInstanz1 = status;
            }
        }, 1);

        monitorEvent.schreibeFürInstanzStatusListenerEin(new IStatusMonitorListener() {
            @Override
            public void fuehreAktionAus(StatusEnum status) {
                statusInstanz2 = status;
            }
        }, 2);

        anzahlAufrufeInstanz1 = 0;
        anzahlAufrufeInstanz2 = 0;
        instanz = 1;
        timer.schedule(timerTask1, 0, 1000);




    }

    public void schreibeFürAnzahlDerFunktionsaufrufeDerSystemInstanzEin(IDispatcherListener listener, int systemInstanzID) {
        if(!monitorListenerMap.containsKey(systemInstanzID)) {
        monitorListenerMap.put(systemInstanzID, new ArrayList<IDispatcherListener>());
        }
        monitorListenerMap.get(systemInstanzID).add(listener);
    }

    public int getZuVerwendendeSystemInstanzID() throws noServerAvailableException {
        int aktiv = instanz;

        if(aktiv == 1)  {
            if(statusInstanz1.equals(StatusEnum.ONLINE))
            {
            anzahlAufrufeInstanz1++;
            wirfEvent(1);
            }
            else
            {
                aktiv = 2;
            }
        }
        if(aktiv == 2 )  {
            if (statusInstanz2.equals(StatusEnum.ONLINE)) {
            anzahlAufrufeInstanz2++;
            wirfEvent(2);
            }
            else {
                aktiv = 1;
                if(statusInstanz1.equals(StatusEnum.ONLINE))
                {
                    anzahlAufrufeInstanz1++;
                    wirfEvent(1);
                }
                else
                {
                    throw new noServerAvailableException();
                }
            }
        }


         return aktiv;
    }

    private void wirfEvent(int id) {
        if(id == 1)  {
            for(IDispatcherListener listener : monitorListenerMap.get(id))
            {
                listener.führeAktionAus(anzahlAufrufeInstanz1);
            }
        }
        else if (id == 2){
            for(IDispatcherListener listener : monitorListenerMap.get(id))
            {
                listener.führeAktionAus(anzahlAufrufeInstanz2);
            }
        }
    }

    public void roundRobin()
    {
        instanz++;
        instanz = (instanz%2)+1;
    }


}
