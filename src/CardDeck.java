public class CardDeck {
    private Card[] cards;
    private int counter;

    public CardDeck(String[] carddata){
        this.counter = 0;
        cards = new Card[carddata.length];

        createCards(carddata);
    }

    public Card getNext(){
        return cards[0];
    }

    public void createCards(String[] data){

    }
}
