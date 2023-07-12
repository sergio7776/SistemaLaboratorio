package vista.Peticiones;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPeticiones extends JDialog {

    private JPanel pnlPrincipal;
    private JButton volverButton;
    private JButton verPeticionesButton;
    private JButton añadirPeticionesButton;
    private JButton verPeticionesConValoresButton;
    private Controller controller;
    private FrmPeticiones self;

    public FrmPeticiones (Window owner, String titulo)
    {
        super(owner, titulo);
        this.self = this;
        controller = Controller.getInstances();

        this.setContentPane(pnlPrincipal);
        this.setSize(800, 600);
        //No permite volver a la pantalla anterior hasta cerrar esta pantalla
        this.setModal(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        verPeticionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmVerPeticiones frame = new FrmVerPeticiones(self,"Lista de peticiones");
                frame.setVisible(true);
            }
        });
        verPeticionesConValoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmVerPeticionesCriticas frame = new FrmVerPeticionesCriticas(self,"Lista de peticiones críticas");
                frame.setVisible(true);
            }
        });
    }

}