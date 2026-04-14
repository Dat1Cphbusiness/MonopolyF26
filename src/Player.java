public class Player {
    private String name;
    private int score;
    private int position;
    private int balance;

    public Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name + ", "+ score;
    }

    public int getScore(){
        return score;
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
            Bank.deposit(4000,this);
        }
        return position;
    }


}

