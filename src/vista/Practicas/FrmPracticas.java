package vista.Practicas;

import javax.swing.*;
import java.awt.*;

public class FrmPracticas extends JDialog {

    private JPanel pnlPrincipal;

    public FrmPracticas (Window owner, String titulo)
    {
        super(owner, titulo);

        this.setContentPane(pnlPrincipal);
        this.setSize(800, 600);
        //No permite volver a la pantalla anterior hasta cerrar esta pantalla
        this.setModal(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);

    }

}