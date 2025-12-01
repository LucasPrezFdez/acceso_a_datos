package ConexionBBDD.ej1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

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
                boolean direccionOk = direccion.getText() != null && !direccion.getText().isEmpty();
                boolean puertoVacio = puerto.getText() != null && !puerto.getText().isEmpty();
                String puertoText = puerto.getText();
                boolean puertoOk = false;
                int puertoNum;
                boolean nombreOk = nombre.getText() != null && !nombre.getText().isEmpty();
                boolean contraseñaOk = contraseña.getPassword() != null && contraseña.getPassword().length > 0;

                    if (puertoVacio) {
                        try {
                            puertoNum = Integer.parseInt(puertoText);
                            puertoOk = true;
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(panel1, "El puerto debe ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
                            puerto.setText("");
                            return;
                        }
                    }

                if (direccionOk && puertoOk && nombreOk ) {

                    String conn = "jdbc:mysql://"+direccion.getText()+":"+puerto.getText()+"/";
                    String pass = "";
                    if (contraseñaOk) {
                        pass = Arrays.toString(contraseña.getPassword());
                    }
                    try {
                        Connection connection = DriverManager.getConnection
                                (conn, nombre.getText(),pass );


                        JFrame frame = new JFrame("Conexion");
                        frame.setContentPane(new OperationPanel(connection).getPanelOperaciones());
                        frame.pack();
                        frame.setVisible(true);



                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    // Aquí va la lógica de conexión real
                } else {
                    JOptionPane.showMessageDialog(panel1, "Rellene todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Conexion");
        frame.setContentPane(new Conexion().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
