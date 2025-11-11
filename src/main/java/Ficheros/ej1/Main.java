package Ficheros.ej1;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

            JFrame frame = new JFrame();
            EjerciciosFicheros2 gui = new EjerciciosFicheros2();
            frame.setContentPane(gui.getPanel1());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

    }
}
