package Ficheros.ej1;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class panel2 {
    JFrame frame;
    private JTextField textoAIntroducir;
    private JButton crearButton;
    private JPanel panel2;
    private File archivo;

    public panel2(File archivo) {
        this.archivo = archivo;
        crearButton.addActionListener(e -> {
            if (this.archivo == null) {
                JOptionPane.showMessageDialog(panel2,
                        "No se ha seleccionado ningún archivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String texto = textoAIntroducir.getText();
            try (FileWriter writer = new FileWriter(this.archivo, true)) {
                writer.write(texto);
                writer.write(System.lineSeparator());
                JOptionPane.showMessageDialog(panel2,
                        "Texto guardado correctamente en:\n" + this.archivo.getAbsolutePath());

                Window w = SwingUtilities.getWindowAncestor(panel2);
                w.dispose();

            } catch (IOException err) {
                JOptionPane.showMessageDialog(panel2,
                        "Error al guardar el archivo:\n" + err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public JPanel getPanel2() {
        return panel2;
    }
}