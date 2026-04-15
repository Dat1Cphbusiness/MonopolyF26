public class Chance extends Field{
private Card card;

    public Chance(int ID, String label, Card card){
        super(ID, label, 0, 0);
        this.card = card;
    }

    public String onLand(Player p) {
        switch (card.getEvent()) {
            case "pay":
                Bank.withdraw(cost, p);
                break;
            case "receive":
                Bank.deposit(income,p);
                break;
            case "prison": p.updatePosition(11);
                break;
            case "wildcard":
                p.setWildcard(true);
                break;
            default:
                break;
        }
        return card.getMessage();
    }
}
