/*
* UC1: Start game

The system creates the Board and other game assets.
The system creates and shows the list of Players based on player data.
If there is no player data, the system prompts the user to register
Players of a new game (see UC2: registerPlayer).
*
Rainy day:
 - player data exists, but the user wishes to start a game: If saved player data exists, the system must prompt the user to make a choice between continuing or starting a new game.
*
* */

public class Main {

    public static void main(String [] args) {
        Game g = new Game("Yatzy", 3);
        g.startSession();

    }


}
