public class Player {
    private String name;
    private int score;
    private int position;

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

    public int updatePosition(int value){
        return position += value;
    }


}

