package Ficheros.ej1real;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ej1 {
    private JTextField textField1;
    private JTextField textField2;
    private JButton añadirButton;
    private JTextArea textArea1;
    private JButton crearButton;
    private JButton closeButton;
    private JPanel panel;

    public ej1() {
        añadirButton.addActionListener(e -> {
            try {
                int valor = Integer.parseInt(textField1.getText());
                int frecuencia = Integer.parseInt(textField2.getText());
                textArea1.append(valor + " " + frecuencia + "\n");
                textField1.setText("");
                textField2.setText("");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        crearButton.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setDialogTitle("Escoja un fichero");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
            jFileChooser.setFileFilter(filter);

            int result = jFileChooser.showSaveDialog(panel);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selected = jFileChooser.getSelectedFile();

                String path = selected.getAbsolutePath();
                if (!path.toLowerCase().endsWith(".txt")) {
                    selected = new File(path + ".txt");
                }

                try (FileWriter fw = new FileWriter(selected)) {
                    fw.write(textArea1.getText());

                    JOptionPane.showMessageDialog(panel, "Archivo creado correctamente: " + selected.getName());
                    textArea1.setText("");
                    textField1.setText("");
                    textField2.setText("");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(panel, "Error al crear el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        closeButton.addActionListener(e-> {
            Window w = SwingUtilities.getWindowAncestor(panel);
            w.dispose();
        });

    }

    public JPanel getPanel() {
        return panel;
    }
}
