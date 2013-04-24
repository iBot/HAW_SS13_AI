package main.komponenten.buchhaltung;

import junit.framework.TestCase;
import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.RechnungTyp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 14:27
 */
public class IBuchhaltungEventTest extends TestCase {
    private boolean bezahlt;

    @Before
    public void setUp() throws Exception {
        bezahlt = false;
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSchreibeFuerRechnungBezahltEventEin() throws Exception {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        BuchhaltungFassade bf = new BuchhaltungFassade();
        RechnungTyp rt = bf.erstelleRechnung(100,new AuftragTyp("Auf-1","Ang1!",false, new Date()));
        bf.schreibeFuerRechnungBezahltEventEin(rt.getRechnungsNr(), new IBuchhaltungListener() {
            @Override
            public void fuehreAktionAus() {
                bezahlt = true;
            }
        });

        bf.zahlungseingangBuchen(50.0, rt.getRechnungsNr());

        assertFalse(bezahlt);

        bf.zahlungseingangBuchen(60.0, rt.getRechnungsNr());

        assertTrue(bezahlt);
    }
}
