package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/agenda_db";
    private static final String USUARIO = "root";
    private static final String PASS = "ADMIN";

    public static Connection obtenerConexion() throws SQLException{
        return DriverManager.getConnection(URL,USUARIO,PASS);
    }
 }
