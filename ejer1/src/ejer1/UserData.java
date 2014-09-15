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
    
    public void crearUsuario(User user){
        userDelegate = new UserDelegate();
        try {
            userDelegate.createUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void actualizarUsuario(User user){
        userDelegate = new UserDelegate();
        try {
            userDelegate.updateUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void borrarUsuario(User user){
        userDelegate = new UserDelegate();
        try {
            userDelegate.deleteUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public LinkedList<User> buscarUsuario(String username){
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
