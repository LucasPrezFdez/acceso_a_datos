package ConexionBBDD.ModeloVCExercise.Controlador;

import ConexionBBDD.ModeloVCExercise.Modelo.Logica;
import ConexionBBDD.ModeloVCExercise.Vista.VentanaAñadir;
import ConexionBBDD.ModeloVCExercise.Vista.VentanaModificar;
import ConexionBBDD.ModeloVCExercise.Vista.VentanaPrincipal;

import javax.swing.*;

public class Principal {

    Logica miLogica;
    Coordinador miCoordinador;
    VentanaPrincipal ventanaPrincipal;
    VentanaModificar ventanaModificar;
    VentanaAñadir ventanaAñadir;

    private void inicio() {

        miLogica = new Logica();
        miCoordinador = new Coordinador();
        ventanaModificar = new VentanaModificar();
        ventanaPrincipal = new VentanaPrincipal();
        ventanaAñadir = new VentanaAñadir();

        ventanaPrincipal.setMiCoordinador(miCoordinador);
        ventanaModificar.setMiCoordinador(miCoordinador);
        ventanaAñadir.setMiCoordinador(miCoordinador);
        miLogica.setCoordinador(miCoordinador);

        /*Se establecen relaciones con la clase coordinador*/
        miCoordinador.setVentanaPrincipal(ventanaPrincipal);
        miCoordinador.setVentanaModificar(ventanaModificar);
        miCoordinador.setVentanaAñadir(ventanaAñadir);
        miCoordinador.setMiLogica(miLogica);

        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(ventanaPrincipal.ventanaPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        miCoordinador.cargarTabla();
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.inicio();
    }

}
