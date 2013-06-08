package main.technik.transportDienstlAdapter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Path("/order")
public class TDServer {

    private static TDServer instance;
    private static Set<ITransportAuftragListener> listenerSet = new HashSet<>();

    public TDServer() {


    }

    public static TDServer getInstance() {
        if (instance == null) {
            instance = new TDServer();
        }
        return instance;
    }

    @GET
    @Path("/ack/{transportauftragsNummer}/{dateInMillis}")
    @Produces(MediaType.TEXT_PLAIN)
    public String ack(@PathParam("transportauftragsNummer") String transportauftragsNummer, @PathParam("dateInMillis") long dateInMillis) {
        for (ITransportAuftragListener listener : listenerSet) {
            listener.bestaetigeTransportauftrag(transportauftragsNummer, new Date(dateInMillis));
        }
        if (listenerSet.isEmpty()) {
            System.out.println("Keine Subscriber vorhanden");
        } else {
            System.out.println(listenerSet.size() + " Subscriber vorhanden!");
        }

        System.err.println(">>>>Transportauftrag wurde bestätigt: " + transportauftragsNummer);
        return "ok";
    }

    void subScribeForTransferOrderAck(ITransportAuftragListener listener) {

        listenerSet.add(listener);
        System.out.println(listenerSet);

        System.out.println(listener + " subscribs for Transportauftragsbestätigung");
    }


}
