public class Field {

    String label;
    int ID;
    int cost;
    int income;
    String option;

    public Field( int ID,String label, int cost, int income) {
        this.label = label;
        this.ID = ID;
        this.cost = cost;
        this.income = income;
    }

    public String onLand(Player p) {
        return p.getName() + " er landet på felt " + ID + ", " + label;
    }

    @Override
    public String toString() {
        return "Field{" +
                "label='" + label + '\'' +
                ", ID=" + ID +
                ", cost=" + cost +
                ", income=" + income +
                ", option='" + option + '\'' +
                '}';
    }
}
