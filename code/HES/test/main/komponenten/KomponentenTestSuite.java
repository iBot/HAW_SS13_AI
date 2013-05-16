package main.komponenten;

import main.komponenten.buchhaltung.IBuchhaltungManagerTest;
import main.komponenten.einkauf.IEinkaufManagerTest;
import main.komponenten.kunden.IKundenManagerTest;
import main.komponenten.lager.ILagerEventTest;
import main.komponenten.lager.ILagerManagerTest;
import main.komponenten.verkauf.IVerkaufManagerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 14:31
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        IBuchhaltungManagerTest.class,
        IEinkaufManagerTest.class,
        IKundenManagerTest.class,
        ILagerEventTest.class,
        ILagerManagerTest.class,
        IVerkaufManagerTest.class,
        IVerkaufManagerTest.class
})
public class KomponentenTestSuite{

}
