public interface IFassade {

	public AngebotsTyp erstelleAngebot(Map<ProduktTyp, int> aProduktListe, Date aGueltigAb, Date aGueltigBis);

	public AuftragsTyp erstelleAuftragAusAngebot(String aAngebotsNr);

	public void zahlungseingangErstellen(double aBetrag, String aKundenNr);

	public void bucheWareneingang(LieferscheinTyp aLieferschein);
}