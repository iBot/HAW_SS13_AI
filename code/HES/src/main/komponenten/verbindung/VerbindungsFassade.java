package main.komponenten.verbindung;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 20.05.13
 * Time: 17:01
 * To change this template use File | Settings | File Templates.
 */
public class VerbindungsFassade {
    VerbindungsLogik logik;
    int systemInstanzID;

    public VerbindungsFassade(int systemInstanzID, int iAmAlivePeriod) {
        this.systemInstanzID = systemInstanzID;
        try {
            this.logik = new VerbindungsLogik(systemInstanzID, iAmAlivePeriod);
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NotBoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
