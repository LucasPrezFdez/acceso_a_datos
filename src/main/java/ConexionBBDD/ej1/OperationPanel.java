package ConexionBBDD.ej1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.io.*;
import java.util.Vector;

public class OperationPanel extends JFrame {
    private final JTable tablaProductos = new JTable();
    private final DefaultTableModel modeloTabla = new DefaultTableModel();
    private final Connection conn;

    private JPanel panelOperaciones;
    private JButton importarButton;
    private JButton cargarTablaButton;
    private JTable table1;
    private JScrollPane resultadoConsulta;
    private JButton exportarButton;

    public OperationPanel(Connection conn) {
        super("Gestión de Productos Northwind");
        this.conn = conn;



        // Botón para mostrar todos los productos
        cargarTablaButton.addActionListener(e -> { e.getActionCommand(); mostrarProductos(); });

        // Botón para exportar todos los productos a fichero
        exportarButton.addActionListener(e -> { e.getActionCommand(); exportarProductos(); });

        // Botón para importar productos desde un fichero
        importarButton.addActionListener(e -> { e.getActionCommand(); importarProductos(); });
    }

    private void mostrarProductos() {
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Conexión no disponible.");
            return;
        }

        try (Statement st = conn.createStatement()) {
            // cambiar de base de datos si es necesario
            try {
                st.executeUpdate("USE Northwind");
            } catch (SQLException ignore) {
                // ignorar si no aplica o si la conexión ya está en la BD correcta
            }

            try (ResultSet rs = st.executeQuery("SELECT * FROM products")) {
                // Limpiar el modelo de tabla
                modeloTabla.setRowCount(0);
                modeloTabla.setColumnCount(0);

                // Encabezados
                ResultSetMetaData meta = rs.getMetaData();
                int cols = meta.getColumnCount();
                Vector<String> headers = new Vector<>();
                for (int i = 1; i <= cols; i++) {
                    headers.add(meta.getColumnName(i));
                }
                modeloTabla.setColumnIdentifiers(headers);

                // Filas
                int numRegistros = 0;
                while (rs.next()) {
                    Vector<Object> fila = new Vector<>();
                    for (int i = 1; i <= cols; i++) {
                        fila.add(rs.getObject(i));
                    }
                    modeloTabla.addRow(fila);
                    numRegistros++;
                }

                // Actualizar la vista: usar table1 si existe (probable GUI builder), sino tablaProductos
                if (table1 != null) table1.setModel(modeloTabla);
                else tablaProductos.setModel(modeloTabla);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al mostrar productos: " + ex.getMessage());
        }
    }

    private void exportarProductos() {
        JFileChooser chooser = new JFileChooser();
        int resultado = chooser.showSaveDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File fichero = chooser.getSelectedFile();
            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM products");
                 BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {

                ResultSetMetaData meta = rs.getMetaData();
                int cols = meta.getColumnCount();

                // Encabezados CSV
                for (int i = 1; i <= cols; i++) {
                    bw.write(meta.getColumnName(i));
                    if (i < cols) bw.write(",");
                }
                bw.newLine();

                int numExportados = 0;
                while (rs.next()) {
                    for (int i = 1; i <= cols; i++) {
                        bw.write(rs.getString(i) != null ? rs.getString(i) : "");
                        if (i < cols) bw.write(",");
                    }
                    bw.newLine();
                    numExportados++;
                }
                JOptionPane.showMessageDialog(this, "SE HAN EXPORTADO " + numExportados + " REGISTROS.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al exportar: " + ex.getMessage());
            }
        }
    }

    private void importarProductos() {
        JFileChooser chooser = new JFileChooser();
        int resultado = chooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File fichero = chooser.getSelectedFile();
            int numImportados = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
                // Leer encabezado para identificar el orden
                String encabezado = br.readLine();
                if (encabezado == null) throw new IOException("Fichero vacío");

                // Asume inserción comenzando por la segunda línea
                String linea;
                conn.setAutoCommit(false); // Mejorar rendimiento
                PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO products VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
                );
                while ((linea = br.readLine()) != null) {
                    String[] datos = linea.split(",");
                    for (int i = 0; i < datos.length; i++) {
                        ps.setString(i + 1, datos[i]);
                    }
                    ps.executeUpdate();
                    numImportados++;
                }
                conn.commit();
                JOptionPane.showMessageDialog(this, "SE HAN IMPORTADO " + numImportados + " REGISTROS.");
                mostrarProductos(); // Refrescar tabla
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al importar: " + ex.getMessage());
                try { conn.rollback(); } catch (SQLException ignored) {}
            } finally {
                try { conn.setAutoCommit(true); } catch (SQLException ignored) {}
            }
        }
    }

    public JPanel getPanelOperaciones() {
        return panelOperaciones;
    }
}