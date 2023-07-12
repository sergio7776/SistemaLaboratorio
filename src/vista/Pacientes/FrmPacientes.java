package vista.Pacientes;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPacientes extends JDialog {

    private JPanel pnlPrincipal;
    private JButton verPacientesButton;
    private JButton eliminarPacienteButton;
    private JButton añadirPacienteButton;
    private JButton volverButton;
    private String dniTxt;
    private String nombreTxt;
    private String apellidoTxt;
    private String calleDomicilioTxt;
    private String numeroDomicilioTxt;
    private String mailTxt;
    private String sexoTxt;
    private String edadTxt;

    private Controller controller;

    private FrmPacientes self;

    public FrmPacientes(Window owner, String titulo)
    {
        super(owner, titulo);
        this.self = this;
        controller = Controller.getInstances();

        this.setContentPane(pnlPrincipal);
        this.setSize(800, 600);
        //No permite volver a la pantalla anterior hasta cerrar esta pantalla
        this.setModal(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);

        verPacientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmVerPacientes frame = new FrmVerPacientes(self,"Lista de pacientes");
                frame.setVisible(true);
            }
        });
        añadirPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmCargarPaciente frame = new FrmCargarPaciente(self,"Carga de paciente");
                frame.setVisible(true);
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        eliminarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmEliminarPaciente frame = new FrmEliminarPaciente(self,"Eliminar paciente");
                frame.setVisible(true);
            }
        });
    }

}
