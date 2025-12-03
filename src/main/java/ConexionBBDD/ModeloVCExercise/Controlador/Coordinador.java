package ConexionBBDD.ModeloVCExercise.Controlador;

import ConexionBBDD.ModeloVCExercise.Modelo.Logica;
import ConexionBBDD.ModeloVCExercise.Vista.VentanaModificar;
import ConexionBBDD.ModeloVCExercise.Vista.VentanaPrincipal;

import javax.swing.*;

public class Coordinador {

    Logica miLogica;
    private VentanaPrincipal ventanaPrincipal;
    private VentanaModificar ventanaModificar;

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

    public void mostrarVentanaModificar( ) {
        JFrame frame = new JFrame("VentanaModificar");
        frame.setContentPane(new VentanaModificar().ventanaModificar);
        frame.pack();
        frame.setVisible(true);
        cargarProductoAModificar();
    }

    public void cargarProductoAModificar() {
        miLogica.cargarProductoAModificar();
    }

    public void cargarTabla(){
        miLogica.cargarTabla(ventanaPrincipal);
    }


}
