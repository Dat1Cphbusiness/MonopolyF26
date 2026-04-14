import java.util.Random;

public class Dice {
    private Random random;
    private int[] diceRoll;
    int doubleDiceCounter = 0;

    public Dice(){
        diceRoll = new int[2];
        random = new Random();
    }

    public int rollDiceSum(){
        diceRoll[0] = random.nextInt(6) +1;
        diceRoll[1] = random.nextInt(6) +1;
        if(diceRoll[0] == diceRoll[1]){
            boolean isDouble = true;
            doubleDiceCounter++;
        } else {
            doubleDiceCounter = 0;
            boolean isDouble = false;
        }



        return diceRoll[1] + diceRoll[0];
    }

    public void resetDoubleDiceCounter(){
        doubleDiceCounter = 0;
    }

    public int[] getDiceRoll() {
        return diceRoll;
    }
}
