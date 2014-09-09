/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejer1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azu
 */
public class UserDAO {
    private static final String SQL_INSERT = "insert into user (name,lastname,surname,email,username,password,"
            + "userType) values (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "update user set name=?,lastname=?,surname=?,email=?,username=?,password=?,"
            + "userType=? where idUser = ?";
    private static final String SQL_DELETE = "delete from user where idUser = ?";
    private static final String SQL_SELECT_ID = "select * from user where idUser = ?";
    private static final String SQL_SELECT_USERNAME = "select * from user where username = ?";
    private static final String SQL_SELECT_ALL = "select * from user";
    
    
    private static Statement statement;
    
    private static Statement createConnection() throws ClassNotFoundException{
        try{
            String driverMySQL = "com.mysql.jdbc.Driver";
            String urlDataBase = "jdbc:mysql://localhost/ejer1";
            String userDB = "root";
            String passDB = "n0m3l0s3";
            Class.forName(driverMySQL);
            Connection connection = DriverManager.getConnection(urlDataBase, userDB, passDB);
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }/* finally{
            try{
                if(statement != null){
                    statement.close();
                } if (connection != null){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } */
        return statement;
    }
    public void insertUser(User user){
        
    }
}
