package Ficheros.ej2Real;

import javax.swing.*;

public class Main2 {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        ej2Real gui = new ej2Real();
        frame.setContentPane(gui.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}
