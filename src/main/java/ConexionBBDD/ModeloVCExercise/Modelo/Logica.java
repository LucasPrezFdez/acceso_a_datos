package ConexionBBDD.ModeloVCExercise.Modelo;

import ConexionBBDD.ModeloVCExercise.Controlador.Coordinador;
import ConexionBBDD.ModeloVCExercise.Modelo.dao.ProductosDao;
import ConexionBBDD.ModeloVCExercise.Modelo.vo.ProductosVo;
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
        int row = coordinador.getVentanaPrincipal().table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar");
            return;
        }

        TableModel model = coordinador.getVentanaPrincipal().table1.getModel();

        coordinador.getVentanaModificar().IDProducto.setText(model.getValueAt(row,0).toString());
        coordinador.getVentanaModificar().nombre.setText(model.getValueAt(row,1).toString());
        coordinador.getVentanaModificar().idDistribuidor.setText(model.getValueAt(row,2).toString());
        coordinador.getVentanaModificar().idCategoria.setText(model.getValueAt(row,3).toString());
        coordinador.getVentanaModificar().cantidad.setText(model.getValueAt(row,4).toString());
        coordinador.getVentanaModificar().precio.setText(model.getValueAt(row,5).toString());
        coordinador.getVentanaModificar().stock.setText(model.getValueAt(row,6).toString());
        coordinador.getVentanaModificar().udsOrden.setText(model.getValueAt(row,7).toString());
        coordinador.getVentanaModificar().prioridadOrden.setText(model.getValueAt(row,8).toString());
        coordinador.getVentanaModificar().discotinued.setText(model.getValueAt(row,9).toString());

    }
}
