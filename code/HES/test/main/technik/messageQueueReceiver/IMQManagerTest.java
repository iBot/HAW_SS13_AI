package main.technik.messageQueueReceiver;

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
public class IMQManagerTest {

    IMQManager mqManager;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        mqManager.stop();
    }

    @Test
    public void testComplete() throws Exception {
        mqManager = new MQManager();
        System.out.println("MQManager erstellt");


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
        System.out.println("MQManager gestartet.");
        mqManager.start();

        while (true){}
    }
}