package main.komponenten.versand;

import junit.framework.Assert;
import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.KundenTyp;
import main.allgemeineTypen.transportTypen.LieferungTyp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 14:30
 */
public class IVersandManagerTest {
    VersandFassade versandManager;
    @Before
    public void setUp() throws Exception {
           versandManager = new VersandFassade(0);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testErstelleLieferung() throws Exception {
        LieferungTyp lieferung = versandManager.erstelleLieferung(new AuftragTyp("ANG-1", false, new Date()), new KundenTyp("Otto","Irgendwo"));
                LieferungTyp restoredLieferung = versandManager.getLieferungZuID(lieferung.getLieferungNr());
        Assert.assertNotNull("Lieferung wurde erstellt", restoredLieferung);

    }

    @Test
    public void testHoleAlleLieferungenZuAuftrag() throws Exception {
       AuftragTyp auftragTyp =  new AuftragTyp("AUF-1","ANG-XY", false, new Date());
        System.out.print(">>>>>>>>>>>>"+auftragTyp.getAuftragsNr());
        LieferungTyp lieferung1 = versandManager.erstelleLieferung(auftragTyp, new KundenTyp("Manfred","Kleine Straße 123"));
        LieferungTyp lieferung2 = versandManager.erstelleLieferung(auftragTyp, new KundenTyp("Manfred","Kleine Straße 123"));
        List<LieferungTyp> lieferungen = versandManager.holeAlleLieferungenZuAuftrag(auftragTyp);
        System.out.print(">>>>>>>>>>>>"+lieferungen);
        assertTrue(lieferungen.size()==2);
    }
}
