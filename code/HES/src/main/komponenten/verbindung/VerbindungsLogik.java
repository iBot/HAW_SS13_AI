package main.komponenten.verbindung;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Timer;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 21.05.13
 * Time: 15:23
 * To change this template use File | Settings | File Templates.
 */
public class VerbindungsLogik {
    int systemInstanzID;
    IAmAliveTask iAmAliveTask;

    public VerbindungsLogik(int systemInstanzID, int iAmAlivePeriod) throws MalformedURLException, NotBoundException, RemoteException {
        this.systemInstanzID = systemInstanzID;
        String url = "remoteIamAlive";
        IRemoteIAmALive remoteIAmALive = (IRemoteIAmALive) Naming.lookup(url);
        iAmAliveTask = new IAmAliveTask(remoteIAmALive,systemInstanzID);

        Timer timer = new Timer();
        timer.schedule(iAmAliveTask,0,iAmAlivePeriod);
    }
}
