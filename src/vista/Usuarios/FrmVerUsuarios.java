package vista.Usuarios;

import controller.Controller;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmVerUsuarios extends JDialog {
    private JPanel pnlPrincipal;
    private JButton volverButton;
    private JPanel pnlSecundario;
    private JList listaUsuarios;
    private JLabel lblListEmail;
    private JLabel lblListPw;
    private JLabel lblListNyA;
    private JLabel lblListCalle;
    private JLabel lblListNum;
    private JLabel lblListFecha;
    private JLabel lblListRol;

    private Controller.ListaUsuarios listaUsuario = new Controller.ListaUsuarios();
    public  FrmVerUsuarios(Window owner, String titulo){
        super(owner, titulo);

        this.setContentPane(pnlPrincipal);

        lblListEmail.setVisible(false);
        lblListPw.setVisible(false);
        lblListNyA.setVisible(false);
        lblListCalle.setVisible(false);
        lblListNum.setVisible(false);
        lblListFecha.setVisible(false);
        lblListRol.setVisible(false);

        this.setSize(800, 600);

        this.setModal(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);

        listaUsuarios.setModel(listaUsuario);

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        listaUsuarios.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                lblListEmail.setVisible(true);
                lblListPw.setVisible(true);
                lblListNyA.setVisible(true);
                lblListCalle.setVisible(true);
                lblListNum.setVisible(true);
                lblListFecha.setVisible(true);
                lblListRol.setVisible(true);
                lblListEmail.setText(listaUsuario.getEmail(listaUsuarios.getSelectedIndex()));
                lblListCalle.setText(listaUsuario.getCalleDom(listaUsuarios.getSelectedIndex()));
                lblListFecha.setText(listaUsuario.getFecha(listaUsuarios.getSelectedIndex()));
                lblListPw.setText(listaUsuario.getPwd(listaUsuarios.getSelectedIndex()));
                lblListNum.setText(String.valueOf(listaUsuario.getNumeroDom(listaUsuarios.getSelectedIndex())));
                lblListNyA.setText(listaUsuario.getNombreApellido(listaUsuarios.getSelectedIndex()));
                lblListRol.setText(listaUsuario.getRol(listaUsuarios.getSelectedIndex()));
            }
        });
    }
}
