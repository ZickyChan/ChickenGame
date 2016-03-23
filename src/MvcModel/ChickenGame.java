/*
 * This is where the game is initiated.
 */
package MvcModel;

import java.io.IOException;

public class ChickenGame {
    public static void main(String[] args) throws IOException, InterruptedException {
        GameView gv = new GameView();
        GameModel gm = new GameModel();
        GameController gc = new GameController(gv,gm);  
    }
    
}
