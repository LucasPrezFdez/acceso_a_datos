package Ficheros.ej2;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class VentanaFichero {
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton exitButton;
    private JPanel panel;

    public VentanaFichero(File archivo) {

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            textArea1.setText(sb.toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        textField1.setText(archivo.getAbsolutePath());
        exitButton.addActionListener(e -> {
            Window w = SwingUtilities.getWindowAncestor(panel);
            w.dispose();
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
