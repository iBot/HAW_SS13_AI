package hapsar;

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
public class Starter {
    public static void main(String[] args){
        try {
            MQQueueSender sender = new MQQueueSender();
            Scanner sc = new Scanner(System.in);
            int eingabe = sc.nextInt();

            System.out.println("Bitte wählen sie eine der folgenden Funktionen aus: ");
            if (eingabe == 1) {

            } else if (eingabe ==2 ){

            }


            sender.sendMessage("Dies ist eine Nachricht. Zeitpunkt: "+new Date().toString());
            sender.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
