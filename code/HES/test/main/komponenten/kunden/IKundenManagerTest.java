package main.komponenten.kunden;

import junit.framework.Assert;
import main.allgemeineTypen.transportTypen.KundenTyp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 14:52
 */
public class IKundenManagerTest {
    KundenFassade kundenManager;
    @Before
    public void setUp() throws Exception {
        kundenManager = new KundenFassade();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testErstelleKunde() throws Exception {
        KundenTyp kunde = kundenManager.erstelleKunde(new KundenTyp("Kunde1", "Hamburg1"));
        KundenTyp restoredKunde = kundenManager.getKundeZuID(kunde.getKundenNr());

        Assert.assertNotNull("Kunde wurde erstellt", restoredKunde);
    }

}
