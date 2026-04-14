public class Tax extends Field implements IOption{
    public Tax(int id, String label, int income, int cost) {
        super(id,label,0,cost);
    }

    @Override
    public String onAccept(Player player) {
        return "";
    }

    @Override
    public String onReject(Player player) {
        return "";
    }
}
