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


    @Override
    public String onLand(Player p){
        String s = super.onLand(p) + " \n Du skal betale et beløb der svarer til 10% af dine aktiver. Vil du hellere betale et fast beløb på: " + this.cost + "kr Y/N \n";
        return s;
    }
}
