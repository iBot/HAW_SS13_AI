package rest;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 07.06.13
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */
public class DHLStarter {


    static final String BASE_URI = "http://localhost:9990/dhl/";

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServerFactory.create(BASE_URI);
            server.start();
            System.out.println("DHL Server started. Press Enter to stop the server. ");
            System.in.read();
            server.stop(0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
