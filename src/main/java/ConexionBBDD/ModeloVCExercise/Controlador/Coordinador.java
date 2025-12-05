package ConexionBBDD.ModeloVCExercise.Controlador;

import ConexionBBDD.ModeloVCExercise.Modelo.Logica;
import ConexionBBDD.ModeloVCExercise.Vista.VentanaAñadir;
import ConexionBBDD.ModeloVCExercise.Vista.VentanaModificar;
import ConexionBBDD.ModeloVCExercise.Vista.VentanaPrincipal;

import javax.swing.*;

public class Coordinador {

    Logica miLogica;
    private VentanaPrincipal ventanaPrincipal;
    private VentanaModificar ventanaModificar;
    private VentanaAñadir ventanaAñadir;

    public VentanaAñadir getVentanaAñadir() {
        return ventanaAñadir;
    }

    public void setVentanaAñadir(VentanaAñadir ventanaAñadir) {
        this.ventanaAñadir = ventanaAñadir;
    }

    public VentanaPrincipal getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public VentanaModificar getVentanaModificar() {
        return ventanaModificar;
    }

    public void setVentanaModificar(VentanaModificar ventanaModificar) {
        this.ventanaModificar = ventanaModificar;
    }

    public Logica getMiLogica() {
        return miLogica;
    }

    public void setMiLogica(Logica miLogica) {
        this.miLogica = miLogica;
    }

    public void mostrarVentanaModificar() {
        JFrame frame = new JFrame("VentanaModificar");
        frame.setContentPane(ventanaModificar.ventanaModificar);
        frame.pack();
        frame.setVisible(true);
        cargarProductoAModificar();
    }

    public void mostrarVentanaAñadir() {
        JFrame frame = new JFrame("VentanaAñadir");
        frame.setContentPane(ventanaAñadir.ventanaAñadir);
        frame.pack();
        frame.setVisible(true);

    }

    public void cargarProductoAModificar() {
        miLogica.cargarProductoAModificar();
    }

    public void cargarTabla(){
        miLogica.cargarTabla(ventanaPrincipal);
    }

    public void modificarProducto() {
        miLogica.modificarProducto();
    }

    public void añadirProducto() {
        miLogica.añadirProducto();
    }


}
