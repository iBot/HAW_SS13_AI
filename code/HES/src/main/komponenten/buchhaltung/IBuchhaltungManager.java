package main.komponenten.buchhaltung;

import main.allgemeineTypen.transportTypen.AuftragTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 12:54
 */
public interface IBuchhaltungManager {
    public void erstelleRechnung(AuftragTyp auftrag);

    public void zahlungseingangBuchen(double betrag, String kundenNr);
}
