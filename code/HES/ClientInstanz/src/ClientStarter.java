import komponenten.AktiveRedundanz.GUI.DashboardGUI;
import komponenten.AktiveRedundanz.dispatcher.DispatcherFassade;
import komponenten.AktiveRedundanz.monitor.MonitorFassade;
import komponenten.Client;
import komponenten.RMIClientAdapter.IRMIClientAdapterManager;
import komponenten.RMIClientAdapter.RMIClientAdapterFassade;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 22.05.13
 * Time: 09:32
 * To change this template use File | Settings | File Templates.
 */
public class ClientStarter {


    public static void main(String[] args) {
        MonitorFassade monitor = new MonitorFassade(2000);
        DispatcherFassade dispatcher = new DispatcherFassade(monitor);
        IRMIClientAdapterManager manager = new RMIClientAdapterFassade(dispatcher);
        DashboardGUI gui = new DashboardGUI(monitor, monitor, dispatcher);
//
        JFrame frame = new JFrame("Gui");
        frame.setContentPane(gui.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Client client = new Client(dispatcher);
        Scanner sc = new Scanner(System.in);
        int eingabe = sc.nextInt();
        if (eingabe == 1) {
            client.szenario();
        }
    }
}
