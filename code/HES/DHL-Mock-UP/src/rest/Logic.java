package rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/order")
public class Logic {

    static final String HES_REST_URI = "http://localhost:9991/order";
    static final String HES_ORDERACK_PATH = "order/ack";

    @POST
    @Path("/place")
    @Consumes(MediaType.APPLICATION_JSON)
    public void newOrder(JSONObject order) {
        String transportauftragsNummer = null;
        String name = null;
        String adresse = null;
        try {
            transportauftragsNummer = order.getString("transportauftragsNummer");
            name = order.getString("name");
            adresse = order.getString("adresse");
            System.out.printf("Transportauftrag erhalten für: %s %s %s%n", name, adresse, transportauftragsNummer);
        } catch (JSONException e) {

        }
        final String transportauftragsNummerX = transportauftragsNummer;
        final String nameX = name;
        final String adresseX = adresse;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                System.out.printf("Transport erledigt für: %s %s %s%n", nameX, adresseX, transportauftragsNummerX);
                ClientConfig config = new DefaultClientConfig();
                Client client = Client.create(config);
                WebResource service = client.resource(HES_REST_URI);
                WebResource orderAckService = service.path(HES_ORDERACK_PATH).path(transportauftragsNummerX + "/" + System.currentTimeMillis());
            }
        };
        new Thread(runnable).start();
    }

}
