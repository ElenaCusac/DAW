package tarea2aelenacusac;

import javax.swing.JOptionPane;

// Nombre: Elena Cusac Ortigosa

public class EJ1 {
    public static void main(String[] args) {
        
        /*Un trabajador cobra un salario por hora de 34.5 euros. Pide al usuario que introduzca el número de horas 
        trabajadas a la semana muestra el salario total.*/

        final double SALARIO_HORA = 34.5;

        String horasTrabajo = JOptionPane.showInputDialog("Introduce el número de horas trabajadas a la semana: ");

        //Pasar el string a número
        int horasTrabajoNumero = Integer.parseInt(horasTrabajo);

        //Calculo 
        double dineroSemanal = horasTrabajoNumero * SALARIO_HORA;

        //Mostrar resultado
        String resultadoAlgoritmo = """
                Si trabajas %s horas a la semana, 
                tu salario semanal es de %s euros.
                """. formatted(horasTrabajo, dineroSemanal);

        JOptionPane.showMessageDialog(null,resultadoAlgoritmo);
    }
}