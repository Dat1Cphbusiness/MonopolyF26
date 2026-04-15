public class Tax extends Field implements IOption{

    public Tax(int ID, String label, int cost){
        super(ID, label, cost, 0);
    }

    @Override
    public String onReject(Player p) {
        //Kan også sige (p.getTotalWorth*0.1) for at få 10%
        int amount = (p.getTotalWorth/10);
        Bank.withdraw(amount, p);
        return amount + " kr er blevet betalt til skat";
    }

    @Override
    public String onAccept(Player p) {
        Bank.withdraw(this.cost, p);

        return "4000 kr. er blevet betalt til skat";
    }


    @Override
    public String onLand(Player p){
        String s = super.onLand(p) + " \n Du skal betale et beløb der svarer til 10% af dine aktiver. Vil du hellere betale et fast beløb på: " + this.cost + "kr? Y/N \n";
        return s;
    }
}
