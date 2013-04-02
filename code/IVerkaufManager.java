public interface IVerkaufManager {

	public AngebotsTyp erstelleAngebot(String aKundenNr, Date aGueltigBis, Date aGueltigAb, Map<ProduktTyp, int> aProduktListe, KundenTyp aKunde);

	public AuftragTyp erstelleAuftrag(AngebotsTyp aAngebot);
}