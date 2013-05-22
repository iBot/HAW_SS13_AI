package komponenten.AktiveRedundanz.dispatcher;

import java.util.TimerTask;


/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 21.05.13
 * Time: 15:15
 * To change this template use File | Settings | File Templates.
 */
public class RRTimerTask extends TimerTask {

    int systemInstanzID;
    DispatcherLogik logik;

    public RRTimerTask(DispatcherLogik logik) {
        this.logik = logik;
        this.systemInstanzID = systemInstanzID;
    }

    @Override
    public void run() {
        logik.roundRobin();
    }
}

