package ConexionBBDD.ej1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Conexion {
    private JPanel panel1;
    private JTextField direccion;
    private JTextField puerto;
    private JTextField nombre;
    private JLabel direccionLabel;
    private JLabel puertoLabel;
    private JLabel nombreLabel;
    private JLabel contraseñaLabel;
    private JButton conectar;
    private JPasswordField contraseña;

    public Conexion() {
        conectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
