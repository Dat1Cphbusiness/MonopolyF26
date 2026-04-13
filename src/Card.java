import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Card {

    private String message;
    private int income;
    private int cost;
    private String event;
    private int newPosition;

    static String header;
    static File file = new File("data/ChanceCard.csv");
    static List<Card> cards = new ArrayList<>();

    public Card(String message, int income, int cost, String event, int newPosition) {
        this.message = message;
        this.income = income;
        this.cost = cost;
        this.event = event;
        this.newPosition = newPosition;
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

    public int getNewPosition() {
        return newPosition;
    }


    public static void createCards() {
        try {
            Scanner reader = new Scanner(file);
            header = reader.nextLine();

            List<String> lines = new ArrayList<>();
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
            reader.close();

            for (int i = 0; i < lines.size(); i++) {
                String[] data = lines.get(i).split(",");
                String message = data[0];
                int income = Integer.parseInt(data[1]);
                int cost = Integer.parseInt(data[2]);
                String event = data[3];
                int newPosition = Integer.parseInt(data[4]);

                cards.add(new Card(message, income, cost, event, newPosition));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void displayCards() {
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            System.out.println("Card " + (i + 1) + ":");
            System.out.println("  Message: " + card.getMessage());
            System.out.println( card.getIncome());
            System.out.println( card.getCost());
            System.out.println( card.getEvent());
            System.out.println( card.getNewPosition());

        }
    }
}