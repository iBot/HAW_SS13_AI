package komponenten.RMIClientAdapter;

import main.komponenten.kunden.IKundenManager;
import main.komponenten.lager.ILagerManager;
import main.komponenten.verkauf.IVerkaufManager;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 20.05.13
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 */
public interface IRMIClientAdapterManager extends IVerkaufManager, IKundenManager, ILagerManager {
}
