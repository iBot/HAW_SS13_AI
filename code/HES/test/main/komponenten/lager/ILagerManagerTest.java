package main.komponenten.lager;

import main.allgemeineTypen.transportTypen.ProduktTyp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 14:29
 */
public class ILagerManagerTest {
    ILagerManager lagerManager;
    @Before
    public void setUp() throws Exception {
        lagerManager = new LagerFassade();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testBucheWareneingang() throws Exception {
         //noch nicht Teil dieser Aufgabe
    }

    @Test
    public void testReserviereProdukteFuerAuftrag() throws Exception {
        ProduktTyp tulpe = lagerManager.erstelleProdukt("Tulpe");
        ProduktTyp rose = lagerManager.erstelleProdukt("Rose");
        Map<String, Integer> produktListe = new HashMap<>();
        produktListe.put(tulpe.getProduktNr(), 100);
        produktListe.put(rose.getProduktNr(), 50);
        Date heute = new Date();
        //TODO:
//        AngebotTyp angebot = new AngebotTyp("KUN-1", heute, new Date(heute.getTime() + (24L*60*60*1000)), new HashMap<>(produktListe));
//        AuftragTyp auftrag = new AuftragTyp("ANG-1", false, heute);
//
//        lagerManager.reserviereProdukteFuerAuftrag(auftrag, angebot);
//
//        ProduktTyp changedTulpe = lagerManager.getProduktZuID(tulpe.getProduktNr());
//        ProduktTyp changedRose = lagerManager.getProduktZuID(rose.getProduktNr());
//
//        Assert.assertEquals(rose.getLagerbestand()-50, changedRose.getLagerbestand());
//        Assert.assertEquals(tulpe.getLagerbestand()-100, changedTulpe.getLagerbestand());
    }
}
