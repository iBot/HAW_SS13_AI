package main.komponenten.versand;

import junit.framework.Assert;
import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.LieferungTyp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 14:30
 */
public class IVersandManagerTest {
    VersandFassade versandManager;
    @Before
    public void setUp() throws Exception {
           versandManager = new VersandFassade();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testErstelleLieferung() throws Exception {
        LieferungTyp lieferung = versandManager.erstelleLieferung(new AuftragTyp("ANG-1", false, new Date()));
        LieferungTyp restoredLieferung = versandManager.getLieferungZuID(lieferung.getLieferungNr());
        Assert.assertNotNull("Lieferung wurde erstellt", restoredLieferung);

    }
}
