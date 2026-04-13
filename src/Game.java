import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import util.TextUI;
import util.FileIO;

public class Game {

    private String name;
    private int maxPlayers;
    private List<Player> players;
    TextUI ui = new TextUI();
    private Player currentPlayer;

    public Game(String name, int maxPlayers){
        this.name = name;
        this.maxPlayers = maxPlayers;
        players = new ArrayList<>();
    }

    public void startSession(){
        ui.displayMsg("\uD83C\uDFA9 Welcome to "+this.name+" \uD83C\uDFA9");

        ArrayList<String> data = FileIO.readData("data/playerData.csv");

        if(!data.isEmpty() && ui.promptBinary("Continue previously saved game? Y/N")){
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
        int totalPlayer = 1;
        ui.displayMsg("Hvor mange skal være med?");

        while (totalPlayer < 2 || totalPlayer > 6){
            totalPlayer = ui.promptNumeric("Tast et tal mellem 2 og 6");
        }

        while(this.players.size() < totalPlayer) {
            String playerName = ui.promptText("Tast spiller navn");
            this.createPlayer(playerName, 0);
        }

        Collections.shuffle(players);
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


    public void runGameLoop() {
        throwAndMove();


    }

    public void throwAndMove(){
        int count = 0;
        boolean continueGame = true;
        while (continueGame) {
            currentPlayer = players.get(count);
            ui.displayMsg("Det er " + currentPlayer.getName() + "'s tur");
            count++;
            if(count>=players.size()){
                count=0;
            }
            continueGame = ui.promptBinary("Fortsæt? Y/N");
            endSession();
        }
    }

    public void landAndAct(){

    }


    public void endSession(){
        ui.displayMsg("Spillet er slut");
    }

}