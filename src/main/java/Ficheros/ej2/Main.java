package Ficheros.ej2;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        ej2 ej2 = new ej2();
        JFrame frame = new JFrame();
        frame.setContentPane(ej2.getPanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
