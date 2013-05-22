package main.komponenten.verbindung;

import java.rmi.RemoteException;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 21.05.13
 * Time: 15:24
 * To change this template use File | Settings | File Templates.
 */
public class IAmAliveTask extends TimerTask {
    IRemoteIAmALive remoteIAmALive;
    int systemInstanzID;

    public IAmAliveTask(IRemoteIAmALive remoteIAmALive, int systemInstanzID) {
        this.remoteIAmALive = remoteIAmALive;
        this.systemInstanzID = systemInstanzID;
    }

    @Override
    public void run() {
        try {
            remoteIAmALive.iAmLive(systemInstanzID);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
