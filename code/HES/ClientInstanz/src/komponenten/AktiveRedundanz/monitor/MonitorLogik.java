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
            listenerRepository.setStatusMonitorListener1(listener);
        } else
            listenerRepository.setStatusMonitorListener2(listener);
    }

    public void schreibeFürUptimeÄnderungEin(IMonitorListener listener, int systemInstanzID) {
        if (systemInstanzID == 1) {
            listenerRepository.setMonitorListenerUptime1(listener);
        } else
            listenerRepository.setMonitorListenerUptime2(listener);
    }

    public void schreibeFürDowntimeÄnderungEin(IMonitorListener listener, int systemInstanzID) {
        if (systemInstanzID == 1) {
            listenerRepository.setMonitorListenerDowntime1(listener);
        } else
            listenerRepository.setMonitorListenerDowntime2(listener);
    }

    public void setInstanceStatus(StatusEnum status, int systemInstanzID) {
        upTimeAktuallisieren();
        if (systemInstanzID == 1) {
            instanzStatus1 = status;
        } else
            instanzStatus2 = status;

        //Alle Status Listener Feuern
        listenerRepository.getStatusMonitorListener1().fuehreAktionAus(status);
        listenerRepository.getStatusMonitorListener2().fuehreAktionAus(status);
    }

    //called by TimeOuttaks every <timeout> msec
    public void setDeadIfdead(){
        if(!alive1){
            setInstanceStatus(StatusEnum.DEAD,1);

        }
        if(!alive2){
            setInstanceStatus(StatusEnum.DEAD,2);
        }
        alive1=false;
        alive2=false;
    }

    //called by Serverinstanz
    public void iAmAlive(int systemInstanzID) {
        if (systemInstanzID == 1) {
            alive1=true;
            if(instanzStatus1==StatusEnum.DEAD)
                setInstanceStatus(StatusEnum.ONLINE,1);
        } else {
            alive2=true;
            if(instanzStatus2==StatusEnum.DEAD)
                setInstanceStatus(StatusEnum.ONLINE,2);
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
        if (listenerRepository.isMonitorListenerUptime1Initalized())
            listenerRepository.getMonitorListenerUptime1().führeAktionAus(systemInstanz1Uptime);
        if (listenerRepository.isMonitorListenerUptime2Initalized())
            listenerRepository.getMonitorListenerUptime2().führeAktionAus(systemInstanz2Uptime);
        if (listenerRepository.isMonitorListenerDowntime1Initalized())
            listenerRepository.getMonitorListenerDowntime1().führeAktionAus(systemInstanz1Downtime);
        if (listenerRepository.isMonitorListenerDowntime2Initalized())
            listenerRepository.getMonitorListenerDowntime2().führeAktionAus(systemInstanz2Downtime);
    }

    // vorher sollte man systemInstanzUptime updaten
    private void calcDownTime() {
        systemInstanz1Downtime = startTime - systemInstanz1Uptime;

        systemInstanz2Downtime = startTime - systemInstanz2Uptime;
    }
}
