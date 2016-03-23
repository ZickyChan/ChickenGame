package GameObjects;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class ChickenRow extends JPanel{
    private int xCoordinate = 50;
    private int yCoordinate = 150;
    private int numberOfChickens = 5;
    protected Chicken[] chickens = new Chicken[numberOfChickens];
    private final String barImage = "bar.png";
    
    public ChickenRow(){
        setOpaque(false);
        // Create a row of chicken-JLabels
        JPanel chickenRow = new JPanel();
        chickenRow.setOpaque(false);
        chickenRow.setLayout(new FlowLayout(FlowLayout.LEFT, 92, 0));
        
        // Add the chickens to a row
        for (int i = 0; i < numberOfChickens; i++ ){
            chickens[i] = new Chicken();
            chickenRow.add(chickens[i]);
        }
        JLabel bar = new JLabel();
        
        // Create a bar (e.g. the row's image)
        bar.setIcon(new ImageIcon(barImage));
        setLayout(new GridLayout(2,0,0,-20));
        
        // Add chicken row and its bar to the main screen
        add(chickenRow);
        add(bar);
    }
    
    // Setters
    public void setXCoordinate(int x){
        xCoordinate = x;
    }
    public void setRowYCoordinate(int y){
        yCoordinate = y;
    }
    public void setNumberOfChickens(int number){
        numberOfChickens = number;
    }
    
    // Getters
    public int getXCoordinate(){
        return this.xCoordinate;
    }
    public int getYCoordinate(){
        return this.yCoordinate;
    }
    public int getNumberOfChickens(){
        return this.numberOfChickens;
    }
    public Chicken[] getChickenArray(){
        return chickens;
    } 

    // Set size for the row
    public void setDimension(){
        Dimension size = this.getPreferredSize();
        this.setBounds(xCoordinate, yCoordinate, size.width, size.height);
    } 
   
}