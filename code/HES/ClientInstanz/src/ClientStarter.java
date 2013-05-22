import komponenten.AktiveRedundanz.GUI.DashboardGUI;
import komponenten.AktiveRedundanz.dispatcher.DispatcherFassade;
import komponenten.AktiveRedundanz.dispatcher.IDispatcherManager;
import komponenten.AktiveRedundanz.monitor.IMonitorManager;
import komponenten.AktiveRedundanz.monitor.MonitorFassade;
import komponenten.RMIClientAdapter.IRMIClientAdapterManager;
import komponenten.RMIClientAdapter.RMIClientAdapterFassade;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 22.05.13
 * Time: 09:32
 * To change this template use File | Settings | File Templates.
 */
public class ClientStarter {


    public static void main(String[] args){
        MonitorFassade monitor = new MonitorFassade(2000);
        DispatcherFassade dispatcher = new DispatcherFassade(monitor);
        IRMIClientAdapterManager manager = new RMIClientAdapterFassade(dispatcher);
        DashboardGUI gui = new DashboardGUI(monitor,monitor,dispatcher);
    }
}
