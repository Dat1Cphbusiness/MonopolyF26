import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TaxTest {
    Game game = new Game("matador", 2);
    Player p = new Player("Egon", 30000);
    @BeforeEach
    void setUp() {
        game.createGameAssets();
    }

    @Test
    void onReject() {
    }

    @Test
    void onAccept() {
       Field tax = game.getBoard().getField(5);
        //ACT
       String message = tax.onLand(p);
       //tax.onAccept(p);
        System.out.println(message);

         int expected = 26000;
         int actual = p.getBalance();

         //ASSERT
        assertEquals(expected, actual);

    }

    @Test
    void onLand() {
    }
}