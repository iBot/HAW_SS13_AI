package rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/order")
public class Logic {

    static final String HES_REST_URI = "http://localhost:9991/order";
    static final String HES_ORDERACK_PATH = "order/ack";

    @GET
    @Path("/newOrder/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public void newOrder(@PathParam("a") double a, @PathParam("b") double b) {
        final String transportauftragsNummer = null;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

                ClientConfig config = new DefaultClientConfig();
                Client client = Client.create(config);
                WebResource service = client.resource(HES_REST_URI);
                WebResource orderAckService = service.path(HES_ORDERACK_PATH).path(transportauftragsNummer + "/" + System.currentTimeMillis());
            }
        };
        new Thread(runnable).start();
    }

}
