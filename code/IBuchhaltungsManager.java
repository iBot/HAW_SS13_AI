public interface IBuchhaltungsManager {

	public void erstelleRechnung(AuftragsTyp aAuftrag);

	public void zahlungseingangBuchen(double aBetrag, String aKundenNr);
}