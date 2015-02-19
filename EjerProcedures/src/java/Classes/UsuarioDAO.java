/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author azu
 */
public class UsuarioDAO {
    private static final String SQL_INSERT="insert into user (name, lastname, mLastname, birthday, email, password, phone) values(?,?,?,?,?,?,?)";
    private static final String SQL_DELETE="delete from user where idUser = ?";
    private static final String SQL_UPDATE="update user set name=?, lastname=?, mLastname=?, birthday=?, email=?, password=?, phone=? where idUser=?";
    private static final String SQL_SELECT = "select * from user where idUser=?";
    private static final String SQL_SELECT_ALL = "select * from user";
    
    public void create(String name, String lastname, String mLastname, Date birthday, String email, String password, String phone){
        
    }
}
