package Ficheros.ej2;

import Ficheros.ej1.panel2;
import org.w3c.dom.events.EventException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ej2 {
    private JButton elegirNombreYCaminoButton;
    private JPanel panelPrincipal;

    public ej2() {
        elegirNombreYCaminoButton.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setDialogTitle("Escoja un fichero");

            int result = jFileChooser.showSaveDialog(panelPrincipal);
            if (result == JFileChooser.APPROVE_OPTION) {

                File archivo = jFileChooser.getSelectedFile();
                JFrame frame = new JFrame();
                // pasar el archivo seleccionado al segundo panel
                VentanaFichero gui = new VentanaFichero(archivo);
                frame.setContentPane(gui.getPanel());
                // no cerrar toda la app al cerrar este frame
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // La escritura se realizará desde el panel2 cuando el usuario pulse el botón "Crear"
            } else {
                // El usuario canceló la operación
                JOptionPane.showMessageDialog(panelPrincipal, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }


        });
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
