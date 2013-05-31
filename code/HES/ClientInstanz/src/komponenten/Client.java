package komponenten;

import komponenten.AktiveRedundanz.dispatcher.DispatcherFassade;
import komponenten.AktiveRedundanz.dispatcher.IDispatcherManager;
import komponenten.AktiveRedundanz.monitor.MonitorFassade;
import komponenten.RMIClientAdapter.IRMIClientAdapterManager;
import komponenten.RMIClientAdapter.RMIClientAdapterFassade;
import komponenten.RMIClientAdapter.RMIClientAdapterLogik;
import main.allgemeineTypen.transportTypen.KundenTyp;
import main.allgemeineTypen.transportTypen.ProduktTyp;

import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 20.05.13
 * Time: 20:27
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    private IRMIClientAdapterManager clientAdapterManager;
    private IDispatcherManager dispatcherManager;
    private List<ProduktTyp> produktListe;
    private int i;


    public Client() {
        dispatcherManager = new DispatcherFassade(new MonitorFassade(2000));

        clientAdapterManager = new RMIClientAdapterFassade(dispatcherManager);

//        produktListe = new ArrayList<>();
//        produktListe.add(clientAdapterManager.erstelleProdukt("Batmobil"));
//        produktListe.add(clientAdapterManager.erstelleProdukt("BatutilityBag"));
        i = 0;
    }


    public void szenario() {

        while (true) {
            KundenTyp kunde = new KundenTyp("Kunde" + i, "Hamburg");
            kunde = clientAdapterManager.erstelleKunde(kunde);
            i++;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                break;
            }
        }
//            Map<String, Integer> produkte = new HashMap<>();
//            for (ProduktTyp produkt : produktListe) {
//                produkte.put(produkt.getProduktNr(), 10);
//            }
//
//            Thread.sleep(1000);
//
//            AngebotTyp angebot = clientAdapterManager.erstelleAngebot(kunde.getKundenNr(), new Date(new Date().getTime() + 24l * 60 * 60 * 1000 * 7), new Date(), produkte);
//
//            Thread.sleep(1000);
//
//            clientAdapterManager.erstelleAuftrag(angebot, new Date());

    }


}
