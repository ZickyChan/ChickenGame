package GameObjects;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.random;
import java.util.Random;
import javax.swing.*;

public class Chicken extends JLabel{
    Timer timer;
    String normalStateImg = "chicken-normal-state.png";
    String layingStateImg = "chicken-lay-egg-state.png";
    protected Image image;
    int timePeriodBetweenLayings = 700;
    
    public Chicken(){
        setIcon(new ImageIcon(normalStateImg));
        setSize(105,109);
    }
    
    // Change the chicken image based on its state
    public void changeState(){
        // switch to laying state
        setIcon(new ImageIcon(layingStateImg)); 
        Chicken chick = this;
        
        // after 700 seconds, switch back to the noraml state
        timer = new Timer (timePeriodBetweenLayings, new ActionListener(){  
           @Override
            public void actionPerformed(ActionEvent event) {
                chick.setIcon(new ImageIcon(normalStateImg));
            }
        });
        
        timer.setRepeats(false);    // turn off repeat mode
        timer.start();
    }
    
}