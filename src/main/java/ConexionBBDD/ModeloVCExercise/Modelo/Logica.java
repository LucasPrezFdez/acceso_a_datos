package ConexionBBDD.ModeloVCExercise.Modelo;

import ConexionBBDD.ModeloVCExercise.Controlador.Coordinador;
import ConexionBBDD.ModeloVCExercise.Modelo.dao.ProductosDao;
import ConexionBBDD.ModeloVCExercise.Modelo.vo.ProductosVo;
import ConexionBBDD.ModeloVCExercise.Vista.VentanaPrincipal;


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
}
