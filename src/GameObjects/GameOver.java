/*
 * This is where the player choose to start a new game or quit after loosing
 */
package GameObjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class GameOver extends CustomPanel{
    private JLabel mess;
    private JButton quitBtn;
    private JButton restartBtn;
    private JButton highScoreBtn;
    
    private Font bloggerSanBigger;
    private Font bloggerSanMedium;
    
    public GameOver(){
        
        try {
            // Create a customed font to use. Specify the size
            bloggerSanBigger = Font.createFont(Font.TRUETYPE_FONT, 
                    new File("Blogger Sans-Medium.otf")).deriveFont(50f);
            bloggerSanMedium = Font.createFont(Font.TRUETYPE_FONT, 
                    new File("Blogger Sans-Medium.otf")).deriveFont(18f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            // Register the font
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, 
                    new File("Blogger Sans-Medium.otf")));
        } catch (Exception e) {
            System.err.println(e);        
        }
        // Initialize GUI component
        mess = new JLabel("YOU HAVE LOST!");
        quitBtn = new JButton("Quit");
        restartBtn = new JButton("Restart");
        highScoreBtn = new JButton("High Score");

        // Use the font          
        mess.setFont(bloggerSanBigger);
        quitBtn.setFont(bloggerSanMedium);
        restartBtn.setFont(bloggerSanMedium);
        highScoreBtn.setFont(bloggerSanMedium);
        
        // Set color for GUI components
        mess.setForeground(new Color(0, 182, 240));
        quitBtn.setForeground(new Color(246, 145, 127));
        quitBtn.setBackground(new Color(173, 50, 40));
        restartBtn.setBackground(new Color(0, 182, 241));
        restartBtn.setForeground(new Color(234, 249, 254));
        highScoreBtn.setForeground(new Color(197, 230, 97));
        highScoreBtn.setBackground(new Color(23, 114, 83));
        
        // Set border for buttons
        quitBtn.setBorder(null);
        restartBtn.setBorder(null);
        highScoreBtn.setBorder(null);
        
        // Set size for GUI components
        mess.setBounds(1200/2 - 200, 900/2 - 48, 400, 50);
        restartBtn.setBounds(1200/2 - 300, 900/2 + 12, 126, 35);
        quitBtn.setBounds(1200/2 - 100, 900/2 + 12, 126, 35);
        highScoreBtn.setBounds(1200/2 + 100, 900/2 + 12, 126, 35);
        
        // Customize the main JPanel
        this.setLayout(null);
        this.add(mess);
        this.add(restartBtn);
        this.add(quitBtn);
        this.add(highScoreBtn);
        
        this.setSize(1200,900);
        this.setBounds(0,0,1200,900);
        this.setVisible(false);
    }
    // Button getters
    public JButton getRestartBtn(){
        return restartBtn;
    }
    public JButton getQuitBtn(){
        return quitBtn;
    }
    
    // Button actions
    public void addRestartListener(MouseListener e){
        restartBtn.addMouseListener(e);
    }
    public void addQuitListener(MouseListener e){
        quitBtn.addMouseListener(e);
    }
    public void addHighScoreListener(MouseListener e){
        highScoreBtn.addMouseListener(e);
    }
}
