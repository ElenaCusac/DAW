package tarea2aelenacusac;

import javax.swing.JOptionPane;

// Nombre: Elena Cusac Ortigosa

public class EJ2 {
    public static void main(String[] args) {
        
        //Solicita el precio de un producto sin IVA y calcula el total con IVA (21%).

        final double IVA = 0.21;

        String precioSinIVA = JOptionPane.showInputDialog("Introduce el precio del producto sin IVA: ");

        //Pasar el string a número
        double precioSinIVANumero = Double.parseDouble(precioSinIVA);

        //Cálculo
        double precioConIVA = precioSinIVANumero + (precioSinIVANumero * IVA);

        //Resultado
        String resultadoAlgoritmo = """
                Si el precio del producto sin IVA es %s euros, 
                el precio con IVA (21%%) es de %s euros.
                """. formatted(precioSinIVA, precioConIVA);

        JOptionPane.showMessageDialog(null,resultadoAlgoritmo);


    }

}
