package ConexionBBDD.ModeloVCExercise.Modelo;

import ConexionBBDD.ModeloVCExercise.Controlador.Coordinador;
import ConexionBBDD.ModeloVCExercise.Modelo.conexion.Conexion;
import ConexionBBDD.ModeloVCExercise.Modelo.dao.ProductosDao;
import ConexionBBDD.ModeloVCExercise.Modelo.vo.ProductosVo;
import ConexionBBDD.ModeloVCExercise.Vista.VentanaModificar;
import ConexionBBDD.ModeloVCExercise.Vista.VentanaPrincipal;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Logica {

    private Coordinador coordinador;

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public void validarRegistro(ProductosVo productosVo) {
        ProductosDao productosDao;
        if (productosVo.getIdProducto() > 0) {
            productosDao = new ProductosDao();
            productosDao.registrarProducto(productosVo);
        } else {
            System.out.println("El ID del producto debe ser mayor que 0");
        }

    }

    public void cargarTabla(VentanaPrincipal ventanaPrincipal) {
        ProductosDao productosDao = new ProductosDao();
        productosDao.listarProductos(ventanaPrincipal);
    }

    public void cargarProductoAModificar() {
        VentanaModificar ventanaModificar = coordinador.getVentanaModificar();
        int row = coordinador.getVentanaPrincipal().table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar");
            return;
        }
        TableModel model = coordinador.getVentanaPrincipal().table1.getModel();


        ventanaModificar.IDProducto.setText(model.getValueAt(row, 0).toString());
        ventanaModificar.nombre.setText(model.getValueAt(row, 1).toString());
        ventanaModificar.idDistribuidor.setText(model.getValueAt(row, 2).toString());
        ventanaModificar.idCategoria.setText(model.getValueAt(row, 3).toString());
        ventanaModificar.cantidad.setText(model.getValueAt(row, 4).toString());
        ventanaModificar.precio.setText(model.getValueAt(row, 5).toString());
        ventanaModificar.stock.setText(model.getValueAt(row, 6).toString());
        ventanaModificar.udsOrden.setText(model.getValueAt(row, 7).toString());
        ventanaModificar.prioridadOrden.setText(model.getValueAt(row, 8).toString());
        ventanaModificar.discotinued.setText(model.getValueAt(row, 9).toString());

    }

    public void modificarProducto() {

        Conexion conn = new Conexion();

        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(
                    "UPDATE products SET ProductName=?, SupplierID=?, CategoryID=?, QuantityPerUnit=?, UnitPrice=?, UnitsInStock=?, ProductID=?");

            VentanaModificar ventanaModificar = coordinador.getVentanaModificar();
            ps.setString(1, ventanaModificar.nombre.getText());
            ps.setInt(2, Integer.parseInt(ventanaModificar.idDistribuidor.getText()));
            ps.setInt(3, Integer.parseInt(ventanaModificar.idCategoria.getText()));
            ps.setString(4, ventanaModificar.cantidad.getText());
            ps.setDouble(5, Double.parseDouble(ventanaModificar.precio.getText()));
            ps.setInt(6, Integer.parseInt(ventanaModificar.stock.getText()));
            ps.setInt(7, Integer.parseInt(ventanaModificar.IDProducto.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto modificado correctamente");
            ps.close();
            conn.desconectar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
