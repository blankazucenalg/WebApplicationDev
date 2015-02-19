/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author azu
 */
public class Conexion {
    private Connection connection;

    public Conexion() {
        String user = "root";
        String password = "n0m3l0s3";
        String driver = "com.mysql.jdbc.Driver";
        String database = "jdbc:mysql://localhost/bank";
        
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
        
        System.out.println("\n" + "*************************" + "\n");
    }

    public Connection getConnection() {
        return connection;
    }
    
}
