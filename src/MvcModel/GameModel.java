/*
 * This is where the game data, mostly concerning with topPlayers, is stored
 */
package MvcModel;

import GameObjects.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class GameModel {
    Player player;
    Player[] topPlayers = new Player[10];
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparation;
    private final String dbURL = "jdbc:derby://localhost:1527/GamePlayer;"
                                + "create=true;user=Anonymous;password=2440";
    
    GameModel(){
        try{
            connection = DriverManager.getConnection(dbURL);
        }catch(Exception e){
            System.err.println(e);
            System.exit(1);
        }
    }

    boolean loadTopPlayers(){
        try{
            statement = connection.createStatement();
            String sql = "SELECT * FROM PLAYER ORDER BY SCORE DESC, NAME ASC";
            ResultSet result = statement.executeQuery(sql);
            int i = 0;
            while(result.next()){
                topPlayers[i] = new Player(result.getString("NAME"), 
                                        result.getInt("SCORE"), 
                                        result.getInt("LIFE"));
                i++;
                if(i == 10)
                    break;
            }
            statement.close();
            return true;
        }catch (Exception e){
            System.err.println(e);
        }
        return false;
    }
    
    boolean findPlayer(String playerName){
        try{
            statement = connection.createStatement();
            String sql = "SELECT * FROM ANONYMOUS.PLAYER WHERE NAME = '" + playerName + "'";
            ResultSet result = statement.executeQuery(sql);
            if(result.next()){
                player = new Player(result.getString("NAME"));
                System.out.println("Player Score: " + result.getInt("SCORE"));
                statement.close();
                return true;
            }
        }catch(Exception e){
            System.err.println(e);
        }
        return false;
    }
    
    boolean addPlayer (String playerName){
        try{
            statement = connection.createStatement();
            String sql = "INSERT INTO ANONYMOUS.PLAYER VALUES (?,?,?)"; 
            preparation = connection.prepareStatement(sql);
            preparation.setString(1, playerName);
            preparation.setInt(2, 0);
            preparation.setInt(3, 5);
            preparation.executeUpdate();
            player = new Player(playerName, 0, 5);
            statement.close();
            return true;
        }catch(Exception e){
            System.err.println(e);
        }
        return false;
    }
    boolean updatePlayer (String playerName, int score){
        try{
            statement = connection.createStatement();
            String sql = "UPDATE ANONYMOUS.PLAYER "
                    + "SET SCORE = ?, LIFE = ? "
                    + "WHERE NAME = '" + playerName + "'";
            preparation = connection.prepareStatement(sql);
            if(score < 0)
                preparation.setInt(1, 0);
            else
                preparation.setInt(1, score);
            preparation.setInt(2, 0);
            preparation.executeUpdate();
            System.out.println("Player Score Update: " + score);
            statement.close();
            return true;
        }catch (Exception e){
            System.err.println(e);
        }
        return false;
    }
    void closeDb() throws SQLException{
        try{
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }
        catch (Exception e){
            System.err.println(e);
        }
    }
}
