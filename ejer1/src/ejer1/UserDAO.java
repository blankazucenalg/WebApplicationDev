/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejer1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author azu
 */

public class UserDAO {
    public static final String SQL_SELECT = "select * from user where idUser=?";
    public static final String SQL_SELECTALL = "select * from user";
    public static final String SQL_INSERT = "insert into user(name, lastname, surname, email, username, "
            + "password, userType) values(?,?,?,?,?,?,?)";
    public static final String SQL_UPDATE = "update user set name=?, lastname=?, surname=?, email=?, username=?,"
            + " password=?, userType=? where username like ?";
    public static final String SQL_DELETE = "delete from user where idUser=?";

    public UserDAO() {
    }
    
    public User selectUser(User user, Connection con)  throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(SQL_SELECT);
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();
            LinkedList <User> resultados = getResults(rs);
            if(resultados.size() > 0) {
                System.out.println("Se ha encontrado el usuario \n");
                resultados.get(0).toString();
                return resultados.get(0);
            }
            else {
                System.out.println("No se encuentra el usuario");
                return null;
            }
        } finally {
            if(rs != null)
                rs.close();
            if(ps != null)
                ps.close();
            if(con != null)
                con.close();
        }
    }

    public LinkedList<User> selectAll(Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(SQL_SELECTALL);
            rs = ps.executeQuery();
            LinkedList<User> resultados = getResults(rs);
            if(resultados.size() > 0) {
                showUsers(resultados);
            }
            else {
                System.out.println("No existen registros");
            }
            return resultados;
        } finally {
            if(rs != null)
                rs.close();
            if(ps != null)
                ps.close();
            if(con != null)
                con.close();
        }
    }
    
    public void insert(User user, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, user.getIdUser());
            rs = ps.executeQuery();
            LinkedList<User> resultados = getResults(rs);
            if(resultados.size() > 0) {
	    System.out.println("Ya existe un alumno asociado con ese numero de boleta.\n");
            }
            else {
                ps = con.prepareStatement(SQL_INSERT);
                ps.setString(1, user.getName());
                ps.setString(2, user.getLastname());
                ps.setString(3, user.getSurname());
                ps.setString(4, user.getEmail());
                ps.setString(5, user.getUsername());
                ps.setString(6, user.getPassword());		
                ps.setInt(7, user.getUserType());
                ps.executeUpdate();
		System.out.println("El usuario se insertó correctamente\n");
            }
        } finally {
            if(ps != null)
                ps.close();
            if(rs != null)
                rs.close();
        }
    }    

    public LinkedList delete(User user, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, user.getIdUser());
            rs = ps.executeQuery();
            LinkedList<User> resultados = getResults(rs);
            if(resultados.size() > 0) {
                System.out.println("Se ha eliminado el usuario: ");
                resultados.get(0).toString();
                ps = con.prepareStatement(SQL_DELETE);
                ps.setInt(1, user.getIdUser());
                ps.executeUpdate();
		return resultados;
            }
            else {
		System.out.println("El usuario no existe");
		return null;
	    }
        } finally {
            if(ps != null)
                ps.close();
            if(rs != null)
                rs.close();
            if(con != null)
                con.close();
        }
    }
    
    public void update(User user, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, user.getIdUser());
            rs = ps.executeQuery();
            LinkedList<User> resultados = getResults(rs);
            if(resultados.size() > 0) {
                resultados.get(0).toString();
                ps = con.prepareStatement(SQL_UPDATE);
                ps.setString(1, user.getName());
                ps.setString(2, user.getLastname());
                ps.setString(3, user.getSurname());
                ps.setString(4, user.getEmail());
                ps.setString(5, user.getUsername());
                ps.setString(5, user.getPassword());
                ps.setInt(5, user.getUserType());
                ps.executeUpdate();
		System.out.println("El usuario se ha actualizado");
            }
            else { System.out.println("El usuario " + user.getIdUser()+ " no existe"); }
        } finally {
            if(ps != null)
                ps.close();
            if(rs != null)
                rs.close();
            if(con != null)
                con.close();
        }
    }

    public LinkedList getResults(ResultSet rs) throws SQLException{
        User user;
        LinkedList <User> resultados = new LinkedList();
        while(rs.next()) {
            user = new User();
            user.setIdUser(rs.getInt("idUser"));
            user.setName(rs.getString("name"));
            user.setLastname(rs.getString("lastname"));
            user.setSurname(rs.getString("surname"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));	    
            user.setUserType(rs.getInt("userType"));
            resultados.add(user);
        }
        return resultados;
    }
    
    public void showUsers(LinkedList <User> r) {
        Iterator<User> it = r.iterator();
        User a;
        String alumno;
        while(it.hasNext()) {
            a = it.next();
            alumno = a.toString();
            System.out.println(alumno);
        }
    }
}
