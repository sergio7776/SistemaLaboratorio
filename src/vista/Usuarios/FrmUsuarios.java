package vista.Usuarios;

import controller.Controller;
import vista.Sucursales.FrmCargarSucursal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmUsuarios extends JDialog {

    private JPanel pnlPrincipal;
    private JButton volverButton;
    private JButton verUsuariosButton;
    private JButton añadirUsuariosButton;
    private JButton eliminarUsuariosButton;

    private Controller controller;
    FrmUsuarios self;

    public FrmUsuarios (Window owner, String titulo)
    {
        super(owner, titulo);
        controller = Controller.getInstances();
        this.setContentPane(pnlPrincipal);
        this.setSize(800, 600);
        //No permite volver a la pantalla anterior hasta cerrar esta pantalla
        this.setModal(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);

        this.self = this;

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        verUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmVerUsuarios frame = new FrmVerUsuarios(self,"Cargas de sucursal");
                frame.setVisible(true);
            }
        });
        añadirUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmCargarUsuario frame = new FrmCargarUsuario(self,"Cargas de sucursal");
                frame.setVisible(true);
            }
        });
        eliminarUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmEliminarUsuario frame = new FrmEliminarUsuario(self,"Cargas de sucursal");
                frame.setVisible(true);
            }
        });
    }

}