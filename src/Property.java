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
		//Mangler logik til at tjekke monopol.
//
//		for (Field field : board.getFields()) {
//			if (this.serieID == field.serieID && this.owner != field.getOwner) {
//				return false;
//			}
//		}
//		return true;


		isMonopolized = false;
		return isMonopolized;
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
		if (getOption().equals("buy")) {
			p.buyProperty(this);
			owner = p;
			checkForMonopoly();
			return p + " har nu købt " + this;
		}
		return p + " havde ikke råd til at købe " + this;
	}

	@Override
	public String onReject(Player p) {
		return p.getName() + " afviste at købe " + this;
	}
}
