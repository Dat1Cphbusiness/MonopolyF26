import java.util.ArrayList;

public class Player {
    private String name;

    private int position;
    private int balance;
    ArrayList<Property> deeds;
    private boolean inPrison;
    private boolean hasWildCard;
    private int diceRoll;

    public Player(String name, int balance){
        this.name = name;
        this.balance= balance;
        deeds=new ArrayList<>();
        inPrison=false;
        hasWildCard=false;
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
        diceRoll = value;
        return position;
    }

    public int moveToPosition(int value){
      position = value;
      return position;
    }

    public void imprison(){
        inPrison = true;
        moveToPosition(31);
    }

    public void freeFromPrison(){
        inPrison = false;
    }

    private void startPassed() {
        //set hasPassed flag
        Bank.deposit(4000,this);
    }
    public boolean buyProperty(Property pf){
        boolean f = Bank.withdraw(pf.getCost(),this);
            deeds.add(pf);
            return f;
    }
    public int getTotalWorth(){
        int result=getBalance();
        for(int i =0;i< deeds.size();i++ ){
            result+=deeds.get(i).getCost();

        }
        return result;
    }

    public boolean isHasWildCard() {
        return hasWildCard;
    }

    public void setHasWildCard(boolean hasWildCard) {
        this.hasWildCard = hasWildCard;
    }

    public int getDiceRoll(){
        return diceRoll;
    }
}

