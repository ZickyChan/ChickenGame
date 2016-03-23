/*
 * This is where the game interface is handled in MVC design pattern
 */
package MvcModel;

import GameObjects.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;
import javax.swing.*;

public class GameView extends JFrame {

    final private int[] PRODUCT_X_COORDINATE;
    final static CustomPanel CONTENT_PANEL = new CustomPanel();  // the main screen 
    private Basket basket;
    
    ChickenProduction product;
    private ChickenRow row;
    private JLabel timeBox;
    private JLabel scoreBox;
    private JLabel lifeBox;
    private Font customFont;
    
    private GameEntrance entrance = new GameEntrance();
    private GameOver over = new GameOver();
    private HighScore highScore = new HighScore();
        
    GameEntrance getEntrance(){
        return entrance;
    }  
    GameOver getGameOver(){
        return over;
    }
    HighScore getHighScore(){
        return highScore;
    }
    Basket getBasket(){
        return basket;
    }
    JLabel getLifeBox(){
        return lifeBox;
    }
    JLabel getScoreBox(){
        return scoreBox;
    }
    JLabel getTimeBox(){
        return timeBox;
    }
    
    public  GameView() throws InterruptedException{
        
        basket = new Basket();        
        //PRODUCT_X_COORDINATE = new int[]{140, 240, 340, 435, 535};
        PRODUCT_X_COORDINATE = new int[]{120, 220, 320, 415, 515};
        
        try {
            // Create a customed font to use. Specify the size
            customFont = Font.createFont(Font.TRUETYPE_FONT, 
                    new File("Kavoon-Regular.otf")).deriveFont(16f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            // Register the font
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, 
                    new File("Kavoon-Regular.otf")));
        } catch (Exception e) {
            System.err.println(e);
        }
        
        // Create labels to hold the game information, 
        // which includes: Time, Score and Life
        timeBox = new JLabel();
        scoreBox = new JLabel();
        lifeBox = new JLabel();
        
        // Use the font and set its color           
        timeBox.setFont(customFont);
        scoreBox.setFont(customFont);
        lifeBox.setFont(customFont);
        timeBox.setForeground(new Color(0,66,124));
        scoreBox.setForeground(new Color(0,66,124));
        lifeBox.setForeground(new Color(0,66,124));
        
        // Create a panel to hold all the game main screen's text 
        // (e.g. Time, Score, Life)
        JPanel text = new JPanel(new GridLayout(0,3,300,0));
        text.setOpaque(false);
        text.setBounds(80,15,1200,50);
        timeBox.setText("Time 00:00");  // Set the intiate time of the game
        text.add(timeBox);
        text.add(scoreBox);
        text.add(lifeBox);
        
        // Create a row to hold all the chickens
        row = new ChickenRow();
        row.setDimension();
        
        // Customize the main screen CustomPanel
        CONTENT_PANEL.setLayout(null); 
        CONTENT_PANEL.add(text);
        CONTENT_PANEL.add(row);
        CONTENT_PANEL.add(basket);
        CONTENT_PANEL.setSize(1200, 900);
        CONTENT_PANEL.setVisible(false);
        
        // Add everything to the JFrame
        add(CONTENT_PANEL);
        add(entrance);
        add(over);
        add(highScore);
        
        setSize(1200,935);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Load the cache that holds all the chicken products 
        // (e.g. GoldenEgg, NormalEgg, Poop)
        ChickenProductionCache.loadCache();
        
        Random random = new Random();
        
        // Random number generation to pick the first product type falling down from a chicken
        int randomProduct = random.nextInt(20); 
        
        // Set the type of product for the chicken to produce based on the random number
        if(randomProduct < 12)
            product = (ChickenProduction) ChickenProductionCache.getChickProd("prod-02");
        else if(randomProduct < 17)
            product = (ChickenProduction) ChickenProductionCache.getChickProd("prod-03");
        else
            product = (ChickenProduction) ChickenProductionCache.getChickProd("prod-01");
    }
    
    public void drop(Timer t){
        // Get all the chickens on the row and store them in an ArrayList
        Chicken[] chickens = row.getChickenArray();
        
        Random random = new Random();
        
        // Random number generation to pick a product type falling down from a chicken
        int randomProduct = random.nextInt(20); 
        
        // Set the type of product for the chicken to produce based on the random number
        if(randomProduct < 12)
            product = (ChickenProduction) ChickenProductionCache.getChickProd("prod-02");
        else if(randomProduct < 17)
            product = (ChickenProduction) ChickenProductionCache.getChickProd("prod-03");
        else
            product = (ChickenProduction) ChickenProductionCache.getChickProd("prod-01");

        // Random number generation to pick a chicken on the row to produce a product
        int  position = random.nextInt(5);     
        
        // Get the chicken layig that product and change its state
        chickens[position].changeState();
        
        // Set the start position and the image of a chicken product
        product.setXCoordinate(PRODUCT_X_COORDINATE[position]);
        product.setYCoordinate(100);
        product.resetImage();
        CONTENT_PANEL.add(product);
        
        t.start();
    }
    
    public void addMouseMovementListener(MouseMotionListener e){
        CONTENT_PANEL.addMouseMotionListener(e);
    }
}
