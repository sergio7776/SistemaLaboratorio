package vista.Pacientes;

import controller.Controller;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmVerPacientes extends JDialog{
    private JPanel pnlPrincipal;
    private JList listaPacientes;
    private JLabel lblListCalle;
    private JLabel lblListNum;
    private JLabel lblListDNI;
    private JPanel pnlSecundario;
    private JLabel calleTxt;
    private JLabel numTxt;
    private JLabel DniTxt;
    private JButton volverButton;
    private JLabel lblListNomObr;
    private JLabel lblListCodObr;
    private JLabel lblListMail;
    private JLabel lblListSexo;
    private JLabel lblListEdad;
    private JPanel pnlVerPacientes;

    private Controller.ListaPacientes listaPaciente = new Controller.ListaPacientes();
    public  FrmVerPacientes(Window owner, String titulo){
        super(owner, titulo);

        this.setContentPane(pnlPrincipal);

        lblListCalle.setVisible(false);
        lblListNum.setVisible(false);
        lblListDNI.setVisible(false);
        lblListCodObr.setVisible(false);
        lblListNomObr.setVisible(false);
        lblListMail.setVisible(false);
        lblListSexo.setVisible(false);
        lblListEdad.setVisible(false);

        this.setSize(800, 600);

        this.setModal(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);

        listaPacientes.setModel( listaPaciente);
        listaPacientes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                lblListCalle.setVisible(true);
                lblListNum.setVisible(true);
                lblListDNI.setVisible(true);
                lblListCodObr.setVisible(true);
                lblListNomObr.setVisible(true);
                lblListMail.setVisible(true);
                lblListSexo.setVisible(true);
                lblListEdad.setVisible(true);
                lblListCalle.setText(listaPaciente.getCalleDom(listaPacientes.getSelectedIndex()));
                lblListNum.setText(String.valueOf(listaPaciente.getNumeroDom(listaPacientes.getSelectedIndex())));
                lblListDNI.setText( String.valueOf(listaPaciente.getDni(listaPacientes.getSelectedIndex())));
                lblListCodObr.setText(listaPaciente.getCodigoObr(listaPacientes.getSelectedIndex()));
                lblListNomObr.setText(listaPaciente.getNombreObr(listaPacientes.getSelectedIndex()));
                lblListMail.setText(listaPaciente.getMail(listaPacientes.getSelectedIndex()));
                lblListSexo.setText(listaPaciente.getSexo(listaPacientes.getSelectedIndex()));
                lblListEdad.setText(String.valueOf(listaPaciente.getEdad(listaPacientes.getSelectedIndex())));
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
