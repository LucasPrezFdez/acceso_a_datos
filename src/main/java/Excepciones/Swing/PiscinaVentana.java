package Excepciones.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PiscinaVentana extends JFrame implements ActionListener {

    private Container container;
    private JButton llenar, vaciar, probarPiscina;


    public PiscinaVentana() {
        setTitle("Piscina");
        setSize(800, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        container = getContentPane();
        container.setLayout(null);
    }

    public void inicio() {


        JLabel texto = new JLabel("Capacidad de la piscina en metros cubicos: ");
        texto.setBounds(20, 20, 300, 30);
        container.add(texto);



        probarPiscina = new JButton("<html>Probar<br>Piscina</html>");
        probarPiscina.setBounds(100, 60, 100, 80);
        probarPiscina.addActionListener(this);
        container.add(probarPiscina);


        llenar = new JButton("Llenar");
        llenar.setBounds(40, 130, 80, 30);
        llenar.setBackground(Color.green);
        llenar.addActionListener(this);
        container.add(llenar);

        vaciar = new JButton("Vaciar");
        vaciar.setBounds(160, 150, 100, 40);
        vaciar.setBackground(Color.red);
        vaciar.addActionListener(this);
        container.add(vaciar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == probarPiscina) {
            Piscina piscina = new Piscina(13);
            JSlider accion = new JSlider(0, piscina.MAX_NIVEL);
            accion.setBounds(20, 250, 700, 100);
            // Mostrar marcas (ticks)
            accion.setMajorTickSpacing(100);  // Marcas grandes cada 10 unidades
            accion.setMinorTickSpacing(10);   // Marcas pequeñas cada 1 unidad

            accion.setPaintTicks(true);      // Mostrar las marcas (ticks)

// Mostrar números (etiquetas) en las marcas principales
            accion.setPaintLabels(true);
            container.add(accion);
        }
        if (e.getSource() == llenar) {

        }
    }


    public static void main(String[] args) {

        PiscinaVentana ventana = new PiscinaVentana();
        ventana.inicio();
        ventana.setVisible(true);

    }


}
