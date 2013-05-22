package komponenten.AktiveRedundanz.monitor;

import java.util.TimerTask;

public class TimeUpdateTask extends TimerTask {
    MonitorLogik logik;

    public TimeUpdateTask(MonitorLogik logik) {
        this.logik = logik;
    }

    @Override
    public void run() {
        logik.timeListenerausführen();
    }
}
