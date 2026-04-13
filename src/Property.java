public class Property extends Field{

    private Player owner;
    private int seriesID;
    private Boolean isMonopolized;

    public Property(int id, String label, int cost, int income, int seriesID){
        super(id, label, cost, income);
        this.seriesID = seriesID;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + seriesID;
    }

    @Override
    public String onLand(Player player) {
        return super.onLand(player);
    }
}
