package main.technik.TransportDienstLeisterAdapter;

import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import main.allgemeineTypen.transportTypen.TransportauftragTyp;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 05.06.13
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
public class TransportDienstLeisterAdapterLogik {

    static final String URI = "http://localhost:9999/calcrest/";

    public TransportDienstLeisterAdapterLogik{
    }
    public static void sendeAuftrag(TransportauftragTyp transportauftrag) {

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(URI);
        WebResource addService = service.path(;
    }

}
