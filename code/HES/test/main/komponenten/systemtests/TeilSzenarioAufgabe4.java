package main.komponenten.systemtests;

import main.allgemeineTypen.transportTypen.*;
import main.komponenten.buchhaltung.BuchhaltungFassade;
import main.komponenten.kunden.IKundenManager;
import main.komponenten.kunden.KundenFassade;
import main.komponenten.lager.LagerFassade;
import main.komponenten.verkauf.VerkaufFassade;
import main.komponenten.versand.IVersandManager;
import main.komponenten.versand.VersandFassade;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 24.04.13
 * Time: 09:51
 * To change this template use File | Settings | File Templates.
 */
public class TeilSzenarioAufgabe4 {
    private IKundenManager kundenManager;
    private VerkaufFassade verkauf;
    private LagerFassade lager;
    private IVersandManager versand;
    private BuchhaltungFassade buchhaltung;

    private KundenTyp derKunde;
    private List<ProduktTyp> produktListe;

    boolean wareVorhande;

    @Before
    public void setUp() throws Exception {
        kundenManager = new KundenFassade();
        derKunde = kundenManager.erstelleKunde(new KundenTyp("Batman", "Gotham City"));
        buchhaltung = new BuchhaltungFassade();
        lager = new LagerFassade();
        versand = new VersandFassade(1);
        verkauf = new VerkaufFassade(buchhaltung, lager, versand);
        produktListe = new ArrayList<>();
        produktListe.add(lager.erstelleProdukt("Batmobil"));
        produktListe.add(lager.erstelleProdukt("BatutilityBag"));
        buchhaltung = new BuchhaltungFassade();
    }

    @Test
    public void szenario() throws Exception {
        Map<String, Integer> produkte = new HashMap<>();
        for (ProduktTyp produkt : produktListe) {
            produkte.put(produkt.getProduktNr(), 10);
        }
        AngebotTyp angebot = verkauf.erstelleAngebot(derKunde.getKundenNr(), new Date(new Date().getTime() + 24l * 60 * 60 * 1000 * 7), new Date(), produkte);
        AuftragTyp auftragTyp = verkauf.erstelleAuftrag(angebot, new Date());
        List<LieferungTyp> lieferungen = versand.holeAlleLieferungenZuAuftrag(auftragTyp);
        System.out.print(lieferungen);
        for (LieferungTyp lieferung : lieferungen) {
            System.out.println("Lieferung erfolgt? " + lieferung.getLieferungErfolgt());
            assertTrue("Lieferung erfolgt", lieferung.getLieferungErfolgt());
        }
        RechnungTyp rechnungTyp = buchhaltung.getRechnungZuAuftrag(auftragTyp.getAuftragsNr());
        buchhaltung.zahlungseingangBuchen(rechnungTyp.getGesamtPreis(), rechnungTyp.getRechnungsNr());
        RechnungTyp bezahteRechnung = buchhaltung.getRechnungZuID(rechnungTyp.getRechnungsNr());
        //TODO: abfragen zu boolean mit "is" oder mit "get" für hibernate??
        assertTrue("Rechnung Bezahlt: ", bezahteRechnung.isIstBezahlt());

        AuftragTyp abgeschlossenerAuftrag = verkauf.getAuftragZuID(auftragTyp.getAuftragsNr());
        System.out.println("Auftrag abgeschlossen: "+abgeschlossenerAuftrag.getIstAbgeschlossen());
        assertTrue("Auftrag abgeschlossen: ", abgeschlossenerAuftrag.getIstAbgeschlossen());
    }



}

