public abstract class Property extends Field implements IOption{
	private Player owner;
	private int serieID;
	private boolean isMonopolized;

	public Property (int ID, String label, int cost, int income, int seriesID) {
		super(ID, label, cost, income);
		this.serieID = seriesID;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + serieID;
	}

	@Override
	public String onLand(Player p) {
		String msg = super.onLand(p);
		if (owner == null) {
			setOption("buy");
			msg+= "\n Vil du købe? (Y/N):";
		} else {

		}
		return msg;
		// If no one ownes the propety, player can buy
		// else if owner is not currentplayer pay rent

	}

	@Override
	public String onAccept(Player p) {
		return "";
	}

	@Override
	public String onReject(Player p) {
		return "";
	}
}
