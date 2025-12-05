package ConexionBBDD.ModeloVCExercise.Vista;

import ConexionBBDD.ModeloVCExercise.Controlador.Coordinador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAñadir {
    public JPanel ventanaAñadir;
    public JTextField nombre;
    public JTextField categoryID;
    public JTextField quantityPerUnit;
    public JTextField unitPrice;
    public JTextField unitsInStock;
    private JButton rechazarButton;
    private JButton aceptarButton;
    Coordinador coordinador;

    public VentanaAñadir() {
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (coordinador != null) {
                    coordinador.añadirProducto();
                } else {
                    JOptionPane.showMessageDialog(null, "Coordinador no inicializado. Imposible añadir producto.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        rechazarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (coordinador != null) {
                    VentanaAñadir ventana = coordinador.getVentanaAñadir();
                    // Cerrar la ventana actual
                    SwingUtilities.getWindowAncestor(ventana.ventanaAñadir).dispose();
                } else {
                    // Si no hay coordinador, intentar cerrar la ventana actual directamente
                    SwingUtilities.getWindowAncestor(ventanaAñadir).dispose();
                }
            }
        });
    }

    // Setter para inyectar el Coordinador y establecer la relación
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    // Setter alternativo consistente con otras ventanas (setMiCoordinador)
    public void setMiCoordinador(Coordinador miCoordinador) {
        this.coordinador = miCoordinador;
    }
}
