package ConexionBBDD.ModeloVCExercise.Vista;

import ConexionBBDD.ModeloVCExercise.Controlador.Coordinador;

import javax.swing.*;

public class VentanaModificar {


    public Coordinador miCoordinador;
    public JPanel ventanaModificar;
    private JTextField IDProducto;
    private JTextField nombre;
    private JTextField idDistribuidor;
    private JTextField idCategoria;
    private JTextField cantidad;
    private JTextField precio;
    private JTextField stock;
    private JTextField udsOrden;
    private JTextField prioridadOrden;
    private JTextField discotinued;
    private JButton rechazarButton;
    private JButton aceptarButton;

    public Coordinador getMiCoordinador() {
        return miCoordinador;
    }

    public void setMiCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }



}
