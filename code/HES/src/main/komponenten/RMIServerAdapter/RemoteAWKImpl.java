package main.komponenten.RMIServerAdapter;

import main.allgemeineTypen.transportTypen.*;
import main.komponenten.kunden.IKundenManager;
import main.komponenten.lager.ILagerManager;
import main.komponenten.lager.IReserviertListener;
import main.komponenten.verkauf.IVerkaufManager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 20.05.13
 * Time: 18:09
 * To change this template use File | Settings | File Templates.
 */
public class RemoteAWKImpl extends UnicastRemoteObject implements IRemoteAWK {


    IKundenManager kundenManager;
    IVerkaufManager verkaufManager;
    ILagerManager lagerManager;

    public RemoteAWKImpl(IKundenManager kundenManager, IVerkaufManager verkaufManager, ILagerManager lagerManager) throws RemoteException {
        this.kundenManager = kundenManager;
        this.verkaufManager = verkaufManager;
        this.lagerManager = lagerManager;
    }

    @Override
    public KundenTyp erstelleKunde(KundenTyp kunde) throws RemoteException {
        return kundenManager.erstelleKunde(kunde);
    }

    @Override
    public KundenTyp getKundeZuID(String kundenID) throws RemoteException {
        return kundenManager.getKundeZuID(kundenID);
    }

    @Override
    public ProduktTyp erstelleProdukt(String produktName) throws RemoteException {
        return lagerManager.erstelleProdukt(produktName);
    }

    @Override
    public void bucheWareneingang(LieferscheinTyp lieferschein, String bestellNr) throws RemoteException {
        lagerManager.bucheWareneingang(lieferschein,bestellNr);
    }

    @Override
    public void reserviereProdukteFuerAuftrag(AngebotTyp angebot, String reserviertListener) throws RemoteException {
        lagerManager.reserviereProdukteFuerAuftrag(angebot,reserviertListener);
    }

    @Override
    public ProduktTyp getProduktZuID(String produktNr) throws RemoteException {
        return lagerManager.getProduktZuID(produktNr);
    }

    @Override
    public WareneingangsmeldungTyp getWareneingangsmeldungZuID(String wareneingangsmeldungsNr) throws RemoteException {
        return lagerManager.getWareneingangsmeldungZuID(wareneingangsmeldungsNr);
    }

    @Override
    public AngebotTyp erstelleAngebot(String kundenNr, Date gueltigBis, Date gueltigAb, Map<String, Integer> produktListe) throws RemoteException {
        return verkaufManager.erstelleAngebot(kundenNr,gueltigBis,gueltigAb,produktListe);
    }

    @Override
    public AuftragTyp erstelleAuftrag(AngebotTyp angebot, Date beauftragtAm) throws RemoteException {
        return verkaufManager.erstelleAuftrag(angebot,beauftragtAm);
    }

    @Override
    public AuftragTyp getAuftragZuID(String auftragsNr) throws RemoteException {
        return verkaufManager.getAuftragZuID(auftragsNr);
    }

    @Override
    public AngebotTyp getAngebotZuID(String angebotNr) throws RemoteException {
        return verkaufManager.getAngebotZuID(angebotNr);
    }
}
