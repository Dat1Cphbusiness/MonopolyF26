public abstract class Property extends Field{
	private Player owner;
	private int serieID;
	private boolean isMonopolized;

	public Property (int ID, String label, int cost, int income, int seriesID) {
		super(ID, label, cost, income);
		this.serieID = seriesID;
	}
}
