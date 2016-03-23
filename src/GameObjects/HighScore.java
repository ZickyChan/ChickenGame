/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JLabel;

public class HighScore extends CustomPanel{
    private JLabel title;
    private JButton quitBtn;
    private JButton restartBtn;
    private JLabel gradeCol;
    private JLabel playerNameCol;
    private JLabel scoreCol;
    private JLabel[] grades = new JLabel[10];
    private JLabel[] playerNames = new JLabel[10];
    private JLabel[] scores = new JLabel[10];
    
    private Font bloggerSanBigger;
    private Font bloggerSanMedium;
    private Font bloggerSanSmall;
    
    public HighScore(){
        
        try {
            // Create a customed font to use. Specify the size
            bloggerSanBigger = Font.createFont(Font.TRUETYPE_FONT, 
                    new File("Blogger Sans-Medium.otf")).deriveFont(35f);
            bloggerSanMedium = Font.createFont(Font.TRUETYPE_FONT, 
                    new File("Blogger Sans-Medium.otf")).deriveFont(25f);
            bloggerSanSmall = Font.createFont(Font.TRUETYPE_FONT, 
                    new File("Blogger Sans-Medium.otf")).deriveFont(18f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            // Register the font
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, 
                    new File("Blogger Sans-Medium.otf")));

        } catch (Exception e) {
            System.err.println(e);        
        }
        
        // Initialize GUI components
        title = new JLabel("HIGH SCORES");
        quitBtn = new JButton("Quit");
        restartBtn = new JButton("Restart");
        gradeCol = new JLabel("GRADE");
        playerNameCol = new JLabel("NAME");
        scoreCol = new JLabel("SCORE");
//        grades = new JLabel[10];
//        playerNames = new JLabel[10];
//        scores = new JLabel[10];
        
        // Use the font
        title.setFont(bloggerSanBigger);
        gradeCol.setFont(bloggerSanMedium);
        playerNameCol.setFont(bloggerSanMedium);
        scoreCol.setFont(bloggerSanMedium);
        quitBtn.setFont(bloggerSanSmall);
        restartBtn.setFont(bloggerSanSmall);
        for(int i = 0; i < 10; i++){
            grades[i] = new JLabel();
            grades[i].setFont(bloggerSanSmall);
            
            playerNames[i] = new JLabel();
            playerNames[i].setFont(bloggerSanSmall);
            
            scores[i] = new JLabel();
            scores[i].setFont(bloggerSanSmall);
        }
        
        // Set color for GUI components
        title.setForeground(new Color(232, 96, 47));
        gradeCol.setForeground(new Color(12, 102, 180));
        playerNameCol.setForeground(new Color(12, 102, 180));
        scoreCol.setForeground(new Color(12, 102, 180));
        for(int i = 0; i < 3; i++){
            grades[i].setForeground(new Color(255, 133, 0));
            playerNames[i].setForeground(new Color(255, 133, 0));
            scores[i].setForeground(new Color(255, 133, 0));
        }
        quitBtn.setForeground(new Color(246, 145, 127));
        quitBtn.setBackground(new Color(173, 50, 40));
        restartBtn.setBackground(new Color(0, 182, 241));
        restartBtn.setForeground(new Color(234, 249, 254));
        
        // Set border for buttons
        quitBtn.setBorder(null);
        restartBtn.setBorder(null);
        
        // Set size for GUI components
        title.setBounds(1500/2 - 200, 100, 400, 50);
        gradeCol.setBounds(1500/4, 160, 100, 45);
        playerNameCol.setBounds(1500/4 + 100, 160, 300, 45);
        scoreCol.setBounds(1500/4 + 450, 150, 160, 45);
        for(int i = 0; i < 10; i++){
            grades[i].setBounds(1500/4, 160 + 55 + 40 * i, 50, 30);
            playerNames[i].setBounds(1500/4 + 100, 160 + 55 + 40 * i, 100, 30);
            scores[i].setBounds(1500/4 + 450, 160 + 55 + 40 * i, 100, 30);
        }
        restartBtn.setBounds(1500/2 - 131, 160 + 55 + 400, 126, 35);
        quitBtn.setBounds(1500/2 + 5, 160 + 55 + 400, 126, 35);
        
        // Customize the main JPanel
        this.setLayout(null);
        this.add(title);
        this.add(gradeCol);
        this.add(playerNameCol);
        this.add(scoreCol);
        for(int i = 0; i < 10; i++){
            this.add(grades[i]);
            this.add(playerNames[i]);
            this.add(scores[i]);
        }
        this.add(restartBtn);
        this.add(quitBtn);
        
        this.setSize(1500,900);
        this.setBounds(0,0,1500,900);
        this.setVisible(false);
    }
    
    public JLabel[] getGrades(){
        return grades;
    }
    public JLabel[] getScores(){
        return scores;
    }
    public JLabel[] getPlayerNames(){
        return playerNames;
    }
    public JButton getQuitBtn(){
        return quitBtn;
    }
    public JButton getRestartBtn(){
        return restartBtn;
    }
}
