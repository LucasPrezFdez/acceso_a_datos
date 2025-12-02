package ConexionBBDD.ModeloVCExercise.Modelo.dao;

import ConexionBBDD.ModeloVC.modelo.vo.PersonaVo;
import ConexionBBDD.ModeloVCExercise.Modelo.conexion.Conexion;
import ConexionBBDD.ModeloVCExercise.Modelo.vo.ProductosVo;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductosDao {

    public void registrarProducto(ProductosVo productosVo) throws SQLException {

        try {
            Conexion conn = new Conexion();

            String sql = "INSERT INTO products (ProductName,SupplierID,CategoryID,QuantityPerUnit,UnitPrice,UnitsInStock)" +
                    " VALUES ('" + productosVo.getNombre() + "','" + productosVo.getSuplierID() + "" +
                    "','" + productosVo.getCategoryID() + "','" + productosVo.getCantidadProducto() + "','" + productosVo.getPrecioUnidad()
                    + "','" + productosVo.getStock() + "";

            PreparedStatement s = conn.getConnection().prepareStatement(sql);

            s.executeQuery();
            JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
            s.close();
            conn.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se Registro");
            e.printStackTrace();
        }
    }

    public ProductosVo buscarProducto(String nombre) throws SQLException {

        Conexion conn = new Conexion();
        ProductosVo productosVo = new ProductosVo();
        boolean existe = false;

        try {
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(
                    "SELECT * from products WHERE ProductName=?");

            preparedStatement.setString(1, nombre);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                existe = true;
                productosVo.setPrecioUnidad(Integer.parseInt(rs.getString("UnitPrice")));
                productosVo.setCantidadProducto(rs.getString("QuantityPerUnit"));
                productosVo.setStock(Integer.parseInt(rs.getString("UnitsInStock")));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
