/*
 * This is where player enter a name for an account in order to start the game
 */
package GameObjects;

import java.awt.*;
import java.io.File;
import javax.swing.*;

public class GameEntrance extends CustomPanel{
    private JTextField playerName;
    private JLabel fillNameInstruct;
    private JTextArea overalInstruct;
    private JButton okBtn;
    private JButton registerBtn;
    
    private Font bloggerSanBigger;
    private Font bloggerSanMedium;
    private Font vigaSmall;
    private Font vigaMedium;
    
    public GameEntrance(){
        try {
            // Create a customed font to use. Specify the size
            bloggerSanBigger = Font.createFont(Font.TRUETYPE_FONT, 
                    new File("Blogger Sans-Medium.otf")).deriveFont(25f);
            bloggerSanMedium = Font.createFont(Font.TRUETYPE_FONT, 
                    new File("Blogger Sans-Medium.otf")).deriveFont(18f);
            vigaSmall = Font.createFont(Font.TRUETYPE_FONT, 
                    new File("Viga-Regular.otf")).deriveFont(15f);
            vigaMedium = Font.createFont(Font.TRUETYPE_FONT, 
                    new File("Viga-Regular.otf")).deriveFont(18f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            // Register the font
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, 
                    new File("Blogger Sans-Medium.otf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, 
                    new File("Viga-Regular.otf")));
        } catch (Exception e) {
            System.err.println(e);    
        }
        
        // Initialize GUI components
        fillNameInstruct = new JLabel("ENTER YOUR NAME");
        overalInstruct = new JTextArea("** Enter your name first."
                + "\nIf you have not registered before, click New Player button to sign up."
                + "\nOtherwise, click OK button to log in.", 3, 1);
        playerName = new JTextField();
        okBtn = new JButton("OK");
        registerBtn = new JButton("New Player");

        // Use the font          
        fillNameInstruct.setFont(bloggerSanBigger);
        overalInstruct.setFont(vigaSmall);
        playerName.setFont(vigaMedium);
        okBtn.setFont(bloggerSanMedium);
        registerBtn.setFont(bloggerSanMedium);
        
        // Set color for GUI components
        fillNameInstruct.setForeground(new Color(0, 66, 124));
        overalInstruct.setForeground(new Color(102, 109, 121));
        overalInstruct.setOpaque(false);
        playerName.setForeground(new Color(61,66,85));
        okBtn.setForeground(new Color(246, 145, 127));
        okBtn.setBackground(new Color(173, 50, 40));
        registerBtn.setBackground(new Color(0, 182, 241));
        registerBtn.setForeground(new Color(234, 249, 254));
        
        // Set border for button
        okBtn.setBorder(null);
        registerBtn.setBorder(null);
                
        // Set size for GUI components
        fillNameInstruct.setBounds(1200/2 - 120, 900/2 - 151, 240, 50);
        playerName.setBounds(1200/2 - 200, 900/2 - 91, 400, 50);
        okBtn.setBounds(1200/2 + 114, 900/2 - 32, 86, 36);
        registerBtn.setBounds(1200/2 - 200, 900/2 - 32, 150, 36);
        overalInstruct.setBounds(1200/2 - 200, 900/2 + 24, 500, 80);
        
        // Customize the main JPanel
        this.setLayout(null);
        this.add(fillNameInstruct);
        this.add(playerName);
        this.add(okBtn);
        this.add(registerBtn);
        this.add(overalInstruct);
        
        this.setSize(1200,900);
        this.setBounds(0,0,1200,900);
    }
    // GUI component getters
    public JTextField getPlayerName(){
        return playerName;
    }
    public JLabel getEntranceInstruct(){
        return fillNameInstruct;
    }
    public JButton getOkBtn(){
        return okBtn;
    }
    public JButton getRegisterBtn(){
        return registerBtn;
    }
}
