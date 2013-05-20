import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 20.05.13
 * Time: 17:36
 * To change this template use File | Settings | File Templates.
 */
// Hält die Registry am Leben
public class Dummy extends UnicastRemoteObject implements Remote {
    protected Dummy() throws RemoteException {
        super();
    }
}
