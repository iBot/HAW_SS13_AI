package komponenten.AktiveRedundanz.GUI;


import enums.StatusEnum;
import komponenten.AktiveRedundanz.dispatcher.IDispatcherEvent;
import komponenten.AktiveRedundanz.dispatcher.IDispatcherListener;
import komponenten.AktiveRedundanz.monitor.IMonitorEvent;
import komponenten.AktiveRedundanz.monitor.IMonitorListener;
import komponenten.AktiveRedundanz.monitor.IMonitorManager;
import komponenten.AktiveRedundanz.monitor.IStatusMonitorListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 19.05.13
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
public class DashboardGUI extends JFrame{

    IMonitorManager monitorManager;
    IMonitorEvent monitorEvent;
    IDispatcherEvent dispatcherEvent;


    private JPanel redInstanz1;
    private JPanel redInstanz2;
    private JPanel greenInstanz2;
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
    private JPanel yellowInstanz1;
    private JPanel greenInstanz1;
    private JPanel yellowInstanz2;
    public JPanel mainPanel;



    public DashboardGUI(IMonitorManager monitorManager, IMonitorEvent monitorEvent, IDispatcherEvent dispatcherEvent) {
        //DashboardGUI gui = new DashboardGUI();

        this.monitorManager = monitorManager;
        this.monitorEvent = monitorEvent;
        this.dispatcherEvent = dispatcherEvent;

        monitorEvent.schreibeFürInstanzStatusListenerEin(new IStatusMonitorListener() {
            @Override
            public void fuehreAktionAus(StatusEnum status) {
                statusAenderungInstanz1(status);
            }
        }, 1);

        monitorEvent.schreibeFürInstanzStatusListenerEin(new IStatusMonitorListener() {
            @Override
            public void fuehreAktionAus(StatusEnum status) {
                statusAenderungInstanz2(status);
            }
        }, 2);

        monitorEvent.schreibeFürDowntimeÄnderungEin(new IMonitorListener() {
            @Override
            public void führeAktionAus(long millisec) {
                textFieldDowntime1.setText("" + millisec);
            }
        }, 1);

        monitorEvent.schreibeFürDowntimeÄnderungEin(new IMonitorListener() {
            @Override
            public void führeAktionAus(long millisec) {
                textFieldDowntime2.setText("" + millisec);
            }
        }, 2);

        monitorEvent.schreibeFürUptimeÄnderungEin(new IMonitorListener() {
            @Override
            public void führeAktionAus(long millisec) {
                textFieldUptime1.setText("" + millisec);
            }
        }, 1);

        monitorEvent.schreibeFürUptimeÄnderungEin(new IMonitorListener() {
            @Override
            public void führeAktionAus(long millisec) {
                textFieldUptime2.setText("" + millisec);
            }
        }, 2);

        dispatcherEvent.schreibeFürAnzahlDerFunktionsaufrufeDerSystemInstanzEin(new IDispatcherListener() {
            @Override
            public void führeAktionAus(int anzahl) {
                textFieldAnzahlInstanz1.setText("" + anzahl);
            }
        }, 1);

        dispatcherEvent.schreibeFürAnzahlDerFunktionsaufrufeDerSystemInstanzEin(new IDispatcherListener() {
            @Override
            public void führeAktionAus(int anzahl) {
                textFieldAnzahl2.setText("" + anzahl);
            }
        }, 2);

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

    private void statusAenderungInstanz1(StatusEnum status) {
        if (status.equals(StatusEnum.OFFLINE)) {
            buttonSetStatusInstanz1.setText("online");
            buttonSetStatusInstanz1.setEnabled(true);
            redInstanz1.setBackground(Color.black);
            greenInstanz1.setBackground(Color.black);
            yellowInstanz1.setBackground(Color.yellow);

        } else if (status.equals(StatusEnum.ONLINE)) {
            buttonSetStatusInstanz1.setText("offline");
            buttonSetStatusInstanz1.setEnabled(true);
            redInstanz1.setBackground(Color.black);
            greenInstanz1.setBackground(Color.green);
            yellowInstanz1.setBackground(Color.black);
        }
    }

    private void statusAenderungInstanz2(StatusEnum status) {
        if (status.equals(StatusEnum.OFFLINE)) {
            buttonSetStatusInstanz2.setText("online");
            buttonSetStatusInstanz2.setEnabled(true);
            redInstanz2.setBackground(Color.black);
            greenInstanz2.setBackground(Color.black);
            yellowInstanz2.setBackground(Color.yellow);

        } else if (status.equals(StatusEnum.ONLINE)) {
            buttonSetStatusInstanz2.setText("offline");
            buttonSetStatusInstanz2.setEnabled(true);
            redInstanz2.setBackground(Color.black);
            greenInstanz2.setBackground(Color.green);
            yellowInstanz2.setBackground(Color.black);

        } else if (status.equals(StatusEnum.DEAD)) {
            buttonSetStatusInstanz2.setText("online");
            buttonSetStatusInstanz2.setEnabled(false);
            redInstanz2.setBackground(Color.black);
            greenInstanz2.setBackground(Color.black);
            yellowInstanz2.setBackground(Color.yellow);
        }

    }

    private void buttonSetStatusInstanz1MouseClicked(MouseEvent evt) {
        if (buttonSetStatusInstanz1.getText().equals("online")) {
            monitorManager.setInstanceStatus(StatusEnum.ONLINE, 1);
            buttonSetStatusInstanz1.setText("offline");

        } else if (buttonSetStatusInstanz1.getText().equals("offline")) {
            monitorManager.setInstanceStatus(StatusEnum.OFFLINE, 1);
            buttonSetStatusInstanz1.setText("online");
        }
    }

    private void buttonSetStatusInstanz2MouseClicked(MouseEvent evt) {
        if (buttonSetStatusInstanz2.getText().equals("online")) {
            monitorManager.setInstanceStatus(StatusEnum.ONLINE, 2);
            buttonSetStatusInstanz2.setText("offline");

        } else if (buttonSetStatusInstanz2.getText().equals("offline")) {
            monitorManager.setInstanceStatus(StatusEnum.OFFLINE, 2);
            buttonSetStatusInstanz2.setText("online");
        }
    }


}
