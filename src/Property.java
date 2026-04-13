public class Property extends Field {

    Player owner;
    int serieID;
    boolean isMonopolized;

    public Property(int ID, String label, int cost, int income, int serieID) {
        super(ID, label, cost, income);
        this.serieID = serieID;
    }

    @Override
    public String toString(){
        return super.toString() + serieID;
    }

    @Override
    public String onLand(Player p) {
        // Check if property is owned
        // If true: Give player option to buy
        // If false: Check if current player is owner
        // if true: return empty-ish string
        // if false: return pay rent
        return "THIS HAS NOT BEEN CODED YET";
    }
}
