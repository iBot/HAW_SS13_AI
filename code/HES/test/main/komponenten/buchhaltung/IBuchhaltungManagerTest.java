package main.komponenten.buchhaltung;

import junit.framework.TestCase;
import main.allgemeineTypen.transportTypen.RechnungTyp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 14:26
 */
public class IBuchhaltungManagerTest extends TestCase {

    IBuchhaltungManager buchhaltung;
    @Before
    public void setUp() throws Exception {
        buchhaltung = new BuchhaltungFassade();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testErstelleRechnung() throws Exception {
        RechnungTyp rechnungTyp = buchhaltung.erstelleRechnung(50);
        RechnungTyp restoredRechnungTyp = buchhaltung.getRechnungZuID(rechnungTyp.getRechnungsNr());
        assertNotNull("Rechnung wurde erstellt: ",restoredRechnungTyp);
    }

    @Test
    public void testZahlungseingangBuchen() throws Exception {
        RechnungTyp rechnungTyp = buchhaltung.erstelleRechnung(50);
        assertFalse("Rechnung Bezahlt: ", rechnungTyp.isIstBezahlt());
        buchhaltung.zahlungseingangBuchen(50, rechnungTyp.getRechnungsNr());
        RechnungTyp restoredRechnungTyp = buchhaltung.getRechnungZuID(rechnungTyp.getRechnungsNr());
        assertTrue("Rechnung Bezahlt: ", restoredRechnungTyp.isIstBezahlt());
    }
}
