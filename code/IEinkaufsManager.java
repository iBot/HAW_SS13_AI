public interface IEinkaufsManager {

	public BestellungsTyp bestelleProdukt(ProduktTyp aProdukt);

	public void bestaetigeWareneingang(BestellungsTyp aBestellung, WareneingangsmeldungsTyp aWareneingangsmeldung);
}