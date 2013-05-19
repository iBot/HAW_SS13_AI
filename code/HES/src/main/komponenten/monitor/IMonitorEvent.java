package main.komponenten.monitor;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 19.05.13
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */
public interface IMonitorEvent {

    void schreibeFürInstanzStatusListenerEin(IStatusMonitorListener listener, UUID systemInstanzID);

    void schreibeFürUptimeÄnderungEin(IMonitorListener listener, UUID systemInstanzID);

    void schreibeFürDowntimeÄnderungEin(IMonitorListener listener, UUID systemInstanzID);
}
