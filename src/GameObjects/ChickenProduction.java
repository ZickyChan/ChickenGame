/*
 * The base class of all the chicken product types.
 * This is where the clone method for prototype patterns is defined.
 */
package GameObjects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public abstract class ChickenProduction extends JComponent implements Cloneable{
    private String id;
    private int speed = 20;
    private int xCoordinate;
    private int yCoordinate;
    protected Image image;
    protected Image[] imageArray;
    protected int scoreGiven;
    int velY = 2;
    int velX = 7;
    
    public Object clone() {
        Object clone = null;
      
        try {
            clone = super.clone();
         
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }  
    public int getScoreGiven(){
        return scoreGiven;
    }
    public String getId() {
        return id;
    }  
    public void setId(String id) {
       this.id = id;
    }
    public void setYCoordinate(int y){
        yCoordinate = y;
    }   
    public void setXCoordinate(int x){
        xCoordinate = x;
    }
    public int getXCoordinate(){
        return xCoordinate;
    }
    public int getYCoordinate(){
        return yCoordinate;
    }
    public void increaseYCoordinate(int y){
        yCoordinate += y;
    }
    public void increaseXCoordinate(int x){
        xCoordinate += x;
    }
    public Image getImage(int index){
        return image;
    }
    public void resetImage(){
        image = imageArray[0];
    }
    public int getSpeed(){
        return speed;
    }   
    public void setSpeed(int s){
        speed = s;
    }
    public void increaseSpeed(int s){
        speed -= s;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, xCoordinate, yCoordinate, null);
    }
    public void move(){
        increaseYCoordinate(velY);
        repaint();
    }
    
    // Set animation for the falling product
    public void fall(int index){
        image = imageArray[index];
        increaseYCoordinate(velY);
        // If the product hits the edge of the basket, it falls out
        // That means its x coordination moves to the left, the negative side.
        if(index <3){
            increaseXCoordinate(-velX);
        }
        
        // If the product falls in the middle area of the basket,
        // it keeps its x coordination
        else if(index >3 && index < 7){         
            increaseXCoordinate(velX);
        }
        repaint();
    }
}
