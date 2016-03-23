/*
 * This is where the game is manipulated in MVC design pattern
 */
package MvcModel;

import GameObjects.Poop;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class GameController {
    
    private GameView gv;
    private GameModel gm;
    
    Timer timerNextDrop;
    Timer timer;
    Timer timeCount;
    Timer fallingTime;
    TimeClass clock;
    
    int lvl = 1;
    private int nextSpeed = 5000;
    
    private int getNextSpeed(){
        return nextSpeed;
    }
    private void increaseNextSpeed(int x){
        nextSpeed -= x;
        timerNextDrop = new Timer(nextSpeed, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              gv.drop(timer);
            }
        });
        timerNextDrop.start();
    }
    
    private void openMainScreen(){
        try {
            gv.getEntrance().setVisible(false);
            gv.getGameOver().setVisible(false);
            gv.getHighScore().setVisible(false);
            gv.CONTENT_PANEL.setVisible(true);
            
            gv.addMouseMovementListener(new BasketMovements());
            
            gm.player.setScore(0);
            gm.player.setLife(5);

            gv.getLifeBox().setText(String.valueOf(gm.player.getLife()));
            gv.getScoreBox().setText(String.valueOf(gm.player.getScore()));
            
            clock = new TimeClass();
            timeCount = new Timer(1000,clock);
            timeCount.start();
            timer = new Timer(this.gv.product.getSpeed(),new DropProduct());

            increaseNextSpeed(0);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    private void gameOver(){
        gv.getEntrance().setVisible(false);
        gv.CONTENT_PANEL.setVisible(false);
        gv.getHighScore().setVisible(false);
        gv.getGameOver().setVisible(true);
        gv.getTimeBox().setText("Time 00:00");
        gv.getGameOver().addRestartListener(new Restart());
        gv.getGameOver().addQuitListener(new Quit());
        gv.getGameOver().addHighScoreListener(new HighScoreTable());
        timerNextDrop.stop();
        timer.stop();
        timeCount.stop(); 
    }
    
    private void openHighScore(){
        gv.getEntrance().setVisible(false);
        gv.CONTENT_PANEL.setVisible(false);
        gv.getGameOver().setVisible(false);
        gv.getHighScore().setVisible(true);
        gv.getHighScore().getQuitBtn().addMouseListener(new Quit());
        gv.getHighScore().getRestartBtn().addMouseListener(new Restart());
    }
    
    public GameController(GameView gv, GameModel gm) throws IOException{
        this.gv = gv;
        this.gm = gm;
        this.gv.getEntrance().getOkBtn().addMouseListener(new OkBtnListener());
        this.gv.getEntrance().getRegisterBtn().addMouseListener(new Register());
    }
    
    class BasketMovements implements MouseMotionListener {      
        public void mouseDragged(MouseEvent m){
        }
        @Override
        public void mouseMoved(MouseEvent m){
            int x = m.getX();
            int oldX = gv.getBasket().getXCoordinate();
            if(x > 1500 - gv.getBasket().getWidth()){
                x = 1500 - gv.getBasket().getWidth();
            }
            gv.getBasket().setXCooridnate(x);
            gv.getBasket().setLocation(x, gv.getBasket().getYCoordinate());
        }
    }
    
    class DropProduct implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(gv.product.getYCoordinate() == 334 && !(gv.product instanceof Poop)
               && (gv.product.getXCoordinate()*2) >= (gv.getBasket().getXCoordinate() + 30)
               && (gv.product.getXCoordinate()*2) < (gv.getBasket().getXCoordinate() + 55)){
                timer.stop();
                fallingTime = new Timer(gv.product.getSpeed() + 20, new ActionListener() {
                    int index = 1;
                    @Override
                    public void actionPerformed(ActionEvent event) {
                      gv.product.fall(index);
                      gv.product.setBounds(gv.product.getXCoordinate(),gv.product.getYCoordinate(),1300,500);
                      if(index < 4){
                          index++;
                      }
                      if(index == 4){
                          ((Timer)event.getSource()).stop();
                          timer.start();
                      }
                    }
                });
                fallingTime.start();
                
            }
            else if(gv.product.getYCoordinate() == 334 && !(gv.product instanceof Poop)
                && (gv.product.getXCoordinate()*2) >= (gv.getBasket().getXCoordinate() + 75)
               && (gv.product.getXCoordinate()*2) < (gv.getBasket().getXCoordinate() +100)){
                timer.stop();
                fallingTime = new Timer(gv.product.getSpeed() + 20, new ActionListener() {
                    int index = 5;
                    @Override
                    public void actionPerformed(ActionEvent event) {
                      gv.product.fall(index);
                      gv.product.setBounds(gv.product.getXCoordinate(),gv.product.getYCoordinate(),1300,500);
                      if(index < 7){
                          index++;
                      }
                      if(index == 7){
                          ((Timer)event.getSource()).stop();
                          timer.start();
                      }
                    }
                });
                fallingTime.start();
            
            }
            else if(gv.product.getYCoordinate() == 336 && (gv.product instanceof Poop)
               && (gv.product.getXCoordinate()*2) >= (gv.getBasket().getXCoordinate() + 26)
               && (gv.product.getXCoordinate()*2) < (gv.getBasket().getXCoordinate() + 55)){
                timer.stop();
                fallingTime = new Timer(gv.product.getSpeed() + 20, new ActionListener() {
                    int index = 1;
                    @Override
                    public void actionPerformed(ActionEvent event) {
                      gv.product.fall(index);
                      gv.product.setBounds(gv.product.getXCoordinate(),gv.product.getYCoordinate(),1300,500);
                      if(index < 4){
                          index++;
                      }
                      if(index == 4){
                          ((Timer)event.getSource()).stop();
                          timer.start();
                      }
                    }
                });
                fallingTime.start();
            
            }
            
            else if(gv.product.getYCoordinate() == 336 && (gv.product instanceof Poop)
               && (gv.product.getXCoordinate()*2) >= (gv.getBasket().getXCoordinate() + 75)
               && (gv.product.getXCoordinate()*2) < (gv.getBasket().getXCoordinate() +104)){
                timer.stop();
                fallingTime = new Timer(gv.product.getSpeed() + 20, new ActionListener() {
                    int index = 5;
                    @Override
                    public void actionPerformed(ActionEvent event) {
                      gv.product.fall(index);
                      gv.product.setBounds(gv.product.getXCoordinate(),gv.product.getYCoordinate(),1300,500);
                      if(index < 7){
                          index++;
                      }
                      if(index == 7){
                          ((Timer)event.getSource()).stop();
                          timer.start();
                      }
                    }
                });
                fallingTime.start();
            }
            else if(gv.product.getYCoordinate() == 350 && 
               ((gv.product.getXCoordinate()*2) >= (gv.getBasket().getXCoordinate() + 55)
                && (gv.product.getXCoordinate()*2) <= (gv.getBasket().getXCoordinate() + 75 ))){
                gm.player.addScore(gv.product.getScoreGiven());
                gv.getScoreBox().setText(String.valueOf(gm.player.getScore()));
                gv.product.setBounds(gv.product.getXCoordinate(),gv.product.getYCoordinate(),0,0);
                timer.stop();
                gv.product.setYCoordinate(100);
            }
            else if(gv.product.getYCoordinate() == 460){
                timer.stop();
                if(!(gv.product instanceof Poop)){
                    gm.player.setLife(gm.player.getLife()-1);
                    gv.getLifeBox().setText(String.valueOf(gm.player.getLife()));
                }
                if(clock.getSecond() >= 30 && clock.getMinute() == 0 && lvl ==1){
                    
                    gv.product.increaseSpeed(5);
                    System.out.println(gv.product.getSpeed());
                    timer = new Timer(gv.product.getSpeed(),new DropProduct());
                    lvl++;
                }
                else if(clock.getSecond() >= 0 && clock.getMinute() == 1 && lvl ==2){
                    timerNextDrop.stop();
                    gv.product.increaseSpeed(7);
                    System.out.println(gv.product.getSpeed());
                    timer = new Timer(gv.product.getSpeed(),new DropProduct());
                    increaseNextSpeed(1200);
                    lvl++;
                }
                else if(clock.getSecond() >= 30 && clock.getMinute() == 1 && lvl ==3){
                    timerNextDrop.stop();
                    System.out.println(gv.product.getSpeed());
                    gv.product.increaseSpeed(10);
                    timer = new Timer(gv.product.getSpeed(),new DropProduct());
                    increaseNextSpeed(1500);
                    lvl++;
                }
                else if(clock.getSecond() >= 00 && clock.getMinute() == 2 && lvl ==4){
                    timerNextDrop.stop();
                    gv.product.increaseSpeed(12);
                    System.out.println(gv.product.getSpeed());
                    timer = new Timer(gv.product.getSpeed(),new DropProduct());
                    increaseNextSpeed(500);
                    lvl++;
                }
            }
            else{
                gv.product.setBounds(gv.product.getXCoordinate(),gv.product.getYCoordinate(),1300,500);
                gv.product.move();
            }
            if(gm.player.getScore()<0 || gm.player.getLife() == 0){
                gameOver();
            }
        }
    }
    
    public class TimeClass implements ActionListener {
        private int seconds;
        private int minutes;
        public TimeClass(){
            seconds = 0;
            minutes = 0;
        }
        public int getSecond(){
            return seconds;
        }
        public int getMinute(){
            return minutes;
        }
        public void actionPerformed(ActionEvent tc){
            seconds++;
            if(seconds == 60){
                seconds = 0;
                minutes += 1;
            }
            StringBuilder builder = new StringBuilder();
            builder.append("Time ");
            if(minutes < 10){
                builder.append("0");
            }
            builder.append(Integer.toString(minutes));
            builder.append(":");
            if(seconds < 10){
                builder.append("0");
            }
            builder.append(Integer.toString(seconds));
            gv.getTimeBox().setText(builder.toString());
            
         }
    }
    
    class OkBtnListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent event){
            if(gv.getEntrance().getPlayerName().getText().matches("\\w+") == false)
                JOptionPane.showMessageDialog(null, "Your name can only include "
                        + "alphanumeric character, including the underscore."
                        + "\nPlease type again.");
            else{
                if(gm.findPlayer(gv.getEntrance().getPlayerName().getText()))
                    openMainScreen();  
                else
                    JOptionPane.showMessageDialog(null, "No player is found. "
                            + "\nPlease type again or create a new one.");
            }
        }
    }
    class Register extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent event){
            if(gv.getEntrance().getPlayerName().getText().matches("\\w+") == false)
                JOptionPane.showMessageDialog(null, "Your name can only include "
                        + "alphanumeric character, including the underscore."
                        + "\nPlease type again.");
            else{
                if(gm.findPlayer(gv.getEntrance().getPlayerName().getText()))
                    JOptionPane.showMessageDialog(null, "The entered name has already been existed. "
                                + "\nPlease type another name.");
                else{
                    gm.addPlayer(gv.getEntrance().getPlayerName().getText());
                    openMainScreen();
                }
            }
        }
    }
    class HighScoreTable extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent event){
            gm.updatePlayer(gm.player.getName(), Integer.valueOf(gv.getScoreBox().getText()));
            gm.loadTopPlayers();
            for(int i = 0; i < 10; i++){
                if(gm.topPlayers[i] != null){
                    gv.getHighScore().getGrades()[i].setText(String.valueOf(i + 1));
                    gv.getHighScore().getPlayerNames()[i].setText(gm.topPlayers[i].getName());
                    gv.getHighScore().getScores()[i].setText(String.valueOf(gm.topPlayers[i].getScore()));
                } 
            }
            openHighScore();  
        }
    }
    class Restart extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent event){
            gm.updatePlayer(gm.player.getName(), Integer.valueOf(gv.getScoreBox().getText()));
            lvl = 1;
            nextSpeed = 5000;
            gv.product.setSpeed(20);
            openMainScreen();  
        }
    }
    class Quit extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent event){
            gm.updatePlayer(gm.player.getName(), 
                                Integer.valueOf(gv.getScoreBox().getText()));
            try{
                gm.closeDb();
                System.exit(0);
            }catch(Exception e){
                System.err.println(e);
                System.exit(1);
            }      
        }
    }  
}
