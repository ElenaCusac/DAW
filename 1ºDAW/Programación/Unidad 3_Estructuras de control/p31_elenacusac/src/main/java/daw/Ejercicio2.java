package daw;

import javax.swing.JOptionPane;

public class Ejercicio2 {
    public static void main(String[] args) {
        final double PRECIO_INICIAL = 1.23;
        double precioPicualGruesa = 0, precioPicualFina = 0, precioAloreñaGruesa = 0, precioAloreñaFina = 0,
                precioHojiblancaGruesa = 0, precioHojiblancaFina = 0;
        boolean condiciones = true;
        

        for (int i = 1; i <= 10; i++) {
            
            do {
                String tipoAceituna = JOptionPane.showInputDialog("Introduce el tipo de aceituna (Picual/Aloreña/Hojiblanca) o teclee 'salir': ");

                if (tipoAceituna.equalsIgnoreCase("salir")) {
                    condiciones = false;
                    break;
                }

                String gruesaOFina = JOptionPane.showInputDialog("Introduce si la aceituna es gruesa o fina: ");
                String kilosString = JOptionPane.showInputDialog("Introduce los kilos recogidos: ");
                double kilos = Double.parseDouble(kilosString);
                if (kilos > 0) {
                    if (tipoAceituna.equalsIgnoreCase("picual")) {
                        if (gruesaOFina.equalsIgnoreCase("gruesa")) {
                            precioPicualGruesa = (PRECIO_INICIAL + 0.20) * kilos;
    
                        } else if (gruesaOFina.equalsIgnoreCase("fina")) {
                            precioPicualFina = (PRECIO_INICIAL + 0.30) * kilos;
                        }
                    } else if (tipoAceituna.equalsIgnoreCase("aloreña")) {
                        if (gruesaOFina.equalsIgnoreCase("gruesa")) {
                            precioAloreñaGruesa = (PRECIO_INICIAL - 0.15) * kilos;
                        } else if (gruesaOFina.equalsIgnoreCase("fina")) {
                            precioAloreñaFina = (PRECIO_INICIAL - 0.30) * kilos;
                        }
    
                    } else if (tipoAceituna.equalsIgnoreCase("hojiblanca")) {
                        if (gruesaOFina.equalsIgnoreCase("gruesa")) {
                            precioHojiblancaGruesa = (PRECIO_INICIAL + 0.15) * kilos;
                        } else if (gruesaOFina.equalsIgnoreCase("fina")) {
                            precioHojiblancaFina = (PRECIO_INICIAL - 0.05) * kilos;
                        }

                    } 
                } else if (kilos <= 0) {
                    JOptionPane.showMessageDialog(null, "Error al introducir los kilos, deben de ser mayores que 0");
                } 
                    


                String resultado = """
                        El precio total de cada tipo de oliva recogida es el siguiente:

                        - Aceituna Picual:
                          - Gruesa: %.3f
                          - Fina: %.3f

                        - Aceituna Aloreña:
                          - Gruesa: %.3f
                          - Fina: %.3f

                        - Aceituna Hojiblanca:
                          - Gruesa: %.3f
                          - Fina: %.3f

                        """.formatted(precioPicualGruesa, precioPicualFina, precioAloreñaGruesa, precioAloreñaFina,
                        precioHojiblancaGruesa, precioHojiblancaFina);

                JOptionPane.showMessageDialog(null, resultado);

            } while (condiciones);

        }

    }
}
