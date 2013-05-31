package komponenten.AktiveRedundanz.monitor;

import enums.StatusEnum;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Timer;


public class MonitorLogik {
    int timeOut;
    ListenerRepository listenerRepository;
    StatusEnum instanzStatus1 = StatusEnum.DEAD;
    StatusEnum instanzStatus2 = StatusEnum.DEAD;
    Timer timer1 = new Timer();
    Timer timer3 = new Timer();
    TimeOutTask timeOutTask = new TimeOutTask(this);
    long startTime = 0;
    long systemInstanz1Uptime = 0;
    long systemInstanz2Uptime = 0;
    long systemInstanz1Downtime = 0;
    long systemInstanz2Downtime = 0;
    long lastTimeSwitch1 = 0;
    long lastTimeSwitch2 = 0;
    boolean alive1 = false;
    boolean alive2 = false;

    public MonitorLogik(int timeOut) throws RemoteException, MalformedURLException {
        this.listenerRepository = new ListenerRepository();
        this.timeOut = timeOut;
        timer1.schedule(timeOutTask, 1000, timeOut);
        timer3.schedule(new TimeUpdateTask(this), 0, 1000);
        IRemoteIAmALive remoteIAmALive = new RemoteIAmLiveImpl(this);
        Naming.rebind("remoteIamAlive", remoteIAmALive);
        startTime = System.currentTimeMillis();
        lastTimeSwitch1 = startTime;
        lastTimeSwitch2 = startTime;
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
        upTimeAktuallisieren();
        if (systemInstanzID == 1) {
            instanzStatus1 = status;

            for (IStatusMonitorListener listener : listenerRepository.getStatusMonitorListener1List()){
                listener.fuehreAktionAus(status);
            }
        } else if (systemInstanzID == 2) {
            instanzStatus2 = status;
            for (IStatusMonitorListener listener : listenerRepository.getStatusMonitorListener2List()){
                listener.fuehreAktionAus(status);
            }
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
        System.out.println("I'm alive! " + systemInstanzID);
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

    private void upTimeAktuallisieren() {
        if (instanzStatus1 == StatusEnum.ONLINE)
            systemInstanz1Uptime += System.currentTimeMillis() - lastTimeSwitch1;
        if (instanzStatus2 == StatusEnum.ONLINE)
            systemInstanz2Uptime += System.currentTimeMillis() - lastTimeSwitch2;
    }

    void timeListenerausführen() {
        upTimeAktuallisieren();
        calcDownTime();
        for (IMonitorListener listener : listenerRepository.getMonitorListenerUptime1List()){
            listener.führeAktionAus(systemInstanz1Uptime);
        }
        for (IMonitorListener listener : listenerRepository.getMonitorListenerUptime2List()){
            listener.führeAktionAus(systemInstanz2Uptime);
        }
        for (IMonitorListener listener : listenerRepository.getMonitorListenerDowntime1List()){
            listener.führeAktionAus(systemInstanz1Downtime);
        }
        for (IMonitorListener listener : listenerRepository.getMonitorListenerDowntime2List()){
            listener.führeAktionAus(systemInstanz2Downtime);
        }

    }

    // vorher sollte man systemInstanzUptime updaten
    private void calcDownTime() {
        systemInstanz1Downtime = startTime - systemInstanz1Uptime;

        systemInstanz2Downtime = startTime - systemInstanz2Uptime;
    }
}
