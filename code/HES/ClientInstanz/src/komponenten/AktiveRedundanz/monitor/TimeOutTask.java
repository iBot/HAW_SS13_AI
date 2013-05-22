package komponenten.AktiveRedundanz.monitor;

import enums.StatusEnum;

import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 21.05.13
 * Time: 15:15
 * To change this template use File | Settings | File Templates.
 */
public class TimeOutTask extends TimerTask {
    MonitorLogik logik;
    int systemInstanzID;

    public TimeOutTask(MonitorLogik logik, int systemInstanzID) {
        this.logik = logik;
        this.systemInstanzID = systemInstanzID;
    }

    @Override
    public void run() {
        logik.setInstanceStatus(StatusEnum.DEAD,systemInstanzID);
    }
}
