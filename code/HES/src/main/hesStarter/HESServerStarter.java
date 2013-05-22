package main.hesStarter;

import main.allgemeineTypen.transportTypen.KundenTyp;
import main.allgemeineTypen.transportTypen.ProduktTyp;
import main.komponenten.RMIServerAdapter.RMIServerAdapterFassade;
import main.komponenten.buchhaltung.BuchhaltungFassade;
import main.komponenten.kunden.IKundenManager;
import main.komponenten.kunden.KundenFassade;
import main.komponenten.lager.LagerFassade;
import main.komponenten.verbindung.VerbindungsFassade;
import main.komponenten.verkauf.VerkaufFassade;
import main.komponenten.versand.IVersandManager;
import main.komponenten.versand.VersandFassade;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 12:14
 */
public class HESServerStarter {

    private static IKundenManager kundenManager;
    private static VerkaufFassade verkauf;
    private static LagerFassade lager;
    private static IVersandManager versand;
    private static BuchhaltungFassade buchhaltung;
    private static RMIServerAdapterFassade rmiServerAdapterFassade;
    private static VerbindungsFassade verbindungsFassade;

    private static KundenTyp derKunde;
    private static List<ProduktTyp> produktListe;
    private static boolean bezahlt;
    private static int serverInstanceID = -100;

    public static void main(String[] args)  {
        startServer(args);
    }

    private static void startServer(String[] args){
        if (args.length != 1){
            throw new Error("Missing argument for server instance ID. Add 1 or 2 as argument.");
        }
        try {
            serverInstanceID = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new Error("Wrong Format for server instance ID argument. Add 1 or 2 as argument.",e);
        }
        if ((serverInstanceID != 1)&&(serverInstanceID != 2)){
            throw new Error("Unvalid serverInstanceId argument. Valid values are 1 and 2");
        }

        buchhaltung = new BuchhaltungFassade();
        kundenManager = new KundenFassade();
        lager = new LagerFassade();

        versand = new VersandFassade();
        verkauf = new VerkaufFassade(buchhaltung, lager, versand);

        rmiServerAdapterFassade = new RMIServerAdapterFassade(kundenManager,lager,verkauf,serverInstanceID);
        verbindungsFassade = new VerbindungsFassade(serverInstanceID,400);
    }

    private static void tesstMethodeForDistributedDatabaseAccess() {
        //TODO: Implement method body!
//        BuchhaltungFassade bf = new BuchhaltungFassade();
//        RechnungTyp rt = bf.erstelleRechnung(100, );
//        bf.schreibeFuerRechnungBezahltEventEin(rt.getRechnungsNr(), new IBuchhaltungListener() {
//            @Override
//            public void fuehreAktionAus() {
//                bezahlt = true;
//            }
//        });
//
//        bf.zahlungseingangBuchen(50.0, rt.getRechnungsNr());
//
//        System.out.print(bezahlt);
//
//        bf.zahlungseingangBuchen(60.0, rt.getRechnungsNr());
//
//        System.out.print(bezahlt);


        kundenManager = new KundenFassade();
        String computername = null;
        try{
            computername= InetAddress.getLocalHost().getHostName();
            System.out.println(computername);
        }catch (Exception e){
            System.out.println("Exception caught ="+e.getMessage());
        }


        for (int i = 0; i!=-1; i++){
            kundenManager.erstelleKunde(new KundenTyp(String.format("%s_%5d", computername, i), String.format("%s-City", computername)));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread woke up...");
            }
        }

    }
}
