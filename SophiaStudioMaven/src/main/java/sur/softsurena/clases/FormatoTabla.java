package sur.softsurena.clases;

import java.awt.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class FormatoTabla extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    private final int columna_patron;

    public FormatoTabla(int Colpatron) {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean selected, boolean focused, 
            int row, int column
    ) {
        setBackground(Color.white);//color de fondo
        table.setForeground(Color.black);//color de texto
        //Si la celda corresponde a una fila con estado FALSE, se cambia el color de fondo a rojo

        if (table.getValueAt(row, columna_patron).equals("PAGADO")) {
            setBackground(Color.GREEN);
        }

        if (table.getValueAt(row, columna_patron).equals("ABONO")) {
            setBackground(Color.ORANGE);
        }

        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        return this;
    }
}
