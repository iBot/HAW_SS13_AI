package komponenten;

import komponenten.AktiveRedundanz.dispatcher.DispatcherFassade;
import komponenten.AktiveRedundanz.dispatcher.IDispatcherManager;
import komponenten.AktiveRedundanz.monitor.MonitorFassade;
import komponenten.RMIClientAdapter.IRMIClientAdapterManager;
import komponenten.RMIClientAdapter.RMIClientAdapterFassade;
import komponenten.RMIClientAdapter.RMIClientAdapterLogik;
import main.allgemeineTypen.transportTypen.*;

import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 20.05.13
 * Time: 20:27
 * To change this template use File | Settings | File Templates.
 */
public class HESClient {
    private IRMIClientAdapterManager clientAdapterManager;
    private IDispatcherManager dispatcherManager;
    private List<ProduktTyp> produktListe;
    private int i;


    public HESClient(IDispatcherManager dispatcherManager) {
        dispatcherManager = dispatcherManager;

        clientAdapterManager = new RMIClientAdapterFassade(dispatcherManager);


        i = 0;
    }


    public void szenario1() {


            KundenTyp kunde = new KundenTyp("Kunde" + i, "Hamburg");
            kunde = clientAdapterManager.erstelleKunde(kunde);
            i++;

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

    public void szenario2() {
        produktListe = new ArrayList<>();
        produktListe.add(clientAdapterManager.erstelleProdukt("Batmobil"));
        produktListe.add(clientAdapterManager.erstelleProdukt("BatutilityBag"));
         KundenTyp derKunde = clientAdapterManager.erstelleKunde(new KundenTyp("Batman", "Gotham City"));
        Map<String, Integer> produkte = new HashMap<>();
        for (ProduktTyp produkt : produktListe) {
            produkte.put(produkt.getProduktNr(), 10);
        }
        AngebotTyp angebot = clientAdapterManager.erstelleAngebot(derKunde.getKundenNr(), new Date(new Date().getTime() + 24l * 60 * 60 * 1000 * 7), new Date(), produkte);
        AuftragTyp auftragTyp = clientAdapterManager.erstelleAuftrag(angebot, new Date());


    }


}
