package ConexionBBDD.ModeloVCExercise.Modelo;

import ConexionBBDD.ModeloVCExercise.Controlador.Coordinador;
import ConexionBBDD.ModeloVCExercise.Modelo.dao.ProductosDao;
import ConexionBBDD.ModeloVCExercise.Modelo.vo.ProductosVo;
import ConexionBBDD.ModeloVCExercise.Vista.VentanaPrincipal;

import javax.swing.*;


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

        int cols = coordinador.getVentanaPrincipal().table1.getColumnCount();
        String[] datos = new String[cols];
        for (int c = 0; c < cols; c++) {
            Object val = coordinador.getVentanaPrincipal().table1.getValueAt(row, c);
            datos[c] = val != null ? val.toString() : "";
        }


    }
}
