public class Field {
	private String label;
	private int ID;
	protected int cost;
	private int income;
	private String option;

	public Field(int ID, String label, int cost, int income) {
              this.ID = ID;
			  this.label = label;
			  this.cost = cost;
			  this.income = income;
	}

	@Override
	public String toString() {
		return ID + ", " + label;
	}

	public String onLand(Player p) {

		return p.getName() + " er landet på felt " + this.ID + ", " + this.label;
	}
	public int getCost(){
		return cost;
	}
}
