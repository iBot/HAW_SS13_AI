package komponenten.RMIClientAdapter;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 22.05.13
 * Time: 10:19
 * To change this template use File | Settings | File Templates.
 */
public class BinderTask  extends TimerTask{

    private RMIClientAdapterLogik adapterLogik;

    public BinderTask(RMIClientAdapterLogik adapterLogik){
        this.adapterLogik = adapterLogik;
    }
    @Override
    public void run() {
        try {
            adapterLogik.bind();
        } catch (RemoteException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NotBoundException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (MalformedURLException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
