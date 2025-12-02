package ConexionBBDD.ModeloVCExercise.Modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    static String bd = "Northwind";
    static String user = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/"+bd;

    Connection conn = null;

    public Conexion() {

        try {
            conn = DriverManager.getConnection(url,user,password);

            if (conn != null){
                System.out.println("Conexion OK");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Connection getConnection() {
        return conn;
    }

    public void desconectar() {
        conn = null;
        
    }
}
