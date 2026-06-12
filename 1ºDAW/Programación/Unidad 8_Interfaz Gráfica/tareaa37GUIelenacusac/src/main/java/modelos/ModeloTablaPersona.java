
package modelos;

import javax.swing.table.DefaultTableModel;

// Para usar un componente JTable hay que asociar al mismo un objeto de tipo 
// DefaultTableModel que contenga las columnas correspondientes,
// heredando de la clase DefaultTableModel
// En este caso, el modelo de la tabla contendrá los datos de las personas
// que se encuentran en la lista de personas

public class ModeloTablaPersona extends DefaultTableModel {
    
    public ModeloTablaPersona(){
        // Se asignan los nombres de las columnas de la tabla
        // en función de los atributos que tiene la persona
        String[] columnNames = {"ID", "NOMBRE", "APELLIDO", "CIUDAD"}; 
        
        // Se le indica al modelo el nombre de las columnas y cantidad
        this.setColumnIdentifiers(columnNames); 
    }

    // Este método sobrescrito de la clase DefaultTableModel sirve para indicar qué celdas
    // del JTable son editables
    @Override
    public boolean isCellEditable (int row, int column)
    {
        // Aquí devolvemos true o false según queramos que una celda
        // identificada por fila,columna (row,column), sea o no editable
        // En nuestro caso ninguna celda se edita
        // Si queremos que, por ejemplo, la Ciudad sea editable, entonces
        // if (column == 3) return true;
        return false;
    }

}
