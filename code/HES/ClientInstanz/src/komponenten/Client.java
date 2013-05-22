package komponenten;

import komponenten.AktiveRedundanz.dispatcher.DispatcherFassade;
import komponenten.AktiveRedundanz.dispatcher.IDispatcherManager;
import komponenten.RMIClientAdapter.IRMIClientAdapterManager;
import komponenten.RMIClientAdapter.RMIClientAdapterFassade;
import komponenten.RMIClientAdapter.RMIClientAdapterLogik;
import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.allgemeineTypen.transportTypen.KundenTyp;
import main.allgemeineTypen.transportTypen.ProduktTyp;

import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 20.05.13
 * Time: 20:27
 * To change this template use File | Settings | File Templates.
 */
public class Client
{
        private IRMIClientAdapterManager clientAdapterManager;
    private RMIClientAdapterLogik logik;
    private IDispatcherManager dispatcherManager;
    private List<ProduktTyp> produktListe;


        public Client() {
            dispatcherManager = new DispatcherFassade();
            try{
            logik = new RMIClientAdapterLogik(dispatcherManager);
            }
            catch(Exception e){
            }
            clientAdapterManager = new RMIClientAdapterFassade(logik);

            produktListe = new ArrayList<>();
            produktListe.add(clientAdapterManager.erstelleProdukt("Batmobil"));
            produktListe.add(clientAdapterManager.erstelleProdukt("BatutilityBag"));
    }


        public void szenario() {

            KundenTyp kunde = new KundenTyp("Kunde1", "Hamburg");
            kunde = clientAdapterManager.erstelleKunde(kunde);

            Map<String, Integer> produkte = new HashMap<>();
            for (ProduktTyp produkt : produktListe) {
                produkte.put(produkt.getProduktNr(), 10);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            AngebotTyp angebot = clientAdapterManager.erstelleAngebot(kunde.getKundenNr(), new Date(new Date().getTime() + 24l * 60 * 60 * 1000 * 7), new Date(), produkte);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }

            clientAdapterManager.erstelleAuftrag(angebot, new Date());



    }


}
