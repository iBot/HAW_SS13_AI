package hapsar;

import com.rabbitmq.tools.json.JSONUtil;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 05.06.13
 * Time: 10:01
 * To change this template use File | Settings | File Templates.
 */
public class HAPSARStarter {

    static MQQueueSender sender;
    public static void main(String[] args) {
        try {
            sender = new MQQueueSender();
            Scanner sc = new Scanner(System.in);
            boolean exit = false;
            while (!exit) {

                System.out.println("Bitte wählen sie eine der folgenden Funktionen aus:");
                System.out.println("\t1) Zahlungseingang buchen");
                System.out.println("\t2) Beenden");
                int eingabe = sc.nextInt();
                if (eingabe == 1) {
                    System.out.println("Bitte Rechnungsnummer eingeben:");
                    String rechnungsnummer = sc.next();
                    System.out.println("Bitte Betrag eingeben:");
                    double betrag = sc.nextDouble();
                    String message = createMessage(rechnungsnummer, betrag);
                    sender.sendMessage(message);
                } else if (eingabe == 2) {
                    exit = true;
                } else {
                    System.out.println("Fehlerhafte Eingabe! Bitte wiederholen.");
                }
            }
            sender.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.

        }

    }

    private static String createMessage(String rechnungsnummer, double betrag) {
        return String.format("%s;;%s", rechnungsnummer, betrag);
    }
}
