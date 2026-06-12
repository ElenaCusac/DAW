package tarea2aelenacusac;

import javax.swing.JOptionPane;

// Nombre: Elena cusac Ortigosa

public class EJ4 {
        public static void main(String[] args) {
        /* Sabiendo que un euro, al cambio está a 1,17 dólares, realiza una calculadora 
         * dólares a euros, solicitando el número de dólares que se quieren cambiar.
         */

        double cambio = 1.17;
        String dolar = JOptionPane.showInputDialog("Introduce la cantidad de dólares que quieres cambiar a euros");

        //Pasar el string a número
        double dolarNumero = Double.parseDouble(dolar);

        //Cambio de dólares a euros
        double euroCambio = dolarNumero/cambio;

        //Resultado
        String resultadoAlgoritmo = """
                        El cambio de %s dólares a 
                        euros es de %.2f€
                        """. formatted(dolarNumero, euroCambio);
        
        JOptionPane.showMessageDialog(null, resultadoAlgoritmo);

        }
}
