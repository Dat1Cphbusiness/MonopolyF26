public class Field {
	private String label;
	private int ID;
	protected int cost;
	protected int income;
	private String option;

	public Field(int ID, String label, int cost, int income) {
              this.ID = ID;
			  this.label = label;
			  this.cost = cost;
			  this.income = income;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
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

	public int getIncome(){
		return income;
	}

	public String onAccept(Player p){
		return "";
	}
	public String onReject(Player p){
		return "";
	}
}
