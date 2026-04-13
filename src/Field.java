public abstract class Field {
	private String label;
	private int ID;
	private int cost;
	private int income;
	private String option;

	public Field(int ID, String label, int cost, int income) {

	}

	@Override
	public String toString() {
		return ID + ", " + label;
	}

	public String onLand(Player p) {
		return p + " er landet på felt " + this.ID + ", " + this.label;
	}
}
