package vista.Usuarios;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class FrmEliminarUsuario extends JDialog {
    private JPanel pnlPrincipal;
    private Controller controller;

    public  FrmEliminarUsuario(Window owner, String titulo){
        super(owner, titulo);

        this.setContentPane(pnlPrincipal);

        this.setSize(800, 600);

        this.setModal(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);

        controller = Controller.getInstances();

    }
}
