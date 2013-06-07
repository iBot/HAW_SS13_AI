package main.technik.transportDienstlAdapter;


import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import main.allgemeineTypen.transportTypen.KundenTyp;
import main.allgemeineTypen.transportTypen.TransportauftragTyp;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.core.MediaType;

public class Client {
    static final String REST_URI = "http://localhost:9990/dhl/";
    static final String PLACE_PATH = "order/place";
    ClientConfig config;
    WebResource service;
    WebResource subService;
    com.sun.jersey.api.client.Client client;


    public Client() {
        this.config = new DefaultClientConfig();
        this.client = com.sun.jersey.api.client.Client.create(config);
        this.service = client.resource(REST_URI);
        this.subService = service.path(PLACE_PATH);
    }

    public void sendeTransportauftrag(TransportauftragTyp transportauftrag, KundenTyp kunde) {
        subService.type(MediaType.APPLICATION_JSON).post(transportTypenZuJSON(transportauftrag,kunde));
    }

    private JSONObject transportTypenZuJSON(TransportauftragTyp transportauftrag, KundenTyp kunde) {
        JSONObject json = new JSONObject();

        try {
            json.put("transportauftragsNummer", transportauftrag.getTransportauftragNr());
            json.put("name", kunde.getName());
            json.put("adresse", kunde.getAdresse());
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return json;
    }
}
