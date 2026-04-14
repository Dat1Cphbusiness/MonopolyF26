import java.util.ArrayList;
import java.util.Properties;

public class Player {
    private String name;
    private int balance;
    private int position;
    ArrayList<Property> deeds;
    ArrayList<Card> chanceCards;


    public Player(String name, int balance){
        this.name = name;
        this.balance = balance;
    }


    int updatePosition(int value){

        if (position+value<=40){
            position += value;
        } else {
            startPassed();
            position=(position+value)-40;
        }

        return position;

    }
    void startPassed(){
        Bank.deposit(500, this.Player);

    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name + ", "+ balance;
    }

    public int getBalance(){
        return balance;
    }

    public void setBalance(int amount){
        balance+=amount;
    }



}

