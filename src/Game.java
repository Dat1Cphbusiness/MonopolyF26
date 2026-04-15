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
    public static Board board;
    private Dice dice = new Dice();



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

        //klar til at bygge model af spillet
        createGameAssets();



    }

    public void createGameAssets() {
       String[] fielddata =  FileIO.readData("data/fieldData.csv", 40);
       String[] carddata = FileIO.readData("data/cardData.csv", 54);
        System.out.println(carddata[0]);


       Board board = new Board(fielddata,carddata);
       this.board = board;
       //TEST



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
       // int result = dice.rollDiceSum();
         //ui.displayMsg(currentPlayer.getName()+" har slået "+result);

         ui.displayMsg(dice.getDiceRoll()[0]+ " : "+dice.getDiceRoll()[1]);
         //Tjek om det er tredje dobbelslag, sæt position til fænges hvis ja


        //opdateren spillerens position
        int newPosition = currentPlayer.updatePosition(3);

        //

        //find det felt han er landet på
        Field f = board.getField(newPosition);
        landAndAct(f);

    }

    public void landAndAct(Field f){
       String message = f.onLand(currentPlayer);

        if(f.getOption() != null){

            boolean response = ui.promptBinary(message);
            if(response){
               String acceptanceMessage = f.onAccept(currentPlayer);
               ui.displayMsg(acceptanceMessage);

            }else{
                f.onReject(currentPlayer);
            }
        }else{
            ui.displayMsg(message);
        }



    }

    public void endSession(){
        ui.displayMsg("Tak for denne gang, spillet lukkes");
    }

    public Board getBoard() {
        return board;
    }
}