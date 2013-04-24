package main.komponenten.systemtests;

import junit.framework.Assert;
import main.allgemeineTypen.transportTypen.*;
import main.komponenten.buchhaltung.BuchhaltungFassade;
import main.komponenten.kunden.IKundenManager;
import main.komponenten.kunden.IKundenManagerTest;
import main.komponenten.kunden.KundenFassade;
import main.komponenten.lager.ILagerListener;
import main.komponenten.lager.LagerFassade;
import main.komponenten.verkauf.VerkaufFassade;
import main.komponenten.versand.IVersandManager;
import main.komponenten.versand.VersandFassade;
import main.technik.persistenzManager.PersistenzManager;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
        derKunde = kundenManager.erstelleKunde(new KundenTyp("Batman","Gotham City"));
        verkauf = new VerkaufFassade();
        lager = new LagerFassade();
        produktListe = new ArrayList<>();
        produktListe.add(lager.erstelleProdukt("Batmobil"));
        produktListe.add(lager.erstelleProdukt("BatutilityBag"));
        versand = new VersandFassade();
        buchhaltung = new BuchhaltungFassade();
    }

    @Test
    public void szenario() throws Exception {
        Map<String, Integer> produkte = new HashMap<>();
        for (ProduktTyp produkt : produktListe){
            produkte.put(produkt.getProduktNr(),10);
        }
        AngebotTyp angebot = verkauf.erstelleAngebot(derKunde.getKundenNr(), new Date(new Date().getTime() + 24l * 60 * 60 * 1000 * 7), new Date(), produkte);
        AuftragTyp auftragTyp = verkauf.erstelleAuftrag(angebot);
        wareVorhande = false;
        lager.schreibeFuerWarenReserviertEventEin(angebot, new ILagerListener() {
            @Override
            public void fuehreAktionAus() {
                wareVorhande = true;
            }
        });
        while (!wareVorhande){
            //warte bis event ausgelöst wurde
        }
        assertTrue("Ware vorhanden", wareVorhande);

        versand.erstelleLieferung(auftragTyp);
        List<LieferungTyp> lieferungen = versand.holeAlleLieferungenZuAuftrag(auftragTyp);
        System.out.print(lieferungen);
        for (LieferungTyp lieferung : lieferungen){
            System.out.println("Lieferung erfolgt? " + lieferung.getLieferungErfolgt());
            assertTrue("Lieferung erfolgt", lieferung.getLieferungErfolgt());
        }

        RechnungTyp rechnung = buchhaltung.erstelleRechnung(100, auftragTyp);
        RechnungTyp ausgeleseneRechnung = buchhaltung.getRechnungZuID(rechnung.getRechnungsNr());
        assertEquals("Rechnung gehört zu Auftrag: ", auftragTyp.getAuftragsNr(), ausgeleseneRechnung.getAuftragsNr());

        AuftragTyp abgeschlossenerAuftrag = verkauf.getAuftragZuID(auftragTyp.getAuftragsNr());
    }
}
