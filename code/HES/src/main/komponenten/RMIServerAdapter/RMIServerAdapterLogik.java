package main.komponenten.RMIServerAdapter;

import main.allgemeineTypen.transportTypen.*;
import main.komponenten.kunden.IKundenManager;
import main.komponenten.lager.ILagerManager;
import main.komponenten.lager.IReserviertListener;
import main.komponenten.verkauf.IVerkaufManager;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 20.05.13
 * Time: 17:58
 * To change this template use File | Settings | File Templates.
 */
public class RMIServerAdapterLogik {

    public RMIServerAdapterLogik(IKundenManager kundenManager, IVerkaufManager verkaufManager, ILagerManager lagerManager, int  serverInstanceID) throws RemoteException, MalformedURLException {
        IRemoteAWK remoteAWK = new RemoteAWKImpl(kundenManager,verkaufManager,lagerManager);
        //Brauch noch nen identifier
        Naming.rebind("remoteAWK_"+serverInstanceID,remoteAWK);
    }
}
