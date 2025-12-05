package ConexionBBDD.ModeloVCExercise.Vista;

import ConexionBBDD.ModeloVCExercise.Controlador.Coordinador;
import ConexionBBDD.ModeloVCExercise.Modelo.conexion.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaModificar{


    public Coordinador miCoordinador;
    public JPanel ventanaModificar;
    public JTextField IDProducto;
    public JTextField nombre;
    public JTextField idDistribuidor;
    public JTextField idCategoria;
    public JTextField cantidad;
    public JTextField precio;
    public JTextField stock;
    public JTextField udsOrden;
    public JTextField prioridadOrden;
    public JTextField discotinued;
    private JButton rechazarButton;
    private JButton aceptarButton;

    public VentanaModificar() {
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.modificarProducto();
                miCoordinador.cargarTabla();
            }
        });
        rechazarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaModificar ventana = miCoordinador.getVentanaModificar();
                // Cerrar la ventana actual
                SwingUtilities.getWindowAncestor(ventana.ventanaModificar).dispose();
            }
        });
    }

    public Coordinador getMiCoordinador() {
        return miCoordinador;
    }

    public void setMiCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }





}
