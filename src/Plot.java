public class Plot extends Property {

	int buildings;

	public Plot(int ID, String label, int cost, int income, int seriesID) {
		super(ID, label, cost, income, seriesID);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public String onLand(Player p) {
		/*
		if owner == current player and isMonopolized
		then give option to build
		 */

		String msg = super.onLand(p);
		if(getOwner() == p && checkForMonopoly()) {
			setOption("build");
			msg += "\n Vil du bygge? (Y/N):";
		}
		return msg;
	}

	public String onAccept(Player p) {
		String msg = super.onAccept(p);
		if (getOption().equals("build")) {
			buildings++;
			Bank.withdraw(500, p);
			msg += " har købt hus";
		}

		return msg;
	}


}
