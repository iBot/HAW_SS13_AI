package main.komponenten.verkauf;

import junit.framework.Assert;
import main.allgemeineTypen.transportTypen.AngebotTyp;
import main.technik.persistenzManager.IPersistenzManager;
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
public class IVerkaufManagerTest {

    IPersistenzManager persistenzManager;
    IVerkaufManager verkaufManager;
    @Before
    public void setUp() throws Exception {
        //TODO:
//        persistenzManager = PersistenzManager.getInstance();
//        BuchhaltungFassade buchhaltungFassade = new BuchhaltungFassade();
//        LagerFassade  lager = new LagerFassade();
//        verkaufManager = new VerkaufFassade(buchhaltungFassade,buchhaltungFassade,lager,lager);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testErstelleAngebot() throws Exception {
        Map<String, Integer> produkte = new HashMap<>();
        produkte.put("Eins",1);
        produkte.put("Zwei",2);
        AngebotTyp erstelltesAngebot = verkaufManager.erstelleAngebot("KUNDE-blabla",new Date(), new Date(), produkte);
        AngebotTyp gelesenesAngebot = verkaufManager.getAngebotZuID(erstelltesAngebot.getAngebotNr());
        Assert.assertEquals("Angebot identisch: ",erstelltesAngebot,gelesenesAngebot);
    }

    @Test
    public void testErstelleAuftrag() throws Exception {
        //TODO:
//        Map<String, Integer> produkte = new HashMap<>();
//        produkte.put("DREI",3);
//        produkte.put("VIER",4);
//        AngebotTyp angebot = new AngebotTyp("DER KUNDE",new Date(), new Date(),produkte);
//
//        AuftragTyp erstellterAuftrag = verkaufManager.erstelleAuftrag(angebot);
//
//        AuftragTyp gelesenerAuftrag = verkaufManager.getAuftragTypZuID(erstellterAuftrag.getAuftragsNr());
//        Assert.assertEquals("Auftrag identisch: ",erstellterAuftrag,gelesenerAuftrag);
    }
}
