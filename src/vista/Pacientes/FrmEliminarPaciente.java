package vista.Pacientes;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmEliminarPaciente extends JDialog{

    private JPanel pnlPrincipal;
    private JButton volverButton;
    private JButton eliminarPacienteButton;
    private JTextField dniPacienteTxt;
    private Controller controller;

    public  FrmEliminarPaciente(Window owner, String titulo){
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
        eliminarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPaciente(getDniPacienteTxt());
            }
        });
    }

    public void eliminarPaciente(String dni){
        controller.eliminarPaciente(dni);
    }

    public String getDniPacienteTxt(){
        return dniPacienteTxt.getText();
    };
}

