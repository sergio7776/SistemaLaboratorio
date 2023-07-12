package vista.Sucursales;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmEliminarSucursal extends JDialog {
    private JPanel pnlPrincipal;
    private JButton button1;
    private JButton eliminarSucursalButton;
    private JTextField numeroSucursalTxt;
    private Controller controller;

    public  FrmEliminarSucursal(Window owner, String titulo){
        super(owner, titulo);

        this.setContentPane(pnlPrincipal);

        this.setSize(800, 600);

        this.setModal(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);

        controller = Controller.getInstances();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        eliminarSucursalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarSucursal(getNumeroSucursalTxt());
            }
        });
    }

    public void eliminarSucursal(String numeroSucursal) { controller.eliminarSucursal(numeroSucursal);}

    public String getNumeroSucursalTxt() {return numeroSucursalTxt.getText();}
}
