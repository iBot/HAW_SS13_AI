package main.technik.persistenzManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 23.04.13
 * Time: 18:48
 * To change this template use File | Settings | File Templates.
 */
public class IPersistenzManagerTest {

    RechnungDummy rd;
    IPersistenzManager pm;
    String rn;
    @Before
    public void setUp() throws Exception {
        rd = new RechnungDummy(400);
        pm = PersistenzManager.getInstance();
        rn = rd.getRechnungsNr();
    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void testCRUD() throws Exception {
        pm.create(rd);
        RechnungDummy restoredRD = pm.access(RechnungDummy.class,rn);
        assertEquals("Rechnungsnummer: ",rn,restoredRD.getRechnungsNr());
        restoredRD.setGesamtbetrag(200);
        pm.update(restoredRD);
        restoredRD = pm.access(RechnungDummy.class,rn);
        assertEquals("Gesamtbetrag: ",200.0,restoredRD.getGesamtbetrag(),0.1);
        pm.delete(restoredRD);
        restoredRD = pm.access(RechnungDummy.class,rn);
        assertNull("Deleted: ", restoredRD);
    }

}
