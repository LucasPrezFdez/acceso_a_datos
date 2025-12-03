package ConexionBBDD.ModeloVCExercise.Modelo;

import ConexionBBDD.ModeloVCExercise.Controlador.Coordinador;
import ConexionBBDD.ModeloVCExercise.Modelo.dao.ProductosDao;
import ConexionBBDD.ModeloVCExercise.Modelo.vo.ProductosVo;
import ConexionBBDD.ModeloVCExercise.Vista.VentanaModificar;
import ConexionBBDD.ModeloVCExercise.Vista.VentanaPrincipal;

import javax.swing.*;
import javax.swing.table.TableModel;


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



        ventanaModificar.IDProducto.setText(model.getValueAt(row,0).toString());
        ventanaModificar.nombre.setText(model.getValueAt(row,1).toString());
        ventanaModificar.idDistribuidor.setText(model.getValueAt(row,2).toString());
        ventanaModificar.idCategoria.setText(model.getValueAt(row,3).toString());
        ventanaModificar.cantidad.setText(model.getValueAt(row,4).toString());
        ventanaModificar.precio.setText(model.getValueAt(row,5).toString());
        ventanaModificar.stock.setText(model.getValueAt(row,6).toString());
        ventanaModificar.udsOrden.setText(model.getValueAt(row,7).toString());
        ventanaModificar.prioridadOrden.setText(model.getValueAt(row,8).toString());
        ventanaModificar.discotinued.setText(model.getValueAt(row,9).toString());

    }

    public void modificarProducto() {
        productosDao.modificarProducto();
    }
}
