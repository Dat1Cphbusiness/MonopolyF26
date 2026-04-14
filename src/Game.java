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
        ui.displayMsg("Hvor mange skal være med?");
        ArrayList<String> data = FileIO.readData("data/playerdata.csv");


        if(!data.isEmpty() && ui.promptBinary("Continue previously saved game? Y/N")){
            for(String s : data){
                String[] values =  s.split(",");//  String'en "tess, 0" bliver til arrayet ["tess", "0"]
                int balance = Integer.parseInt(values[1].trim());
                createPlayer(values[0],balance);
            }
        }else{
            registerPlayers();
        }
        displayPlayers();

        //klar til at bygge model af spillet
        createGameAssets();



    }

    private void createGameAssets() {
       String[] fielddata =  FileIO. readData("data/fieldData.csv", 40);
       String[] carddata = FileIO.readData("data/cardData.csv", 54);
        System.out.println(carddata[0]);


       Board board = new Board(fielddata,carddata);

       //TEST
       Field f = board.getField(40);
       String message = f.onLand(currentPlayer);

        System.out.println(message);


    }

    public void registerPlayers(){
        //boolean
        //Asking player first for amount of players.
        int totalPlayer = ui.promptNumeric("Hvor mange spillere skal være med?");

        //Changed max total players to reflect maxPlayers of the game itself
        while (totalPlayer < 2 || totalPlayer > this.maxPlayers){
            totalPlayer = ui.promptNumeric("Tast et tal mellem 2 og " + this.maxPlayers);
        }

        while(this.players.size() < totalPlayer) {
            String playerName = ui.promptText("Tast spiller navn");
            this.createPlayer(playerName, 0); 
        }

        Collections.shuffle(players);
    }

    private void createPlayer(String name, int balance){
        Player p = new Player(name, balance);
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