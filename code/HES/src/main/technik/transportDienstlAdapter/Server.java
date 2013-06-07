package main.technik.transportDienstlAdapter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/order")
public class Server {

    private List<ITransportAuftragListener> listenerMap;

    public Server(){
        listenerMap = new ArrayList<>();

    }

    @GET
    @Path("/ack/{transportauftragsNummer}/{dateInMillis}")
    @Produces(MediaType.TEXT_PLAIN)
    public String ack(@PathParam("transportauftragsNummer") String transportauftragsNummer, @PathParam("dateInMillis") long dateInMillis) {
        for (ITransportAuftragListener listener :listenerMap){
            listener.bestaetigeTransportauftrag(transportauftragsNummer, new Date(dateInMillis));
        }
        return "ok";
    }

    void subScribeForTransferOrderAck(ITransportAuftragListener listener){
        if (!listenerMap.contains(listener)){
            listenerMap.add(listener);
        }
    }



}
