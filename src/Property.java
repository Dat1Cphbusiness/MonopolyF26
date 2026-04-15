import java.util.ArrayList;

public abstract class Property extends Field implements IOption{
	private Player owner;
	private int serieID;
	private boolean isMonopolized;

	public Property (int ID, String label, int cost, int income, int seriesID) {
		super(ID, label, cost, income);
		this.serieID = seriesID;
	}

	public Player getOwner() {
		return owner;
	}

	public boolean checkForMonopoly() {
		int seriesSize = 3;
		if (serieID == 0 || serieID == 1 || serieID == 9) seriesSize = 2;
		if (serieID == 3) seriesSize = 4;

		ArrayList<Property> deedsInSeries = new ArrayList<>();
		for (Property deed : owner.deeds) {
			if (deed.serieID == this.serieID) deedsInSeries.add(deed);
		}
		if (deedsInSeries.size() == seriesSize) {
			for (Property deed : deedsInSeries) deed.isMonopolized = true;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + serieID;
	}

	@Override
	public String onLand(Player p) {
		String msg = super.onLand(p); //"Du er landet på Valbylanggade"
		if (owner == null) {
			setOption("buy");
			msg+= "\n Vil du købe? (Y/N):";
		} else {
			if (owner != p){
				msg+= "\n Du skal betale " + getIncome() + " til " + owner.getName();
				Bank.transfer(getIncome(), p, owner);
			}
		}
		return msg;
		// If no one ownes the propety, player can buy
		// else if owner is not currentplayer pay rent

	}

	@Override
	public String onAccept(Player p) {

		return p+" har nu købt "+this;
	}

	@Override
	public String onReject(Player p) {
		return "";
	}
}
