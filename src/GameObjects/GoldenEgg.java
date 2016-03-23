/*
 * One of the product type produced by chicken
 */
package GameObjects;

import java.awt.Image;
import javax.swing.ImageIcon;

public class GoldenEgg extends ChickenProduction {
    private static final GoldenEgg INSTANCE = new GoldenEgg();
    private GoldenEgg(){
        image = new ImageIcon("golden-egg.png").getImage();
        imageArray = new Image[7];
        imageArray[0] = image;
        imageArray[1] = new ImageIcon("golden-egg2.png").getImage();
        imageArray[2] = new ImageIcon("golden-egg3.png").getImage();
        imageArray[3] = new ImageIcon("golden-egg4.png").getImage();
        imageArray[4] = new ImageIcon("golden-egg5.png").getImage();
        imageArray[5] = new ImageIcon("golden-egg6.png").getImage();
        imageArray[6] = new ImageIcon("golden-egg7.png").getImage();
        scoreGiven = 20;            
    }
    
    public static GoldenEgg getGoldenEgg(){
        return new GoldenEgg();
    }
}
