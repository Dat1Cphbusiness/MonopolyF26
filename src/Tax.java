public class Tax extends Field implements IOption{
    public Tax(int ID, String label, int cost){
        super(ID, label, cost, 0);
    }

    @Override
    public String onReject(Player p) {
        return "";
    }

    @Override
    public String onAccept(Player p) {
        return "";
    }
}
