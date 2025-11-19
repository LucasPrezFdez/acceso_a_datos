package ConexionBBDD.ej1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationPanel {
    private JPanel panelOperaciones;
    private JButton button1;
    private JButton button2;
    private JTable table1;
    private JScrollPane resultadoConsulta;


    public OperationPanel() {
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoConsulta.setVisible(true);
            }
        });
    }

    public JPanel getPanelOperaciones() {
        return panelOperaciones;
    }
}
