package main.technik.messageQueueReceiver;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 05.06.13
 * Time: 14:29
 * To change this template use File | Settings | File Templates.
 */
public interface IZahlungseingangMessage {
    String getRechnungsNummer();

    double getBetrag();
}
