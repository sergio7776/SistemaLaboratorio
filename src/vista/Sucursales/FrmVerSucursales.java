package vista.Sucursales;

import controller.Controller;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmVerSucursales extends JDialog {

    private JPanel pnlPrincipal;
    private JButton volverButton;
    private JList listaSucursales;
    private JLabel lblListaDireccion;
    private JLabel lblListResponsableTec;

    private Controller.ListaSucursales listaSucursal = new Controller.ListaSucursales();

    public  FrmVerSucursales(Window owner, String titulo){
        super(owner, titulo);

        this.setContentPane(pnlPrincipal);

        lblListaDireccion.setVisible(false);
        lblListResponsableTec.setVisible(false);

        this.setSize(800, 600);

        this.setModal(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);

        listaSucursales.setModel(listaSucursal);

        listaSucursales.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                lblListaDireccion.setVisible(true);
                lblListResponsableTec.setVisible(true);
                lblListaDireccion.setText(listaSucursal.getDireccion(listaSucursales.getSelectedIndex()));
                lblListResponsableTec.setText(listaSucursal.getResponsableTecnico(listaSucursales.getSelectedIndex()));
            }

        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
