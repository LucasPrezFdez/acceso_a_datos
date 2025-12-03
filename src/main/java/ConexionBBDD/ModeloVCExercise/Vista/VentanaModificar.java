package ConexionBBDD.ModeloVCExercise.Vista;

import ConexionBBDD.ModeloVCExercise.Controlador.Coordinador;

import javax.swing.*;

public class VentanaModificar {


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

    public Coordinador getMiCoordinador() {
        return miCoordinador;
    }

    public void setMiCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }



}
