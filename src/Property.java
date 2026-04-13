public abstract class Property extends Field {

    Player owner;
    int seriesID;
    boolean isMonopolized;


    public Property(int ID, String label, int cost, int income, int seriesID) {

        super(label,ID, cost, income);
        this.seriesID = seriesID;

    }

    @Override
    public String toString() {
        return super.toString() + " SeriesID: " + seriesID;

    }
    @Override
    public String onLand(Player p){

    return null;
    }

}
