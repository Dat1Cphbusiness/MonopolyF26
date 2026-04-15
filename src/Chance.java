public class Chance extends Field{

    static CardDeck cardDeck;

    public Chance(int ID, String label){
        super(ID, label, 0, 0);
    }

    @Override
    public String onLand(Player p){
       String msg= super.onLand(p);
       String cardMsg=cardDeck.getNext().getMessage();
       return msg+"\n"+cardMsg;

    }


}
