public class Prison extends Field implements IOption{
    public Prison(int id, String label, int income, int cost) {
        super(0,  label, 0,0);
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
