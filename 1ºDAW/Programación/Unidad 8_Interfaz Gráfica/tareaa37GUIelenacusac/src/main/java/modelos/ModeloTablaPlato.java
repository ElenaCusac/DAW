package modelos;

import javax.swing.table.DefaultTableModel;

public class ModeloTablaPlato extends DefaultTableModel {

    public ModeloTablaPlato() {
        String[] columnNames = {"ID", "Nombre", "Descripción", "Precio"};
        setColumnIdentifiers(columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 3;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 3) {
            return Double.class;
        }
        return String.class;
    }
}
