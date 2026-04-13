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
        //totalPlayers > 6 should be dynamic, can use field maxPlayers instead.
        //Fejlbesked skal også ændres så at der oplyses 2-(maxPlayers) i stedet.
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
        endSession();
    }

    public void throwAndMove(){
        ui.displayMsg("Det er nu " + currentPlayer.getName() + "'s tur.");
    }

    public void landAndAct(){

    }

    public void endSession(){
        ui.displayMsg("Tak for denne gang, spillet lukkes");
    }

}