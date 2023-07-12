package vista.Pacientes;

import DTO.PacienteDomicilioDTO;
import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmCargarPaciente extends JDialog{
    private JPanel pnlPrincipal;
    private JButton cargarButton;
    private JTextField nombrePacienteTxt;
    private JTextField apellidoPacienteTxt;
    private JTextField calleDomPacienteTxt;
    private JTextField numeroDomPacienteTxt;
    private JTextField dniPacienteTxt;
    private JTextField nombreObraSocialTxt;
    private JTextField codigoObraSocialTxt;
    private JTextField mailTxt;
    private JTextField sexoTxt;
    private JTextField edadTxt;
    private JButton volverButton;
    private JPanel pnlCargarPaciente;

    private Controller controller;

    public  FrmCargarPaciente(Window owner, String titulo){
        super(owner, titulo);

        this.setContentPane(pnlPrincipal);
        this.setSize(800, 600);

        this.setModal(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);
        
        controller = Controller.getInstances();

        cargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarPaciente(getNombrePacienteTxt(), getApellidoPacienteTxt(),
                                getDniPacienteTxt(), getCalleDomicilioTxt(),
                                getNumeroDomicilioTxt(), getNombreObraSocialTxt(), getCodigoObraSocialTxt(),
                                getMailTxt(), getSexoTxt(), getEdadTxt());
                dispose();
            }
        });

        codigoObraSocialTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    guardarPaciente(getNombrePacienteTxt(), getApellidoPacienteTxt(),
                            getDniPacienteTxt(), getCalleDomicilioTxt(),
                            getNumeroDomicilioTxt(),getNombreObraSocialTxt(),getCodigoObraSocialTxt(), getMailTxt(), getSexoTxt(),getEdadTxt());
                    dispose();
                }
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void guardarPaciente(String nombre, String apellido, String dni, String calleDom, String numeroDom, String nombreObraSocial, String codigoObraSocial, String mail, String sexo, String edad ){

        controller.crearPaciente(new PacienteDomicilioDTO(nombre, apellido, dni, calleDom, numeroDom, nombreObraSocial, codigoObraSocial, mail, sexo, edad));

    }
    public String getNombrePacienteTxt() {
        return nombrePacienteTxt.getText();
    }
    public String getApellidoPacienteTxt() {
        return apellidoPacienteTxt.getText();
    }
    public String getDniPacienteTxt() {
        return dniPacienteTxt.getText();
    }
    public String getCalleDomicilioTxt() {
        return calleDomPacienteTxt.getText();
    }
    public String getNumeroDomicilioTxt() {
        return numeroDomPacienteTxt.getText();
    }
    public String getNombreObraSocialTxt() {
        return nombreObraSocialTxt.getText();
    }
    public String getCodigoObraSocialTxt() {
        return codigoObraSocialTxt.getText();
    }

    public String getMailTxt() {
        return mailTxt.getText();
    }
    public String getSexoTxt() {
        return sexoTxt.getText();
    }
    public String getEdadTxt() {
        return edadTxt.getText();
    }
    
}
