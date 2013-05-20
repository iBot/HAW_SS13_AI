package komponenten.AktiveRedundanz.GUI;



import enums.StatusEnum;
import komponenten.AktiveRedundanz.monitor.IMonitorEvent;
import komponenten.AktiveRedundanz.monitor.IMonitorListener;
import komponenten.AktiveRedundanz.monitor.IMonitorManager;
import komponenten.AktiveRedundanz.monitor.IStatusMonitorListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 19.05.13
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
public class DashboardGUI {

    IMonitorManager monitorManager;
    IMonitorEvent monitorEvent;

    public DashboardGUI(IMonitorManager monitorManager, IMonitorEvent monitorEvent) {
        //DashboardGUI gui = new DashboardGUI();

        this.monitorManager  = monitorManager;
        this.monitorEvent = monitorEvent;

        //TODO UUIDs der Instanzen...muessen wir die abfragen oder sind die einfach fest und wir wissen die?
        monitorEvent.schreibeFürInstanzStatusListenerEin(new IStatusMonitorListener() {
            @Override
            public void fuehreAktionAus(StatusEnum status) {
               statusAenderung(UUID.randomUUID(), status);
            }
        }, UUID.randomUUID());

        monitorEvent.schreibeFürInstanzStatusListenerEin(new IStatusMonitorListener() {
            @Override
            public void fuehreAktionAus(StatusEnum status) {
                statusAenderung(UUID.randomUUID(), status);
            }
        }, UUID.randomUUID());

        monitorEvent.schreibeFürDowntimeÄnderungEin(new IMonitorListener() {
            @Override
            public void führeAktionAus(long millisec) {
                textFieldDowntime1.setText(millisec);
                textFieldDowntime2.setText(millisec);
            }
        }, UUID.randomUUID());

        monitorEvent.schreibeFürUptimeÄnderungEin(new IMonitorListener() {
            @Override
            public void führeAktionAus(long millisec) {
                textFieldUptime1.setText(""+millisec);
                textFieldUptime2.setText(""+millisec);
            }
        }, UUID.randomUUID());


        buttonSetStatusInstanz1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
              buttonSetStatusInstanz1MouseClicked(evt);
            }
        });
        buttonSetStatusInstanz2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSetStatusInstanz2MouseClicked(evt);
            }
        });
    }

    private void statusAenderung(UUID uuid, StatusEnum status) {
        if(status.toString().equals("Offline"))
        {
            buttonSetStatusInstanz1.setText("online");
            buttonSetStatusInstanz2.setText("online");
            notActiveInstanz2.setBackground(Color.red);
            notActiveInstanz1.setBackground(Color.red);
            activeInstanz1.setBackground(Color.black);
            activeInstanz2.setBackground(Color.black);
        }
        else if(status.toString().equals("Online"))
        {
            buttonSetStatusInstanz1.setText("offline");
            buttonSetStatusInstanz2.setText("offline");
            notActiveInstanz2.setBackground(Color.black);
            notActiveInstanz1.setBackground(Color.black);
            activeInstanz1.setBackground(Color.green);
            activeInstanz2.setBackground(Color.green);
        }
    }

    private void buttonSetStatusInstanz1MouseClicked(MouseEvent evt) {
        if(buttonSetStatusInstanz1.getText().equals("online"))
        {
            monitorManager.setInstanceStatus(StatusEnum.ONLINE, 1);
            buttonSetStatusInstanz1.setText("offline");
        }
        else if(buttonSetStatusInstanz1.getText().equals("offline"))
        {
            monitorManager.setInstanceStatus(Offline, 1);
            buttonSetStatusInstanz1.setText("online");
        }
    }

    private void buttonSetStatusInstanz2MouseClicked(MouseEvent evt)
    {
        if(buttonSetStatusInstanz2.getText().equals("online"))
        {
            monitorManager.setInstanceStatus(Online, 2);
            buttonSetStatusInstanz2.setText("offline");
        }
        else if(buttonSetStatusInstanz2.getText().equals("offline"))
        {
            monitorManager.setInstanceStatus(Offline, 2);
            buttonSetStatusInstanz2.setText("online");
        }
    }



    private JPanel notActiveInstanz1;
    private JPanel notActiveInstanz2;
    private JPanel activeInstanz2;
    private JPanel ampelInstanz1;
    private JPanel ampelInstanz2;
    private JButton buttonSetStatusInstanz2;
    private JButton buttonSetStatusInstanz1;
    private JPanel panelInstanz2;
    private JPanel panelInstanz1;
    private JTextField textFieldUptime1;
    private JLabel labelDowntimeInstanz1;
    private JTextField textFieldAnzahl2;
    private JTextField textFieldUptime2;
    private JPanel activeInstanz1;
    private JTextField textFieldAnzahlInstanz1;
    private JTextField textFieldDowntime1;
    private JTextField textFieldDowntime2;


}
