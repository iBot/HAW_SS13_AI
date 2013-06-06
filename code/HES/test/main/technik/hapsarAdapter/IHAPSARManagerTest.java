package main.technik.hapsarAdapter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 05.06.13
 * Time: 15:33
 * To change this template use File | Settings | File Templates.
 */
public class IHAPSARManagerTest {

    IHAPSARManager mqManager;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        mqManager.stop();
    }

    @Test
    public void testComplete() throws Exception {
        mqManager = new HAPSARManager();
        System.out.println("HAPSARManager erstellt");


        System.out.println("Testen des MessageQueue Receivers");
        mqManager.subscribeForMessages(new INewMessageListener() {
            @Override
            public void getNextMessage() {
                IZahlungseingangMessage message = mqManager.getNextMessage();
                if (message!=null){
                    System.out.println("Read message"+message);
                } else {
                    System.out.println("Message wurde bereits abgeholt.");
                }

            }
        });
        System.out.println("HAPSARManager gestartet.");
        mqManager.start();

        while (true){}
    }
}