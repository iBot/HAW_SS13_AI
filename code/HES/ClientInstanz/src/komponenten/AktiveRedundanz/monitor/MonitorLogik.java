package komponenten.AktiveRedundanz.monitor;

import com.google.common.base.Stopwatch;
import enums.StatusEnum;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Timer;


public class MonitorLogik {
    private final Stopwatch instance1DownStopWatch;
    private final Stopwatch instance1UpStopWatch;
    private final Stopwatch instance2DownStopWatch;
    private final Stopwatch instance2UpStopWatch;
    int timeOut;
    ListenerRepository listenerRepository;
    StatusEnum instanzStatus1 = StatusEnum.DEAD;
    StatusEnum instanzStatus2 = StatusEnum.DEAD;
    Timer timer1 = new Timer();
    Timer timer3 = new Timer();
    TimeOutTask timeOutTask = new TimeOutTask(this);
    long startTime = 0;
    long lastTimeChecked1 = 0;
    long lastTimeChecked2 = 0;
    boolean alive1 = false;
    boolean alive2 = false;
//    private  Stopwatch instance1UpStopWatch, instance1DownStopWatch, instance2UpStopWatch, instance2DownStopWatch;

    public MonitorLogik(int timeOut) throws RemoteException, MalformedURLException {
        this.listenerRepository = new ListenerRepository();
        this.timeOut = timeOut;
        timer1.schedule(timeOutTask, 1000, timeOut);
        timer3.schedule(new TimeUpdateTask(this), 0, 1000);
        IRemoteIAmALive remoteIAmALive = new RemoteIAmLiveImpl(this);
        Naming.rebind("remoteIamAlive", remoteIAmALive);
        startTime = System.currentTimeMillis();
        lastTimeChecked1 = startTime;
        lastTimeChecked2 = startTime;
        instance1DownStopWatch = new Stopwatch();
        instance1UpStopWatch = new Stopwatch();
        instance2DownStopWatch = new Stopwatch();
        instance2UpStopWatch = new Stopwatch();

        instance2DownStopWatch.start();
        instance1DownStopWatch.start();
    }

    public void schreibeFürInstanzStatusListenerEin(IStatusMonitorListener listener, int systemInstanzID) {
        if (systemInstanzID == 1) {
            listenerRepository.addStatusMonitorListener1(listener);
        } else if (systemInstanzID == 2) {
            listenerRepository.addStatusMonitorListener2(listener);
        }

    }

    public void schreibeFürUptimeÄnderungEin(IMonitorListener listener, int systemInstanzID) {
        if (systemInstanzID == 1) {
            listenerRepository.addMonitorListenerUptime1(listener);
        } else
            listenerRepository.addMonitorListenerUptime2(listener);
    }

    public void schreibeFürDowntimeÄnderungEin(IMonitorListener listener, int systemInstanzID) {
        if (systemInstanzID == 1) {
            listenerRepository.addMonitorListenerDowntime1(listener);
        } else
            listenerRepository.addMonitorListenerDowntime2(listener);
    }

    public void setInstanceStatus(StatusEnum status, int systemInstanzID) {
        if (systemInstanzID == 1) {
            instanzStatus1 = status;

            for (IStatusMonitorListener listener : listenerRepository.getStatusMonitorListener1List()) {
                listener.fuehreAktionAus(status);
            }
        } else if (systemInstanzID == 2) {
            instanzStatus2 = status;
            for (IStatusMonitorListener listener : listenerRepository.getStatusMonitorListener2List()) {
                listener.fuehreAktionAus(status);
            }
        }

        setStopwatches();
    }

    private void setStopwatches() {
        if (instanzStatus1 == StatusEnum.ONLINE) {
            if (!instance1UpStopWatch.isRunning()) instance1UpStopWatch.start();
            if (instance1DownStopWatch.isRunning()) instance1DownStopWatch.stop();
        } else {
            if (instance1UpStopWatch.isRunning()) instance1UpStopWatch.stop();
            if (!instance1DownStopWatch.isRunning()) instance1DownStopWatch.start();
        }

        if (instanzStatus2 == StatusEnum.ONLINE) {
            if (!instance2UpStopWatch.isRunning()) instance2UpStopWatch.start();
            if (instance2DownStopWatch.isRunning()) instance2DownStopWatch.stop();
        } else {
            if (instance2UpStopWatch.isRunning()) instance2UpStopWatch.stop();
            if (!instance2DownStopWatch.isRunning()) instance2DownStopWatch.start();
        }
    }

    //called by TimeOuttaks every <timeout> msec
    public void setDeadIfdead() {
        if (!alive1) {
            setInstanceStatus(StatusEnum.DEAD, 1);

        }
        if (!alive2) {
            setInstanceStatus(StatusEnum.DEAD, 2);
        }
        alive1 = false;
        alive2 = false;
    }

    //called by Serverinstanz
    public void iAmAlive(int systemInstanzID) {
//        System.out.println("I'm alive! " + systemInstanzID);
        if (systemInstanzID == 1) {
            alive1 = true;
            if (instanzStatus1 == StatusEnum.DEAD) {
                setInstanceStatus(StatusEnum.ONLINE, 1);
            }
        } else if (systemInstanzID == 2) {
            alive2 = true;
            if (instanzStatus2 == StatusEnum.DEAD) {
                setInstanceStatus(StatusEnum.ONLINE, 2);
            }
        }
    }

    @SuppressWarnings("deprecation")
    void timeListenerausführen() {

        for (IMonitorListener listener : listenerRepository.getMonitorListenerUptime1List()) {
            listener.führeAktionAus(instance1UpStopWatch.elapsedMillis());
        }
        for (IMonitorListener listener : listenerRepository.getMonitorListenerUptime2List()) {
            listener.führeAktionAus(instance2UpStopWatch.elapsedMillis());
        }
        for (IMonitorListener listener : listenerRepository.getMonitorListenerDowntime1List()) {
            listener.führeAktionAus(instance1DownStopWatch.elapsedMillis());
        }
        for (IMonitorListener listener : listenerRepository.getMonitorListenerDowntime2List()) {
            listener.führeAktionAus(instance2DownStopWatch.elapsedMillis());
        }

    }


}
