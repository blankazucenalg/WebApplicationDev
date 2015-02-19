/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Cuenta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author azu
 */
public class CuentaDAO {
    private static final String SQL_INSERT = "{call crearCuenta(?)}";
    private static final String SQL_DELETE = "{call eliminarCuenta(?)}";
    private static final String SQL_SELECT = "{call mostrarCuenta(?)}";
    private static final String SQL_UPDATE = "{call actualizarCuenta(?,?)}";
    private static final String SQL_SELECT_ALL = "{call mostrarCuentas()}";
    
    public void create(Cuenta c) throws Exception{
        CallableStatement cs = null;
	try(Connection con = new Conexion().getConnection()) {
	cs = con.prepareCall(SQL_INSERT);
	cs.setDouble(1,c.getBalance());
	cs.executeUpdate();
	}
    }
    public void delete(Cuenta c) throws Exception{
        CallableStatement cs = null;
	try(Connection con = new Conexion().getConnection()) {
	cs = con.prepareCall(SQL_DELETE);
	cs.setInt(1,c.getIdCuenta());
	cs.executeUpdate();
	}
    }
    public void show(Cuenta c) throws Exception{
        CallableStatement cs = null;
        ResultSet rs = null;
	try(Connection con = new Conexion().getConnection()) {
	cs = con.prepareCall(SQL_SELECT);
	cs.setInt(1,c.getIdCuenta());
	rs = cs.executeQuery();
	}
    }
    public void update(Cuenta c) throws Exception{
        CallableStatement cs = null;
	try(Connection con = new Conexion().getConnection()) {
	cs = con.prepareCall(SQL_UPDATE);
	cs.setInt(1,c.getIdCuenta());
	cs.setDouble(2,c.getBalance());
	cs.executeUpdate();
	}
    }
    public void showAll(Cuenta c) throws Exception{
        CallableStatement cs = null;
        ResultSet rs = null;
	try(Connection con = new Conexion().getConnection()) {
	cs = con.prepareCall(SQL_SELECT_ALL);
	rs = cs.executeQuery();
	}
    }
}
