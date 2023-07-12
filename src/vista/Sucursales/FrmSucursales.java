package vista.Sucursales;

import controller.Controller;
import vista.Pacientes.FrmCargarPaciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmSucursales extends JDialog {

    private JPanel pnlPrincipal;
    private JButton volverButton;
    private JButton verSucursalesButton;
    private JButton añadirSucursalButton;
    private JButton eliminarSucursalButton;

    private Controller controller;
    FrmSucursales self;

    public FrmSucursales (Window owner, String titulo)
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
        verSucursalesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmVerSucursales frame = new FrmVerSucursales(self,"Lista de sucursales");
                frame.setVisible(true);
            }
        });
        añadirSucursalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmCargarSucursal frame = new FrmCargarSucursal(self,"Cargas de sucursal");
                frame.setVisible(true);
            }
        });
        eliminarSucursalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmEliminarSucursal frame = new FrmEliminarSucursal(self,"Eliminar sucursales");
                frame.setVisible(true);
            }
        });
    }

}