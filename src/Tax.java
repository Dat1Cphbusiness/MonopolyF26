public class Tax extends Field implements IOption {

    private int ID;
    private String label;
    private int cost;

    public Tax(int ID, String label, int cost){
        this.ID = ID;
        this.label = label;
        this.cost = cost;
    }
    @Override
    public String onAccept(Player p){
        return "test";
    }
    @Override
    public String onReject(Player p){
        return "test";
    }
}
