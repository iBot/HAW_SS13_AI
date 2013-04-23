package main.komponenten.versand;

import main.technik.persistenzManager.PersistenzManager;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 13:55
 */
class TransportauftragRepository {

    private PersistenzManager persistenzManager = PersistenzManager.getInstance();

    public Transportauftrag erstelleTransportauftrag() {
        Transportauftrag transportauftrag = new Transportauftrag();
        persistenzManager.create(transportauftrag);
        return transportauftrag;
    }
}
