/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azu.modelo.dao;

import com.azu.modelo.dto.Articulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author azu
 */
public class ArticuloDAO {
    private static final String SQL_INSERT = "insert into articulo (clave_art, "
            + "descripcion, precio, existencia) values (?,?,?,?)";
    private static final String SQL_SELECT = "select * from articulo where clave_art = ?";
    private static final String SQL_SELECT_ALL = "select * from articulo";
    private static final String SQL_UPDATE = "update articulo set descripcion = ?, "
            + "precio = ?, existencias = ? where clave_art = ?";
    private static final String SQL_DELETE = "delete from articulo where clave_art=?";
    
    public void crear(Articulo dto, Connection conn) throws SQLException{
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getClaveArticulo());
            ps.setString(2, dto.getDescripcion());
            ps.setDouble(3, dto.getPrecio());
            ps.setInt(4, dto.getExistencias());
            ps.executeUpdate();
        } finally{
            cerrar(ps);
            cerrar(conn);
        }
    }
    
    public Articulo load(Articulo dto, Connection conn) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setString(1, dto.getClaveArticulo());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if(results.size() > 0){
                return (Articulo) results.get(0);
            } else {
                return null;
            }
        } finally{
            cerrar(ps);
            cerrar(rs);
            cerrar(conn);
        }
    }
    
    public List loadAll(Connection conn) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            List results = getResults(rs);
            if(results.size() > 0){
                return results;
            } else {
                return null;
            }
        } finally{
            cerrar(ps);
            cerrar(rs);
            cerrar(conn);
        }
    }
    
    public void update(Articulo dto, Connection conn) throws SQLException{
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getDescripcion());
            ps.setDouble(2, dto.getPrecio());
            ps.setInt(3, dto.getExistencias());
            ps.setString(4, dto.getClaveArticulo());
            ps.executeUpdate();
        } finally{
            cerrar(ps);
            cerrar(conn);
        }
    }
    
    private List getResults(ResultSet rs) throws SQLException{
        return null;
    }

    private void cerrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
