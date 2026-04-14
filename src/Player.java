import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Property> deeds;
    ArrayList<Card> changeCards;
    private int position;
    private int balance;

    public Player(String name, int balance){
        this.name = name;
        this.balance= balance;
        this.deeds = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name + ", "+ balance;
    }


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int updatePosition(int value){
        position += value;
        if(position > 40){
            position -= 40;
            startPassed();
        }
        return position;
    }

    private void startPassed() {
        //set hasPassed flag
        Bank.deposit(4000,this);
    }

    public boolean buyProperty(Property pf) {
        if (Bank.withdraw(pf.getCost(), this)) {
            deeds.add(pf);
            return true;
        }
        return false;
    }

    public int getTotalWorth() {
        int total = balance;
        for (Property deed : deeds) {
            total += deed.getCost();
        }
        return total;
    }

}
