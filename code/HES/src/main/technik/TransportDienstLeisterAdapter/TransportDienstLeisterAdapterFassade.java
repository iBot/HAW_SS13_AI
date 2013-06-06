package main.technik.TransportDienstLeisterAdapter;

import main.allgemeineTypen.transportTypen.TransportauftragTyp;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 05.06.13
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
public class TransportDienstLeisterAdapterFassade implements ITransportDienstLeisterAdapterManager{

    @Override
    public void sendeAuftrag(TransportauftragTyp transportauftrag) {
        TransportDienstLeisterAdapterLogik.sendeAuftrag(transportauftrag);
    }
}
