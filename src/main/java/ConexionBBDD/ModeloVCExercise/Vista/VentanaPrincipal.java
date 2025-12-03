package ConexionBBDD.ModeloVCExercise.Vista;

import ConexionBBDD.ModeloVCExercise.Controlador.Coordinador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal{


    public JTable table1;
    public JPanel ventanaPrincipal;
    private JButton modificarButton;
    private JButton añadirButton;

    public Coordinador miCoordinador;

    public void setMiCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    public VentanaPrincipal() {
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                miCoordinador.mostrarVentanaModificar();
                //miCoordinador.cargarTabla();
            }
        });
    }


}


