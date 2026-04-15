    public class Tax extends Field implements IOption{

        public Tax(int ID, String label, int cost){

            super(ID, label, cost, 0);
        }

        @Override
        public String onReject(Player p) {
            int total = (int) p.getTotalWorth()/100*10;

            Bank.withdraw(total, p);
            return "Du har afvist og skal betale et beløbet " + total + "kr.";
        }

        @Override
        public String onAccept(Player p) {
            Bank.withdraw(cost, p);
            return "Du har accepteret at betale et beløb på " + this.cost + "kr., beløbet er blevet trukket fra din konto.";
        }


        @Override
        public String onLand(Player p) {

            String s = super.onLand(p) + "\n Du skal betale et beløb der svarer til 10 % af dine aktiver. Vil du hellere betale et fast beløb på " + this.cost + "kr.? Y/N \n";
            this.setOption("TAX");
            return s;
        }
    }
