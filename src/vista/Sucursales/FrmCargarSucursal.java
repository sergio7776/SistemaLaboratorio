package vista.Sucursales;

import DTO.SucursalDTO;
import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmCargarSucursal extends JDialog {
    private JPanel pnlPrincipal;
    private JButton volverButton;
    private JButton cargarButton;
    private JTextField numSucursalTxt;
    private JTextField direccionTxt;
    private JTextField respTecTxt;

    private Controller controller;

    public  FrmCargarSucursal(Window owner, String titulo){
        super(owner, titulo);

        this.setContentPane(pnlPrincipal);
        this.setSize(800, 600);

        this.setModal(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);

        controller = Controller.getInstances();
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarSucursal(getNumSucursalTxt(), getDireccionTxt(), getRespTecTxt());
                dispose();
            }
        });
    }
    public void guardarSucursal(String numero, String direccion, String responsableTecnico){
        controller.crearSucursal(new SucursalDTO(numero, direccion, responsableTecnico));
    }

    public String getNumSucursalTxt() { return numSucursalTxt.getText();}
    public String getDireccionTxt() { return direccionTxt.getText();}
    public String getRespTecTxt() { return respTecTxt.getText();}


}
