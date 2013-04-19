package main.komponenten.einkauf;

import main.allgemeineTypen.transportTypen.BestellungTyp;
import main.allgemeineTypen.transportTypen.ProduktTyp;
import main.allgemeineTypen.transportTypen.WareneingangsmeldungTyp;

/**
 * User: Tobi
 * Date: 19.04.13
 * Time: 12:57
 */
interface IEinkaufRepository {
    public BestellungTyp bestelleProdukt(ProduktTyp produkt);

    public void bestaetigeWareneingang(BestellungTyp bestellung, WareneingangsmeldungTyp wareneingangsmeldung);
}
