package ConexionBBDD.ModeloVCExercise.Modelo.dao;

import ConexionBBDD.ModeloVCExercise.Modelo.conexion.Conexion;
import ConexionBBDD.ModeloVCExercise.Modelo.vo.ProductosVo;
import ConexionBBDD.ModeloVCExercise.Vista.VentanaModificar;
import ConexionBBDD.ModeloVCExercise.Vista.VentanaPrincipal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;


public class ProductosDao {

    public void registrarProducto(ProductosVo productosVo) {

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

    public ProductosVo buscarProducto(String nombre){

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

        if (existe) {
            return productosVo;
        } else return null;
    }

    public void listarProductos(VentanaPrincipal ventanaPrincipal) {
        Conexion conn = new Conexion();
        try (PreparedStatement ps = conn.getConnection().prepareStatement("SELECT * FROM products");
             ResultSet rs = ps.executeQuery()) {

            DefaultTableModel model = (DefaultTableModel) ventanaPrincipal.table1.getModel();
            // limpiar tabla
            model.setRowCount(0);
            model.setColumnCount(0);

            // Encabezados
            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();
            Vector<String> headers = new Vector<>();
            for (int i = 1; i <= cols; i++) {
                headers.add(meta.getColumnName(i));
            }
            model.setColumnIdentifiers(headers);

            // Filas
            int numRegistros = 0;
            while (rs.next()) {
                Vector<Object> fila = new Vector<>();
                for (int i = 1; i <= cols; i++) {
                    fila.add(rs.getObject(i));
                }
                model.addRow(fila);
                numRegistros++;
            }

            // Actualizar la vista: usar table1 si existe (probable GUI builder), sino tablaProductos
            if (ventanaPrincipal.table1 != null) ventanaPrincipal.table1.setModel(model);
            else ventanaPrincipal.table1.setModel(model);
            while (rs.next()) {
                Object[] row = new Object[] {
                        rs.getInt("ProductId"),
                        rs.getString("ProductName"),
                        rs.getInt("SupplierID"),
                        rs.getInt("CategoryID"),
                        rs.getString("QuantityPerUnit"),
                        rs.getDouble("UnitPrice"),
                        rs.getInt("UnitsInStock")
                };
                model.addRow(row);
            }
            conn.desconectar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
