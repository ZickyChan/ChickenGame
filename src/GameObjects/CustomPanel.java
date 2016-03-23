/*
 * This is where a custom JPanel that take image as a background defined.
 * References: http://stackoverflow.com/questions/12708532/java-jpanel-how-to-overlap-them-to-set-a-background-image
 */
package GameObjects;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CustomPanel extends JPanel
{
    private BufferedImage image;

    public CustomPanel()
    {
        setOpaque(true);
        try
        {
            image = ImageIO.read(new File("background.png"));
        }
        catch(IOException ioe)
        {
            System.out.println("Unable to fetch image.");
            ioe.printStackTrace();
        }
    }

    /*
     * Make this one customary habbit,
     * of overriding this method, when
     * you extends a JPanel/JComponent,
     * to define it's Preferred Size.
     * Now in this case we want it to be 
     * as big as the Image itself.
     */
    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(image.getWidth(), image.getHeight()));
    }

    /*
     * This is where the actual Painting
     * Code for the JPanel/JComponent
     * goes. Here we will draw the image.
     * Here the first line super.paintComponent(...),
     * means we want the JPanel to be drawn the usual 
     * Java way first, then later on we will
     * add our image to it, by writing the other line,
     * g.drawImage(...).
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
