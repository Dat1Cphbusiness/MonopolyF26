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
        for (int i = 0; i < cards.length; i++) {
            String[] values = data[i].split(",");
            String message = values[0].trim();
            int income = Integer.parseInt(values[1].trim());
            int cost = Integer.parseInt(values[2].trim());
            String event = values[3].trim();
            cards[i] = new Card(message, income, cost, event);
        }
    }
}
