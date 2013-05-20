package main.komponenten.RMIServerAdapter;

import main.allgemeineTypen.transportTypen.*;
import main.komponenten.kunden.IKundenManager;
import main.komponenten.lager.ILagerManager;
import main.komponenten.lager.IReserviertListener;
import main.komponenten.verkauf.IVerkaufManager;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 20.05.13
 * Time: 16:56
 * To change this template use File | Settings | File Templates.
 */
public class RMIServerAdapterFassade{
    RMIServerAdapterLogik logik;

    public RMIServerAdapterFassade(IKundenManager kundenManager, ILagerManager lagerManager, IVerkaufManager verkaufManager) {
        try {
            this.logik = new RMIServerAdapterLogik(kundenManager,verkaufManager,lagerManager);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
