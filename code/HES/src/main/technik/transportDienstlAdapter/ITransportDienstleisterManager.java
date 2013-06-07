package main.technik.transportDienstlAdapter;


import main.allgemeineTypen.transportTypen.KundenTyp;
import main.allgemeineTypen.transportTypen.TransportauftragTyp;

public interface ITransportDienstleisterManager {

    void sendeTransportauftrag(TransportauftragTyp transportauftrag, KundenTyp kunde);

    void stopServer();

    void abboniereTransportauftragsBestaetigungen(ITransportAuftragListener listener);
}
