import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class CardDeck {
    Card[] cards;
    int counter;

    CardDeck(String[] carddata){
        counter = 0;
        cards = new Card[carddata.length];
        createCards(carddata);
    }

    public void createCards(String[] carddata){
        for(int i=0; i<carddata.length;i++){

            String[] parameters = carddata[i].split(",");

            String message = parameters[0].trim();
            int income = Integer.parseInt(parameters[1].trim());
            int cost = Integer.parseInt(parameters[2].trim());
            String event = parameters[3].trim();
            int newPosition = Integer.parseInt(parameters[4]);

            cards[i] = new Card(message, income, cost, event, newPosition);
        }

        Collections.shuffle(Arrays.asList(cards));


    }

    public Card getNext() {
        counter++;
        if (counter == cards.length){
            counter = 0;

        }
        return cards[counter];
    }


}
