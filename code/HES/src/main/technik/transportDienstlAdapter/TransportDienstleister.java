package main.technik.transportDienstlAdapter;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;
import main.allgemeineTypen.transportTypen.KundenTyp;
import main.allgemeineTypen.transportTypen.TransportauftragTyp;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 07.06.13
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */
public class TransportDienstleister  implements  ITransportDienstleisterManager{

    private String HES_BASE_URI;
    private TDClient restClient;
    private HttpServer server;
    private TDServer restServer;

    private static TransportDienstleister instance;

    public static TransportDienstleister getInstance(int portExtention){
        if (instance==null){
            instance = new TransportDienstleister(portExtention);
        }
        return instance;
    }

    public TransportDienstleister(int portExtention) {
        this.restClient = new TDClient();
        restServer = new TDServer();
        this.HES_BASE_URI = String.format("http://localhost:999%d/hes", portExtention);
        System.out.println(HES_BASE_URI);
        try {
            server = HttpServerFactory.create(HES_BASE_URI);
            server.start();
            System.out.println("HES Transportdiensleister-REST-Server started.");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendeTransportauftrag(TransportauftragTyp transportauftrag, KundenTyp kunde) {
        restClient.sendeTransportauftrag(transportauftrag, kunde);
    }

    @Override
    public void stopServer() {
        server.stop(0);
    }

    @Override
    public void abboniereTransportauftragsBestaetigungen(ITransportAuftragListener listener) {
        restServer.subScribeForTransferOrderAck(listener);
    }
}
