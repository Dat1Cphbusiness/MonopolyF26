public class Card {

    String message;
    int income;
    int cost;
    String event;
    int newPosition;

    public Card(String message, int income, int cost, String event, int newPosition) {
        this.message = message;
        this.income = income;
        this.cost = cost;
        this.event = event;
        this.newPosition=newPosition;
    }

    @Override
    public String toString() {
        return "Card{" +
                "message='" + message + '\'' +
                ", income=" + income +
                ", cost=" + cost +
                ", event='" + event + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public int getIncome() {
        return income;
    }

    public int getCost() {
        return cost;
    }

    public String getEvent() {
        return event;
    }







}
