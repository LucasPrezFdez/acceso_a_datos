package Ficheros.ej1real;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        ej1 ej1 = new ej1();
        JFrame frame = new JFrame();
        frame.setContentPane(ej1.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
