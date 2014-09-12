/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejer1;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azu
 */
public class UserData {
    private UserDelegate userDelegate;
    
    public void crearUsuario(String name, String lastname, String surname, String email, String username,
            String password, int userType){
        User user = new User();
        user.setName(name);
        user.setLastname(lastname);
        user.setSurname(surname);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setUserType(userType);
        userDelegate = new UserDelegate();
        try {
            userDelegate.createUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void actualizarUsuario(int IdUser, String name, String lastname, String surname, String email, String username,
            String password, int userType){
        User user = new User();
        user.setIdUser(IdUser);
        user.setName(name);
        user.setLastname(lastname);
        user.setSurname(surname);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setUserType(userType);
        userDelegate = new UserDelegate();
        try {
            userDelegate.updateUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void borrarUsuario(int idUser, String name, String lastname, String surname, String email, String username,
            String password, int userType){
        User user = new User();
        user.setIdUser(idUser);
        user.setName(name);
        user.setLastname(lastname);
        user.setSurname(surname);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setUserType(userType);
        userDelegate = new UserDelegate();
        try {
            userDelegate.deleteUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public User buscarUsuario(String username){
        User user = new User();
        user.setUsername(username);
        userDelegate = new UserDelegate();
        try {
            return userDelegate.selectUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public LinkedList<User> seleccionarUsuarios(){
        userDelegate = new UserDelegate();
        try {
            return userDelegate.selectAllUsers();
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
