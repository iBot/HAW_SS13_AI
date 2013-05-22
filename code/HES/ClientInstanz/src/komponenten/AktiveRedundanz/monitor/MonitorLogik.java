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
    Timer timer = new Timer();
    TimeOutTask timeOutTask1 = new TimeOutTask(this,1);
    TimeOutTask timeOutTask2 = new TimeOutTask(this,2);

    public MonitorLogik(int timeOut) throws RemoteException, MalformedURLException {
        this.listenerRepository = new ListenerRepository();
        this.timeOut = timeOut;
        timer.schedule(timeOutTask1,timeOut);
        timer.schedule(timeOutTask2,timeOut);
        IRemoteIAmALive remoteIAmALive = new RemoteIAmLiveImpl(this);
        Naming.rebind("remoteIamAlive",remoteIAmALive);

    }


    public void schreibeFürInstanzStatusListenerEin(IStatusMonitorListener listener, int systemInstanzID) {
        if(systemInstanzID == 1){
            listenerRepository.setStatusMonitorListener1(listener);
        }
        else
            listenerRepository.setStatusMonitorListener2(listener);
    }

    public void schreibeFürUptimeÄnderungEin(IMonitorListener listener, int systemInstanzID) {
        if(systemInstanzID == 1){
            listenerRepository.setMonitorListenerUptime1(listener);
        }
        else
            listenerRepository.setMonitorListenerUptime2(listener);
    }

    public void schreibeFürDowntimeÄnderungEin(IMonitorListener listener, int systemInstanzID) {
        if(systemInstanzID == 1){
            listenerRepository.setMonitorListenerDowntime1(listener);
        }
        else
            listenerRepository.setMonitorListenerDowntime2(listener);
    }

    public void setInstanceStatus(StatusEnum status, int systemInstanzID) {
        if(systemInstanzID == 1){
            instanzStatus1 = status;
        }
        else
            instanzStatus2 = status;

        //Alle Status Listener Feuern
        listenerRepository.getStatusMonitorListener1().fuehreAktionAus(status);
        listenerRepository.getStatusMonitorListener2().fuehreAktionAus(status);
    }

    public void iAmAlive(int systemInstanzID) {
        if(systemInstanzID == 1){
            timeOutTask1.cancel();
            timer.schedule(timeOutTask1,timeOut);
        }
        else
            timeOutTask1.cancel();
            timer.schedule(timeOutTask2,timeOut);
    }
}
