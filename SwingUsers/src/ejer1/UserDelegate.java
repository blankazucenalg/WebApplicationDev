/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejer1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author azu
 */
public class UserDelegate {
    private Connection connection;
    private final UserDAO userDao;
    
    public UserDelegate() {
        String user = "root";
        String password = "n0m3l0s3";
        String driver = "com.mysql.jdbc.Driver";
        String database = "jdbc:mysql://localhost/ejer1";
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException c) {
            System.out.println("No se ha encontrado el controlador");
        }
        try {
            System.out.println("Conectando a la base de datos...");
            connection = DriverManager.getConnection(database, user, password);
            System.out.println("Conexion exitosa");
        } catch (SQLException s) {
            System.out.println("Error en la conexion");
        }
        userDao = new UserDAO();
        
        System.out.println("\n" + "*************************" + "\n");
    }
    
    public LinkedList<User> selectUser(User user) throws SQLException {
        System.out.println("Select user from database");
        return userDao.selectUser(user, connection);
    }
    
    public LinkedList<User> selectAllUsers() throws SQLException {
        System.out.println("Select all users");
        return userDao.selectAll(connection);
    }
    
    public void createUser(User user) throws SQLException {
        System.out.println("Insert a user");
        userDao.insert(user, connection);
    }
    
    public void deleteUser(User user) throws SQLException {
        System.out.println("Delete user");
        userDao.delete(user,connection);
    }

    public void updateUser(User user) throws SQLException {
        System.out.println("Update user");
        userDao.update(user, connection);
    }
}
