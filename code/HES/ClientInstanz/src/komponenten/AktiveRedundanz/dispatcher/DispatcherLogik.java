package komponenten.AktiveRedundanz.dispatcher;

import enums.StatusEnum;
import komponenten.AktiveRedundanz.monitor.IMonitorEvent;
import komponenten.AktiveRedundanz.monitor.IStatusMonitorListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    int aktuelleInstanz;
    StatusEnum statusInstanz1, statusInstanz2;


    public DispatcherLogik(IMonitorEvent monitorEvent) {
        statusInstanz1 = StatusEnum.DEAD;
        statusInstanz2 = StatusEnum.DEAD;
        monitorEvent.schreibeFürInstanzStatusListenerEin(new IStatusMonitorListener() {
            @Override
            public void fuehreAktionAus(StatusEnum status) {
                statusInstanz1 = status;
//                System.out.println("Instanz1 -> "+status);
            }
        }, 1);


        monitorEvent.schreibeFürInstanzStatusListenerEin(new IStatusMonitorListener() {
            @Override
            public void fuehreAktionAus(StatusEnum status) {
                statusInstanz2 = status;
//                System.out.println("Instanz2 -> "+status);
            }
        }, 2);

        anzahlAufrufeInstanz1 = 0;
        anzahlAufrufeInstanz2 = 0;

        aktuelleInstanz = -1;

        monitorListenerMap.put(1, new ArrayList<IDispatcherListener>());
        monitorListenerMap.put(2, new ArrayList<IDispatcherListener>());


    }

    public void schreibeFürAnzahlDerFunktionsaufrufeDerSystemInstanzEin(IDispatcherListener listener, int systemInstanzID) {
//        if(!monitorListenerMap.containsKey(systemInstanzID)) {
//            monitorListenerMap.put(systemInstanzID, new ArrayList<IDispatcherListener>());
//        }
        monitorListenerMap.get(systemInstanzID).add(listener);
    }

    public int getZuVerwendendeSystemInstanzID() throws noServerAvailableException {
        switchSystemInstanz();
        if (aktuelleInstanz == -1) {
            throw new noServerAvailableException();
        } else if (aktuelleInstanz == 1) {
            anzahlAufrufeInstanz1++;
            wirfAnzahlFunktionsaufrufeEvent(1);
        } else if (aktuelleInstanz == 2) {
            anzahlAufrufeInstanz2++;
            wirfAnzahlFunktionsaufrufeEvent(2);
        }
        return aktuelleInstanz;
    }

    private int switchSystemInstanz() {
        if (aktuelleInstanz == 1) {
            if (statusInstanz2 == StatusEnum.ONLINE) {
                aktuelleInstanz = 2;
            } else if (statusInstanz1 == StatusEnum.ONLINE) {
                aktuelleInstanz = 1;
            } else {
                aktuelleInstanz = -1;
            }
        } else if (aktuelleInstanz == 2) {
            if (statusInstanz1 == StatusEnum.ONLINE) {
                aktuelleInstanz = 1;
            } else if (statusInstanz2 == StatusEnum.ONLINE) {
                aktuelleInstanz = 2;
            } else {
                aktuelleInstanz = -1;
            }
        } else if (aktuelleInstanz == -1 ){
            if (statusInstanz1 == StatusEnum.ONLINE){
                aktuelleInstanz = 1;
            } if (statusInstanz2 == StatusEnum.ONLINE){
                aktuelleInstanz = 2;
            }
        }
//        System.out.println("Instanz " + aktuelleInstanz + " ist verfügbar!");
        return aktuelleInstanz;
    }

    private void wirfAnzahlFunktionsaufrufeEvent(int id) {
        if (id == 1) {
            for (IDispatcherListener listener : monitorListenerMap.get(id)) {
                listener.führeAktionAus(anzahlAufrufeInstanz1);
            }
        } else if (id == 2) {
            for (IDispatcherListener listener : monitorListenerMap.get(id)) {
                listener.führeAktionAus(anzahlAufrufeInstanz2);
            }
        }
    }

//
//    public void schreibeFürAnzahlDerFunktionsaufrufeDerSystemInstanzEin(IDispatcherListener listener, int systemInstanzID) {
//        if(!monitorListenerMap.containsKey(systemInstanzID)) {
//        monitorListenerMap.put(systemInstanzID, new ArrayList<IDispatcherListener>());
//        }
//        monitorListenerMap.get(systemInstanzID).add(listener);
//    }
//
//    public int getZuVerwendendeSystemInstanzID() throws noServerAvailableException {
//        int aktiv = aktuelleInstanz;
//
//        if(aktiv == 1)  {
//            if(statusInstanz1.equals(StatusEnum.ONLINE))
//            {
//            anzahlAufrufeInstanz1++;
//            wirfEvent(1);
//            }
//            else
//            {
//                aktiv = 2;
//            }
//        }
//        if(aktiv == 2 )  {
//            if (statusInstanz2.equals(StatusEnum.ONLINE)) {
//            anzahlAufrufeInstanz2++;
//            wirfEvent(2);
//            }
//            else {
//                aktiv = 1;
//                if(statusInstanz1.equals(StatusEnum.ONLINE))
//                {
//                    anzahlAufrufeInstanz1++;
//                    wirfEvent(1);
//                }
//                else
//                {
//                    throw new noServerAvailableException();
//                }
//            }
//        }
//
//
//         return aktiv;
//    }
//

//
//    public void roundRobin()
//    {
//        aktuelleInstanz++;
//        aktuelleInstanz = (aktuelleInstanz%2)+1;
//    }


    //    public DispatcherLogik(IMonitorEvent monitorEvent) {
//        statusInstanz1 = StatusEnum.DEAD;
//        statusInstanz2 = StatusEnum.DEAD;
//        monitorEvent.schreibeFürInstanzStatusListenerEin(new IStatusMonitorListener() {
//            @Override
//            public void fuehreAktionAus(StatusEnum status) {
//                statusInstanz1 = status;
//            }
//        }, 1);
//
//        monitorEvent.schreibeFürInstanzStatusListenerEin(new IStatusMonitorListener() {
//            @Override
//            public void fuehreAktionAus(StatusEnum status) {
//                statusInstanz2 = status;
//            }
//        }, 2);
//
//        anzahlAufrufeInstanz1 = 0;
//        anzahlAufrufeInstanz2 = 0;
//        aktuelleInstanz = 1;
//        timer.schedule(timerTask1, 0, 1000);
//
//
//
//
//    }

}
