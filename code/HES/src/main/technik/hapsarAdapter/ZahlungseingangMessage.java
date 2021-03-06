package main.technik.hapsarAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 05.06.13
 * Time: 15:14
 * To change this template use File | Settings | File Templates.
 */
public class ZahlungseingangMessage implements IZahlungseingangMessage {

    private final String rechnungsnummer;
    private final double betrag;

    ZahlungseingangMessage(String message) {
        String[] messageParts = message.split(";;");
        rechnungsnummer = messageParts[0];
        betrag = Double.parseDouble(messageParts[1]);
    }

    @Override
    public String getRechnungsNummer() {
        return rechnungsnummer;
    }

    @Override
    public double getBetrag() {
        return betrag;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ZahlungseingangMessage{");
        sb.append("rechnungsnummer='").append(rechnungsnummer).append('\'');
        sb.append(", betrag=").append(betrag);
        sb.append('}');
        return sb.toString();
    }
}
