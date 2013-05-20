import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 20.05.13
 * Time: 17:03
 * To change this template use File | Settings | File Templates.
 */
public class NameServer {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        LocateRegistry.createRegistry(1099);
        Naming.rebind("keepAlive",new Dummy());
        System.out.println("Server started...");
    }
}
