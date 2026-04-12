import java.util.ArrayList;
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
        int totalPlayers = ui.promptNumeric("Hvor mange skal være med?");
        while (totalPlayers < 2 || totalPlayers > 6){
            totalPlayers = ui.promptNumeric("Ugyldigt antal, skal være mellem 2-6. Hvor mange skal være med?");
        }
        //boolean
        while(this.players.size() < totalPlayers) {
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

    public void runGameLoop(){
        int count = 0;
        boolean continueGame = true;
        while (continueGame){
            currentPlayer = players.get(count % players.size());
            throwAndMove();
            count++;
            continueGame = ui.promptBinary("Fortsæt? Y/N");
        }

        //Skal nok kaldes via endSession(), men denne er ikke lavet endnu, og skal højest sandsynligvis også gemme data.
        //Midlertidig direkte print til bruger for at vise spillet afsluttes.

        ui.displayMsg("Tak for denne gang, spillet lukkes");

    }

    public void throwAndMove(){
        ui.displayMsg("Det er nu " + currentPlayer.getName() + "'s tur.");
    }

    public void landAndAct(){

    }


}