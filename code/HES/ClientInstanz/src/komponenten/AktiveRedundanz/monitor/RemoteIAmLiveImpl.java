package komponenten.AktiveRedundanz.monitor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 21.05.13
 * Time: 15:09
 * To change this template use File | Settings | File Templates.
 */
public class RemoteIAmLiveImpl extends UnicastRemoteObject implements IRemoteIAmALive {
    MonitorLogik logik;

    public RemoteIAmLiveImpl(MonitorLogik logik) throws RemoteException {
        this.logik = logik;
    }

    @Override
    public void iAmLive(int systemInstanzID) throws RemoteException {
        logik.iAmAlive(systemInstanzID);
    }
}
