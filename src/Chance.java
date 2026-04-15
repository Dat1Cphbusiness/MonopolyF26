public class Chance extends Field{
private static CardDeck carddeck;

    public Chance(int ID, String label){

        super(ID, label, 0, 0);

    }

    public String onLand(Player p) {
        Card card = carddeck.getNext();

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
