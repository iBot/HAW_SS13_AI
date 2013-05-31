package komponenten.AktiveRedundanz.monitor;

import enums.StatusEnum;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 20.05.13
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */
public class MonitorFassade implements IMonitorManager, IMonitorEvent {
    MonitorLogik logik;
    int timeOut;

    public MonitorFassade(int timeOut) {
        try {
            this.logik = new MonitorLogik(timeOut);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        this.timeOut = timeOut;
    }

    @Override
    public void schreibeFürInstanzStatusListenerEin(IStatusMonitorListener listener, int systemInstanzID) {
        logik.schreibeFürInstanzStatusListenerEin(listener,systemInstanzID);
    }

    @Override
    public void schreibeFürUptimeÄnderungEin(IMonitorListener listener, int systemInstanzID) {
       logik.schreibeFürUptimeÄnderungEin(listener,systemInstanzID);
    }

    @Override
    public void schreibeFürDowntimeÄnderungEin(IMonitorListener listener, int systemInstanzID) {
       logik.schreibeFürDowntimeÄnderungEin(listener,systemInstanzID);
    }

    @Override
    public void setInstanceStatus(StatusEnum status, int systemInstanzID) {
       logik.setInstanceStatus(status,systemInstanzID);
    }
}
