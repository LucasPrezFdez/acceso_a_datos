package ConexionBBDD.ej1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class OperationPanel {
    private JPanel panelOperaciones;
    private JButton button1;
    private JButton button2;
    private JTable table1;
    private JScrollPane resultadoConsulta;


    public OperationPanel(Connection connection, Statement st) {

        cargarTabla(table1, connection);


        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoConsulta.setVisible(true);
                int columnas;
                ResultSetMetaData meta;
                ResultSet rs;

                try {
                    rs = st.executeQuery("SELECT * from TABLE ( Products )");
                    meta = rs.getMetaData();
                    columnas = meta.getColumnCount();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                DefaultTableModel modelo = new DefaultTableModel();

                for (int i = 1; i <= columnas; i++) {
                    try {
                        modelo.addColumn(meta.getColumnName(i));
                        while (rs.next()) {
                            Object[] fila = new Object[columnas];

                            for (int j = 1; j <= columnas; j++) {
                                fila[j - 1] = rs.getObject(j);
                            }

                            modelo.addRow(fila);
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                table1 = new JTable(modelo);

                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File archivo = fileChooser.getSelectedFile();
                    importarCSV(archivo, modelo);
                }

            }
        });
    }


    public JPanel getPanelOperaciones() {
        return panelOperaciones;
    }

    public void importarCSV(File archivo, DefaultTableModel modelo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                // divide cada línea por comas
                String[] datos = linea.split(",");

                // asegúrate de que tenga 10 columnas
                if (datos.length == 10) {
                    modelo.addRow(datos);
                }
            }

            JOptionPane.showMessageDialog(panelOperaciones,"Importación exitosa.");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al importar el archivo.");
        }
    }

    public void cargarTabla(JTable tabla, Connection conn) {
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);

        try {

            String sql = "SELECT * FROM Products";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // ----------------------------
            // 1️⃣ Obtener nombres de columnas
            // ----------------------------
            ResultSetMetaData meta = rs.getMetaData();
            int columnas = meta.getColumnCount();

            for (int i = 1; i <= columnas; i++) {
                modelo.addColumn(meta.getColumnName(i));
            }

            // ----------------------------
            // 2️⃣ Agregar filas dinámicamente
            // ----------------------------
            while (rs.next()) {
                Object[] fila = new Object[columnas];

                for (int i = 1; i <= columnas; i++) {
                    fila[i - 1] = rs.getObject(i);
                }

                modelo.addRow(fila);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error cargando datos de la base de datos.");
        }
    }


}
