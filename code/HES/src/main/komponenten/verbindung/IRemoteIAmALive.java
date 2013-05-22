package main.komponenten.verbindung;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 21.05.13
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */
public interface IRemoteIAmALive extends Remote{
    public void iAmLive(int systemInstanzID) throws RemoteException;
}
