package main.komponenten;

import main.komponenten.buchhaltung.IBuchhaltungEventTest;
import main.komponenten.buchhaltung.IBuchhaltungRepositoryTest;
import main.komponenten.einkauf.IEinkaufRepositoryTest;
import main.komponenten.kunden.IKundenRepositoryTest;
import main.komponenten.lager.ILagerEventTest;
import main.komponenten.lager.ILagerRepositoryTest;
import main.komponenten.verkauf.IVerkaufRepository;
import main.komponenten.verkauf.IVerkaufRepositoryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 14:31
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        IBuchhaltungEventTest.class,
        IBuchhaltungRepositoryTest.class,
        IEinkaufRepositoryTest.class,
        IKundenRepositoryTest.class,
        ILagerEventTest.class,
        ILagerRepositoryTest.class,
        IVerkaufRepositoryTest.class,
        IVerkaufRepositoryTest.class
})
public class KomponentenTestSuite{

}
