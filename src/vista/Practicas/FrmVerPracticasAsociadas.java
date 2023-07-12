package vista.Practicas;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmVerPracticasAsociadas extends JDialog {
    private JPanel pnlPrincipal;
    private JButton volverButton;
    private JPanel pnlSecundario;
    private JTable tablaPracticasAsociadas;
    private int rowIndex;

    private Controller.MiTablaPracticasAsociadas misPracticasAsociadas;
    public FrmVerPracticasAsociadas(Window owner, String titulo, int rowIndex){
        super(owner, titulo);

        this.rowIndex = rowIndex;

        this.setSize(800, 600);

        this.setModal(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        misPracticasAsociadas = new Controller.MiTablaPracticasAsociadas(rowIndex);

        tablaPracticasAsociadas.setModel(misPracticasAsociadas);

        this.setContentPane(pnlPrincipal);

        this.setLocationRelativeTo(null);
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
