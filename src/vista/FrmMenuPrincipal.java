package vista;

import vista.Pacientes.FrmPacientes;
import vista.Peticiones.FrmPeticiones;
import vista.Practicas.FrmPracticas;
import vista.Sucursales.FrmSucursales;
import vista.Usuarios.FrmUsuarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrmMenuPrincipal extends JFrame {

    private JPanel pnlPrincipal;
    private JPanel pnlMenu;
    private JButton pacientesButton;
    private JButton sucursalesButton;
    private JButton peticionesButton;
    private JButton usuariosButton;
    private JButton salirButton;

    private FrmMenuPrincipal self;

    public FrmMenuPrincipal(String titulo)
    {
        super(titulo);

//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (UnsupportedLookAndFeelException e) {
//            throw new RuntimeException(e);
//        }}

        this.setContentPane(pnlPrincipal);

        this.setSize(800, 600);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);

        this.asociarEventos();

        this.self = this;

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void asociarEventos(){
        pacientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmPacientes frame = new FrmPacientes(self,"Pacientes");
                frame.setVisible(true);
            }
        });

        sucursalesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmSucursales frame = new FrmSucursales(self,"Sucursales");
                frame.setVisible(true);
            }
        });

//        practicasButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                FrmPracticas frame = new FrmPracticas(self,"Practicas");
//                frame.setVisible(true);
//            }
//        });
        peticionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmPeticiones frame = new FrmPeticiones(self,"Peticiones");
                frame.setVisible(true);
            }
        });
        usuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmUsuarios frame = new FrmUsuarios(self,"Usuarios");
                frame.setVisible(true);
            }
        });

    }

    public static void main(String[] args) {
        FrmMenuPrincipal frame = new FrmMenuPrincipal("Laboratorio");
        frame.setVisible(true);
    }
}