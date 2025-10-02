package Excepciones.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PiscinaVentana extends JFrame implements ActionListener {

    private Container container;
    private JButton llenar, vaciar, probarPiscina;
    private JComboBox<String> comboCapacidad;
    private JTextArea areaTexto;
    private JScrollPane scroll;
    private Piscina piscina;
    private JSlider accion;

    public PiscinaVentana() {
        setTitle("Piscina");
        setSize(800, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        container = getContentPane();
        container.setLayout(null);

        // Inicializar el área de texto y el scroll aquí para que siempre esté visible
        areaTexto = new JTextArea("Piscina Vacía: 0");
        areaTexto.setEditable(false);
        scroll = new JScrollPane(areaTexto);
        scroll.setBounds(20, 400, 740, 200); // Ajusta la posición y tamaño según necesidad
        container.add(scroll);
    }

    public void inicio() {


        JLabel texto = new JLabel("Capacidad de la piscina en metros cubicos: ");
        texto.setBounds(20, 20, 300, 30);
        container.add(texto);

        String[] valores = {"1.0", "1.1", "1.2", "1.3", "1.4", "1.5"};
        comboCapacidad = new JComboBox<>(valores);
        comboCapacidad.setBounds(330, 20, 50, 20);
        container.add(comboCapacidad);


        probarPiscina = new JButton("<html>Probar<br>Piscina</html>");
        probarPiscina.setBounds(100, 60, 100, 80);
        probarPiscina.addActionListener(this);
        container.add(probarPiscina);


        llenar = new JButton("Llenar");
        llenar.setBounds(160, 200, 100, 40);
        llenar.setBackground(Color.green);
        llenar.addActionListener(this);
        container.add(llenar);

        vaciar = new JButton("Vaciar");
        vaciar.setBounds(400, 200, 100, 40);
        vaciar.setBackground(Color.red);
        vaciar.addActionListener(this);
        container.add(vaciar);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == probarPiscina) {
            double capacidad = Double.parseDouble((String) comboCapacidad.getSelectedItem());
            piscina = new Piscina(capacidad);

            if (accion != null) container.remove(accion); // Eliminar slider anterior si existe
            accion = new JSlider(0, (int) (piscina.MAX_NIVEL * 1000));
            accion.setBounds(20, 250, 700, 100);
            accion.setMajorTickSpacing(100);
            accion.setMinorTickSpacing(10);
            accion.setPaintTicks(true);
            accion.setEnabled(false);
            accion.setValue(0);
            accion.setPaintLabels(true);
            container.add(accion);
            areaTexto.setText("Piscina Vacía: 0");
            container.repaint();
        }
        if (e.getSource() == llenar) {
            Random random = new Random();
            double litros = random.nextInt(1, 1001); // 1 a 1000 inclusive
            System.out.println(litros);
            try {
                piscina.llenar(litros);
                accion.setValue((int) piscina.getNivel());
                areaTexto.setText("Se añaden " + litros + ". Nuevo nivel: " + piscina.getNivel() + " m³");
            } catch (Exception ex) {
                areaTexto.setText("Excepción: " + ex.getMessage() + " | Nivel actual: " + piscina.getNivel() + " m³");
            }

        }
    }


    public static void main(String[] args) {

        PiscinaVentana ventana = new PiscinaVentana();
        ventana.inicio();
        ventana.setVisible(true);

    }


}
