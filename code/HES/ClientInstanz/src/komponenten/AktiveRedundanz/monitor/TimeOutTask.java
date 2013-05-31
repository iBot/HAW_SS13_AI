package komponenten.AktiveRedundanz.monitor;


import java.util.TimerTask;


public class TimeOutTask extends TimerTask {
    MonitorLogik logik;

    public TimeOutTask(MonitorLogik logik) {
        this.logik = logik;
    }

    @Override
    public void run() {
        logik.setDeadIfdead();
    }
}
