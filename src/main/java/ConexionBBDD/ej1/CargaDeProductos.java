package ConexionBBDD.ej1;

import java.sql.*;

public class CargaDeProductos {

    public static void main(String[] args) {

        String conn = "jdbc:mysql://localhost:3306/northwind";
        String root = "root";
        String pass = "";
        try {
            Connection connection = DriverManager.getConnection(conn, root, pass);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM products ");
            ResultSetMetaData rsmd = rs.getMetaData();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
