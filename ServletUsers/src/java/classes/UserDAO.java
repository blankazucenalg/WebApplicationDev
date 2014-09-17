/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

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
    public static final String SQL_SELECT_ID = "select * from user where idUser = ?";
    public static final String SQL_SELECT_USERNAME = "select * from user where username = ?";
    public static final String SQL_SEARCH = "select * from user where username like ? or name like ?"
            + " or lastname like ? or surname like ? or email like ?";
    public static final String SQL_LOGIN = "select * from user where username=? and password=?";
    public static final String SQL_SELECTALL = "select * from user";
    public static final String SQL_INSERT = "insert into user(name, lastname, surname, email, username, "
            + "password, userType) values(?,?,?,?,?,?,?)";
    public static final String SQL_UPDATE = "update user set name=?, lastname=?, surname=?, email=?, username=?,"
            + " password=?, userType=? where idUser = ?";
    public static final String SQL_DELETE = "delete from user where idUser=?";

    public UserDAO() {
    }
    
    public LinkedList<User> selectUserByUsername(User user, Connection con)  throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(SQL_SELECT_USERNAME);
            ps.setString(1, "%"+user.getUsername()+"%");
            rs = ps.executeQuery();
            LinkedList <User> resultados = getResults(rs);
            if(resultados.size() > 0) {
                System.out.println("Se ha encontrado el usuario \n");
                resultados.get(0).toString();
                return resultados;
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
    public User selectUserById(int idUser, Connection con)  throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(SQL_SELECT_ID);
            ps.setInt(1, idUser);
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
            ps = con.prepareStatement(SQL_SELECT_USERNAME);
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();
            LinkedList<User> resultados = getResults(rs);
            if(resultados.size() > 0) {
	    System.out.println("Ya existe un usuario con ese username\n");
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
		System.out.println("El usuario "+user+"se insertó correctamente\n");
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
            ps = con.prepareStatement(SQL_SELECT_ID);
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
    
    public int update(User user, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(SQL_SELECT_ID);
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
                ps.setString(6, user.getPassword());
                ps.setInt(7, user.getUserType());
                ps.setInt(8, user.getIdUser());
                ps.executeUpdate();
		System.out.println("El usuario se ha actualizado");
                return 0;
            }
            else { 
                System.out.println("El usuario " + user.getIdUser()+ " no existe"); 
                return 1;
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

    public boolean login(User user, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(SQL_LOGIN);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            LinkedList <User> resultados = getResults(rs);
            if(resultados.size() > 0) {
                System.out.println("Se ha encontrado el usuario \n");
                resultados.get(0).toString();
                return true;
            }
            else {
                System.out.println("No se encuentra el usuario");
                return false;
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

    LinkedList<User> searchUser(String search, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(SQL_SEARCH);
            ps.setString(1, "%"+search+"%");
            ps.setString(2, "%"+search+"%");
            ps.setString(3, "%"+search+"%");
            ps.setString(4, "%"+search+"%");
            ps.setString(5, "%"+search+"%");
            rs = ps.executeQuery();
            LinkedList <User> resultados = getResults(rs);
            if(resultados.size() > 0) {
                System.out.println("Se ha encontrado el usuario \n");
                resultados.get(0).toString();
                return resultados;
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
}
