package main.komponenten.RMIServerAdapter;

import main.allgemeineTypen.transportTypen.*;
import main.komponenten.kunden.IKundenManager;
import main.komponenten.lager.ILagerManager;
import main.komponenten.lager.IReserviertListener;
import main.komponenten.verkauf.IVerkaufManager;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: TwiG
 * Date: 20.05.13
 * Time: 16:56
 * To change this template use File | Settings | File Templates.
 */
public interface IRemoteAWK extends Remote{
    public KundenTyp erstelleKunde(KundenTyp kunde) throws RemoteException;
    public KundenTyp getKundeZuID(String kundenID) throws RemoteException;

    public ProduktTyp erstelleProdukt(String produktName) throws RemoteException;

    public void bucheWareneingang(LieferscheinTyp lieferschein, String bestellNr) throws RemoteException;

    public void reserviereProdukteFuerAuftrag(AngebotTyp angebot, IReserviertListener reserviertListener) throws RemoteException;

    public ProduktTyp getProduktZuID(String produktNr) throws RemoteException;

    public WareneingangsmeldungTyp getWareneingangsmeldungZuID(String wareneingangsmeldungsNr) throws RemoteException;

    public AngebotTyp erstelleAngebot(String kundenNr, Date gueltigBis, Date gueltigAb, Map<String, Integer> produktListe) throws RemoteException;

    public AuftragTyp erstelleAuftrag(AngebotTyp angebot, Date beauftragtAm) throws RemoteException;

    public AuftragTyp getAuftragZuID(String auftragsNr) throws RemoteException;

    public AngebotTyp getAngebotZuID(String angebotNr) throws RemoteException;
}
