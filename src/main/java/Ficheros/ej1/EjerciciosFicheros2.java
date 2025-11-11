package Ficheros.ej1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class EjerciciosFicheros2 {
    private JPanel panel1;
    private JButton elegirNombreYCaminoButton;

    public EjerciciosFicheros2() {
        elegirNombreYCaminoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setDialogTitle("Crear archivo");

                int result = jFileChooser.showSaveDialog(panel1);
                if (result == JFileChooser.APPROVE_OPTION) {


                    File archivo = jFileChooser.getSelectedFile();
                    JFrame frame = new JFrame();
                    // pasar el archivo seleccionado al segundo panel
                    panel2 gui = new panel2(archivo);
                    frame.setContentPane(gui.getPanel2());
                    // no cerrar toda la app al cerrar este frame
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    // La escritura se realizará desde el panel2 cuando el usuario pulse el botón "Crear"
                } else {
                    // El usuario canceló la operación
                    JOptionPane.showMessageDialog(panel1, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }




            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
