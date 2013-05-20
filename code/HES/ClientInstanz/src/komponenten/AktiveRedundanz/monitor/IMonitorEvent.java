package komponenten.AktiveRedundanz.monitor;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 19.05.13
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */
public interface IMonitorEvent {

    void schreibeFürInstanzStatusListenerEin(IStatusMonitorListener listener, int systemInstanzID);

    void schreibeFürUptimeÄnderungEin(IMonitorListener listener, int systemInstanzID);

    void schreibeFürDowntimeÄnderungEin(IMonitorListener listener, int systemInstanzID);
}
