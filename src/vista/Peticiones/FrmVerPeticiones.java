package vista.Peticiones;

import controller.Controller;
import vista.Pacientes.FrmVerPacientes;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class FrmVerPeticiones extends JDialog {

    private JPanel pnlPrincipal;
    private JTable tablaPeticiones;
    private JButton volverButton;
    private JPanel pnlSecundario;

    public static FrmVerPeticiones self;

    private Controller.MiTablaPeticiones misPeticiones;

    public FrmVerPeticiones(Window owner, String titulo){
        super(owner, titulo);

        this.setContentPane(pnlPrincipal);

        this.setSize(800, 600);

        this.setModal(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);

        this.self = this;

        misPeticiones = new Controller.MiTablaPeticiones();

        TableCellRenderer buttonRenderer = new JTableButtonRenderer();

        misPeticiones.fireTableDataChanged();

        tablaPeticiones.setModel(misPeticiones);

        tablaPeticiones.getColumn("Practicas asociadas").setCellRenderer(buttonRenderer);

        tablaPeticiones.addMouseListener(new JTableButtonMouseListener(tablaPeticiones));

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private static class JTableButtonRenderer implements TableCellRenderer {
        @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton button = (JButton)value;
            return button;
        }
    }

    private static class JTableButtonMouseListener extends MouseAdapter {
        private final JTable table;

        public JTableButtonMouseListener(JTable table) {
            this.table = table;
        }

        public void mouseClicked(MouseEvent e) {
            int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the column of the button
            int row    = e.getY()/table.getRowHeight(); //get the row of the button

            /*Checking the row or column is valid or not*/
            if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
                Object value = table.getValueAt(row, column);
                if (value instanceof JButton) {
                    /*perform a click event*/
                    ((JButton)value).doClick();
                }
            }
        }
    }
}
