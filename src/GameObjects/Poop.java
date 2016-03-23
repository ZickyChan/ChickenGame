/*
 * One of the product type produced by chicken
 */
package GameObjects;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Poop extends ChickenProduction{ 
    private static final Poop INSTANCE = new Poop();
    
    private Poop(){
        image = new ImageIcon("shit.png").getImage();
        imageArray = new Image[7];
        imageArray[0] = image;
        imageArray[1] = new ImageIcon("shit2.png").getImage();
        imageArray[2] = new ImageIcon("shit3.png").getImage();
        imageArray[3] = new ImageIcon("shit4.png").getImage();
        imageArray[4] = new ImageIcon("shit5.png").getImage();
        imageArray[5] = new ImageIcon("shit6.png").getImage();
        imageArray[6] = new ImageIcon("shit7.png").getImage();
        scoreGiven = -20;
    }
    static Poop getPoop(){
        return new Poop();
    }
}
