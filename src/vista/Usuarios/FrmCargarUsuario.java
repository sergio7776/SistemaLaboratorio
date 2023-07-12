package vista.Usuarios;

import DTO.PacienteDomicilioDTO;
import DTO.UsuarioRolDTO;
import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmCargarUsuario extends JDialog {
    private JPanel pnlPrincipal;
    private JButton button1;
    private JButton volverButton;
    private JTextField nombreUsuarioTxt;
    private JTextField emailTxt;
    private JTextField pwdTxt;
    private JTextField NyATxt;
    private JTextField calleDomTxt;
    private JTextField numDomTxt;
    private JTextField dniTxt;
    private JTextField añoTxt;
    private JTextField mesTxt;
    private JTextField diaTxt;
    private JTextField rolTxt;

    private Controller controller;

    public  FrmCargarUsuario(Window owner, String titulo){
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
                guardarUsuario(getNombreUsuarioTxt(), getEmailTxt(),
                        getPwdTxt(), getNyATxt() ,getCalleDomicilioTxt(),
                        getNumeroDomicilioTxt(), getDniTxt(), getAñoTxt(), getMesTxt(),
                        getDiaTxt(), getRolTxt());
                dispose();
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void guardarUsuario(String nombreUsuario, String email, String pwd, String nombreApellido, String calleDom, String numeroDom, String dni, String año, String mes, String dia, String rol ){

        controller.crearUsuario(new UsuarioRolDTO(nombreUsuario, email, pwd, nombreApellido, calleDom, numeroDom, dni, año, mes, dia, rol));

    }

    public String getNombreUsuarioTxt() {
        return nombreUsuarioTxt.getText();
    }
    public String getEmailTxt() { return emailTxt.getText(); }
    public String getPwdTxt() {
        return pwdTxt.getText();
    }
    public String getNyATxt() {
        return NyATxt.getText();
    }
    public String getCalleDomicilioTxt() {
        return calleDomTxt.getText();
    }
    public String getNumeroDomicilioTxt() {
        return numDomTxt.getText();
    }
    public String getDniTxt() {
        return dniTxt.getText();
    }
    public String getAñoTxt() {
        return añoTxt.getText();
    }
    public String getMesTxt() {
        return mesTxt.getText();
    }
    public String getDiaTxt() {
        return diaTxt.getText();
    }
    public String getRolTxt() {
        return rolTxt.getText();
    }

}
