public class Prison extends Field implements IOption{

    public Prison(int ID, String label, int cost){
        super(ID, label, cost, 0);
    }

    @Override
    public String onAccept(Player p) {
        return "";
    }

    @Override
    public String onReject(Player p) {
        return "";
    }
}
