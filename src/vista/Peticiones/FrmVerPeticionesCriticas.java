package vista.Peticiones;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmVerPeticionesCriticas extends JDialog{
    private JPanel pnlPrincipal;
    private JList lista;
    private JButton volverButton;

    private Controller.ListaPeticionesCriticas listaPeticionesCriticas = new Controller.ListaPeticionesCriticas();
    public  FrmVerPeticionesCriticas(Window owner, String titulo){
        super(owner, titulo);

        this.setContentPane(pnlPrincipal);

        this.setSize(800, 600);

        this.setModal(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);

        lista.setModel( listaPeticionesCriticas);
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
