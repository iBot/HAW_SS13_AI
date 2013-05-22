package komponenten.AktiveRedundanz.monitor;

import java.util.ArrayList;
import java.util.List;


class ListenerRepository {

    // Alles ganz Quick and dirty
    IMonitorListener monitorListenerUptime1;
    IMonitorListener monitorListenerUptime2;
    IMonitorListener monitorListenerDowntime1;
    IMonitorListener monitorListenerDowntime2;

    IStatusMonitorListener statusMonitorListener1;
    IStatusMonitorListener statusMonitorListener2;

    public boolean isMonitorListenerUptime1Initalized(){
        return (monitorListenerUptime1!=null) ? true : false;
    }
    public boolean isMonitorListenerUptime2Initalized(){
        return (monitorListenerUptime2!=null) ? true : false;
    }
    public boolean isMonitorListenerDowntime1Initalized(){
        return (monitorListenerDowntime1!=null) ? true : false;
    }
    public boolean isMonitorListenerDowntime2Initalized(){
        return (monitorListenerDowntime2!=null) ? true : false;
    }
    public boolean isStatusMonitorListener1Initalized(){
        return (statusMonitorListener1!=null) ? true : false;
    }
    public boolean isStatusMonitorListener2Initalized(){
        return (statusMonitorListener2!=null) ? true : false;
    }

    public IMonitorListener getMonitorListenerUptime1() {
        return monitorListenerUptime1;
    }

    public void setMonitorListenerUptime1(IMonitorListener monitorListenerUptime1) {
        this.monitorListenerUptime1 = monitorListenerUptime1;
    }

    public IMonitorListener getMonitorListenerUptime2() {
        return monitorListenerUptime2;
    }

    public void setMonitorListenerUptime2(IMonitorListener monitorListenerUptime2) {
        this.monitorListenerUptime2 = monitorListenerUptime2;
    }

    public IMonitorListener getMonitorListenerDowntime1() {
        return monitorListenerDowntime1;
    }

    public void setMonitorListenerDowntime1(IMonitorListener monitorListenerDowntime1) {
        this.monitorListenerDowntime1 = monitorListenerDowntime1;
    }

    public IMonitorListener getMonitorListenerDowntime2() {
        return monitorListenerDowntime2;
    }

    public void setMonitorListenerDowntime2(IMonitorListener monitorListenerDowntime2) {
        this.monitorListenerDowntime2 = monitorListenerDowntime2;
    }

    public IStatusMonitorListener getStatusMonitorListener1() {
        return statusMonitorListener1;
    }

    public void setStatusMonitorListener1(IStatusMonitorListener statusMonitorListener1) {
        this.statusMonitorListener1 = statusMonitorListener1;
    }

    public IStatusMonitorListener getStatusMonitorListener2() {
        return statusMonitorListener2;
    }

    public void setStatusMonitorListener2(IStatusMonitorListener statusMonitorListener2) {
        this.statusMonitorListener2 = statusMonitorListener2;
    }
}
