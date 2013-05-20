package komponenten.AktiveRedundanz.monitor;

import enums.StatusEnum;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 20.05.13
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */
public class MonitorFassade implements IMonitorManager, IMonitorEvent {



    @Override
    public void schreibeFürInstanzStatusListenerEin(IStatusMonitorListener listener, UUID systemInstanzID) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void schreibeFürUptimeÄnderungEin(IMonitorListener listener, UUID systemInstanzID) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void schreibeFürDowntimeÄnderungEin(IMonitorListener listener, UUID systemInstanzID) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setInstanceStatus(StatusEnum status, UUID systemInstanzID) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
