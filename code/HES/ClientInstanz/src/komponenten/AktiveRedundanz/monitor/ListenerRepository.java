package komponenten.AktiveRedundanz.monitor;

import java.util.ArrayList;
import java.util.List;


class ListenerRepository {


    List<IMonitorListener> monitorListenerUptime1List = new ArrayList<>();
    List<IMonitorListener> monitorListenerUptime2List = new ArrayList<>();
    List<IMonitorListener> monitorListenerDowntime1List = new ArrayList<>();
    List<IMonitorListener> monitorListenerDowntime2List = new ArrayList<>();
    List<IStatusMonitorListener> statusMonitorListener1List = new ArrayList<>();
    List<IStatusMonitorListener> statusMonitorListener2List = new ArrayList<>();

    public List<IMonitorListener> getMonitorListenerUptime1List() {
        return new ArrayList<>(monitorListenerUptime1List);
    }

    public void addMonitorListenerUptime1(IMonitorListener monitorListenerUptime1) {
        this.monitorListenerUptime1List.add(monitorListenerUptime1);
    }

    public List<IMonitorListener> getMonitorListenerUptime2List() {
        return new ArrayList<>(monitorListenerUptime2List);
    }

    public void addMonitorListenerUptime2(IMonitorListener monitorListenerUptime2) {
        this.monitorListenerUptime2List.add(monitorListenerUptime2);
    }

    public List<IMonitorListener> getMonitorListenerDowntime1List() {
        return new ArrayList<>(monitorListenerDowntime1List);
    }

    public void addMonitorListenerDowntime1(IMonitorListener monitorListenerDowntime1) {
        this.monitorListenerDowntime1List.add(monitorListenerDowntime1);
    }

    public List<IMonitorListener> getMonitorListenerDowntime2List() {
        return new ArrayList<>(monitorListenerDowntime2List);
    }

    public void addMonitorListenerDowntime2(IMonitorListener monitorListenerDowntime2) {
        this.monitorListenerDowntime2List.add(monitorListenerDowntime2);
    }

    public List<IStatusMonitorListener> getStatusMonitorListener1List() {
        return new ArrayList<>(statusMonitorListener1List);
    }

    public void addStatusMonitorListener1(IStatusMonitorListener statusMonitorListener1) {
        System.out.println("setStatusMonitorListerner1 wurde aufgerufen");
        this.statusMonitorListener1List.add(statusMonitorListener1);
    }

    public List<IStatusMonitorListener> getStatusMonitorListener2List() {
        return new ArrayList<>(statusMonitorListener2List);
    }

    public void addStatusMonitorListener2(IStatusMonitorListener statusMonitorListener2) {
        System.out.println("setStatusMonitorListerner2 wurde aufgerufen");
        this.statusMonitorListener2List.add(statusMonitorListener2);
    }
}
