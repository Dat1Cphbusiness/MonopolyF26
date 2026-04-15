
public class Tax extends Field implements IOption{
    public Tax(int ID, String label, int cost){
        super(ID, label, cost, 0);
    }

    @Override
    public String onReject(Player p) {
        double taxProcent = 0.10;
        double taxOfBalance = p.getBalance() * taxProcent;
        Bank.withdraw(Player p) - taxOfBalance;
        return "10% er blevet trukket af" + p.getBalance();
    }

    @Override
    public String onAccept(Player p) {
        return "";
    }

    //Onlandmetode
    @Override
    public String onLand (Player p){
        String s = super.onLand(p);
        s += "\n Du skal betale et beløb der svarer til 10% af dine aktiver. Vil du hellere betale et fast beløb på " + this.cost + "kr? Y/N \n";
        return s;
    }





}
