/*
 * One of the product type produced by chicken
 */
package GameObjects;

import java.awt.Image;
import javax.swing.ImageIcon;

public class NormalEgg extends ChickenProduction{
    private static final NormalEgg INSTANCE = new NormalEgg();

    private NormalEgg(){
        image = new ImageIcon("normal-egg.png").getImage();
        imageArray = new Image[7];
        imageArray[0] = image;
        imageArray[1] = new ImageIcon("normal-egg2.png").getImage();
        imageArray[2] = new ImageIcon("normal-egg3.png").getImage();
        imageArray[3] = new ImageIcon("normal-egg4.png").getImage();
        imageArray[4] = new ImageIcon("normal-egg5.png").getImage();
        imageArray[5] = new ImageIcon("normal-egg6.png").getImage();
        imageArray[6] = new ImageIcon("normal-egg7.png").getImage();
        scoreGiven = 10;
    }
    
    public static NormalEgg getNormalEgg(){
        return new NormalEgg();
    }  
}
