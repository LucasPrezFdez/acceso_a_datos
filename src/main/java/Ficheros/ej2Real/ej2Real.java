package Ficheros.ej2Real;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ej2Real {
    private JPanel panel;
    private JButton elegirNombreYCaminoButton;

    public ej2Real() {
        elegirNombreYCaminoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setDialogTitle("Escoja un fichero");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
                jFileChooser.setFileFilter(filter);

                int result = jFileChooser.showSaveDialog(panel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selected = jFileChooser.getSelectedFile();

                    double sum = 0.0;
                    long count = 0;
                    double weightedSum = 0.0;
                    double weightSum = 0.0;

                    try (BufferedReader br = new BufferedReader(new FileReader(selected))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            line = line.trim();
                            if (line.isEmpty() || line.startsWith("#")) continue; // ignorar líneas vacías o comentarios

                            // admitir separadores: espacios, tabuladores o comas
                            String[] parts = line.split("[,\\s]+");
                            if (parts.length < 1) continue;

                            try {
                                double value = Double.parseDouble(parts[0]);
                                double weight = 1.0;
                                if (parts.length >= 2) {
                                    weight = Double.parseDouble(parts[1]);
                                }

                                sum += value;
                                count++;
                                weightedSum += value * weight;
                                weightSum += weight;
                            } catch (NumberFormatException nfe) {
                                // ignorar línea con formato incorrecto
                            }
                        }
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(panel, "Error leyendo el fichero:\n" + ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (count == 0) {
                        JOptionPane.showMessageDialog(panel, "No se han leído números válidos en la primera columna.",
                                "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    double arithmeticMean = sum / count;
                    String weightedMeanStr;
                    if (weightSum == 0.0) {
                        weightedMeanStr = "No hay pesos (suma de pesos = 0)";
                    } else {
                        double weightedMean = weightedSum / weightSum;
                        weightedMeanStr = String.format("%.6f", weightedMean);
                    }

                    String message = String.format("Media aritmética (primera columna): %.6f%nMedia ponderada usando 2ª columna: %s",
                            arithmeticMean, weightedMeanStr);

                    JOptionPane.showMessageDialog(panel, message, "Resultados", JOptionPane.INFORMATION_MESSAGE);
                }


            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
