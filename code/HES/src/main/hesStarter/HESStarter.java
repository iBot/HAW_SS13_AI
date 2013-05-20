package main.hesStarter;

import main.allgemeineTypen.transportTypen.KundenTyp;
import main.allgemeineTypen.transportTypen.ProduktTyp;
import main.komponenten.buchhaltung.BuchhaltungFassade;
import main.komponenten.kunden.IKundenManager;
import main.komponenten.kunden.KundenFassade;
import main.komponenten.lager.LagerFassade;
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
public class HESStarter {

    private static IKundenManager kundenManager;
    private static VerkaufFassade verkauf;
    private static LagerFassade lager;
    private static IVersandManager versand;
    private static BuchhaltungFassade buchhaltung;
    private static KundenTyp derKunde;
    private static List<ProduktTyp> produktListe;
    private static boolean bezahlt;

    public static void main(String[] args)  {
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
//        buchhaltung = new BuchhaltungFassade();
//        lager = new LagerFassade();
//        versand = new VersandFassade();
//        verkauf = new VerkaufFassade(buchhaltung, lager, versand);
//        produktListe = new ArrayList<>();
//        produktListe.add(lager.erstelleProdukt("Batmobil"));
//        produktListe.add(lager.erstelleProdukt("BatutilityBag"));
//        buchhaltung = new BuchhaltungFassade();

    }

    private static void tesstMethodeForDistributedDatabaseAccess() {

    }
}
