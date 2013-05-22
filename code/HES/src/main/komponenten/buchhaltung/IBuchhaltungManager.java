package main.komponenten.buchhaltung;

import main.allgemeineTypen.transportTypen.AuftragTyp;
import main.allgemeineTypen.transportTypen.RechnungTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 12:54
 */
public interface IBuchhaltungManager {
    public RechnungTyp erstelleRechnung(double gesamtbetrag, AuftragTyp auftrag, String buchhaltungslistenerID);

    public void zahlungseingangBuchen(double betrag, String rechnungsNr);

    public RechnungTyp getRechnungZuAuftrag(String auftragsNr);

    public RechnungTyp getRechnungZuID(String rechnungsNr);
}
