public abstract class Field {


    private String label;
    private int ID;
    protected int cost;
    protected int income;
    protected String option;

    Field(String label, int ID, int cost, int income) {

    this.label = label;
    this.ID = ID;
    this.cost = cost;
    this.income = income;
    }
    @Override
    public String toString() {

        return ID + " " + label;

    }


    public String onLand(Player p) {
        System.out.println(p.getName() +" er landet på " + this);



    }










}
