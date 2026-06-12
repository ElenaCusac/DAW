package tarea2aelenacusac;

import javax.swing.JOptionPane;

// Nombre: Elena Cusac Ortigosa

public class EJ3 {

    public static void main(String[] args) {
        // Calcula el volumen de una esfera, solicitando el radio al usuario. 
        // Usa la constante PI y la función pow de la clase Math

        final double PI = Math.PI;

        String radio = JOptionPane.showInputDialog("Introduce el radio de la esfera cuyo volumen quieres calcular");

        //Pasar el string a número
        double radioNumero = Double.parseDouble(radio);

        //Cálculo del volumen de la esfera
        double volumen = (4.0/3.0) * PI * Math.pow(radioNumero, 3);

        //Resultado 
        String resultadoAlgoritmo = """
                El volumen de una esfera de 
                radio %.3f es de %.3f unidades 
                al cubo
                """. formatted(radioNumero, volumen);

        JOptionPane.showMessageDialog(null, resultadoAlgoritmo);
    }

}
