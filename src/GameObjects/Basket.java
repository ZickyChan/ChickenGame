package GameObjects;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class Basket extends JLabel{
    private String image = "basket.png";
    private int width = 155;
    private int height = 200;
    private int xCoordination = 0;
    private int yCoordination = 700;
    
    public Basket(){
        ImageIcon basketImage = new ImageIcon(image);
        setIcon(basketImage);
        setOpaque(false);   
        setSize(width, height);
        setLocation(xCoordination, yCoordination);        
    }
    
    // Coordination setters
    public void setXCooridnate(int x){
        xCoordination = x;
    }
    public void setYCooridnate(int y){
        yCoordination = y;
    }
    
    // Coordination getters
    public int getXCoordinate(){
        return xCoordination;
    }
    public int getYCoordinate(){
        return yCoordination;
    }
}