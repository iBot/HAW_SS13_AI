package main.komponenten.buchhaltung;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.RechnungTyp;

import java.util.List;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 12:54
 */
public interface IBuchhaltungManager {
    public RechnungTyp erstelleRechnung();

    public void zahlungseingangBuchen(double betrag, String rechnungsNr);

    public List<RechnungTyp> getRechnungenZuKunde(String kundenNr);
}
