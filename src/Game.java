import java.util.ArrayList;
import java.util.List;
import util.TextUI;
import util.FileIO;

public class Game {

    private String name;
    private int maxPlayers;
    private List<Player> players;
    TextUI ui = new TextUI();

    public Game(String name, int maxPlayers){
        this.name = name;
        this.maxPlayers = maxPlayers;
        players = new ArrayList<>();
    }

    public void startSession(){

        ui.promptText("Velkommen til Matador"); //Max

        ArrayList<String> data = FileIO.readData("data/playerData.csv");

        if(!data.isEmpty() && ui.promptBinary("Continue previously saved game? Y/N")){ // Louise
            for(String s : data){
                String[] values =  s.split(",");//  String'en "tess, 0" bliver til arrayet ["tess", "0"]
                int score = Integer.parseInt(values[1].trim());
                createPlayer(values[0],score);
            }
        }else{
            registerPlayers();
        }
        displayPlayers();



    }
    public void registerPlayers(){
        //boolean
        while(this.players.size() <= this.maxPlayers) {
            String playerName = ui.promptText("Tast spiller navn");
            this.createPlayer(playerName, 0);
        }
    }


    private void createPlayer(String name, int score){
        Player p = new Player(name, score);
        players.add(p);
    }

    public void displayPlayers(){
        for(Player p:players){
            System.out.println(p);
        }
    }

}