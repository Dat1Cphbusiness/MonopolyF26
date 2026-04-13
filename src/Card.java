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

    public Card(String message, int income, int cost, String event) {
        this.message = message;
        this.income = income;
        this.cost = cost;
        this.event = event;
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

    static String header;
    File file = new File("data/ChanceCard.csv");

    public void createCards() {
        try {
            Scanner reader = new Scanner(file);
            header = reader.nextLine(); // skipper header

            List<String> lines = new ArrayList<>();
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
            reader.close();

            for (int i = 0; i < lines.size(); i++) {
                String[] data = lines.get(i).split(",");
                // brug data[0], data[1], osv.
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
