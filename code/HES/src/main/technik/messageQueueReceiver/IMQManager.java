package main.technik.messageQueueReceiver;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 05.06.13
 * Time: 14:26
 * To change this template use File | Settings | File Templates.
 */
public interface IMQManager {
    void start();

    void stop();

    IZahlungseingangMessage getNextMessage();

    void subscribeForMessages(INewMessageListener listener);
}
