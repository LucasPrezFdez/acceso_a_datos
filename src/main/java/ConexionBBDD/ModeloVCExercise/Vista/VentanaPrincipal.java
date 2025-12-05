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
    private JButton buscarButton;
    public JTextField serched;

    public Coordinador miCoordinador;

    public void setMiCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    public VentanaPrincipal() {
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = table1.getSelectedRow();
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Selecciona un elemento primero");
                    return;
                }
                miCoordinador.mostrarVentanaModificar();
            }
        });
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.mostrarVentanaAñadir();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiLogica().buscarProducto();
            }
        });

    }


}


