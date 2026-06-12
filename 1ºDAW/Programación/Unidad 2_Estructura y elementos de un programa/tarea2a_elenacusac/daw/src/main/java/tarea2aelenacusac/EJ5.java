package tarea2aelenacusac;

import javax.swing.JOptionPane;

// Nombre: Elena cusac Ortigosa

public class EJ5 {
    public static void main(String[] args) {

        /* Realiza un programa que calcule la distancia entre dos puntos en un plano cartesiano. 
        Para ello solicita los datos de tipo int (x,y) de cada punto y realiza los cálculos
        de la distancia entre ambos con la ayuda del Teorema de Pitágoras.
        Usando variables booleanas, muestra el resultado de evaluar si todas las dimensiones
        introducidas por el usuario están entre -10 y 10. 
        */

        // Solicitar coordenadas al usuario
        String x1Str = JOptionPane.showInputDialog("Introduce la coordenada x1 (-10 a 10):");
        String y1Str = JOptionPane.showInputDialog("Introduce la coordenada y1 (-10 a 10):");
        String x2Str = JOptionPane.showInputDialog("Introduce la coordenada x2 (-10 a 10):");
        String y2Str = JOptionPane.showInputDialog("Introduce la coordenada y2 (-10 a 10):");

        //Pasar los strings a números
        int x1 = Integer.parseInt(x1Str);
        int y1 = Integer.parseInt(y1Str);
        int x2 = Integer.parseInt(x2Str);
        int y2 = Integer.parseInt(y2Str);

        //Calcular la distancia de los puntos con el Teorema de Pitágoras
        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        //Evaluar si todas las coordenadas están entre -10 y 10
        boolean dentroRango = (x1 >= -10 && x1 <= 10) &&
                              (y1 >= -10 && y1 <= 10) &&
                              (x2 >= -10 && x2 <= 10) &&
                              (y2 >= -10 && y2 <= 10);

        //Mostrar resultados
        String resultadoAlgoritmo = """
                La distancia entre los puntos 
                P1(%d, %d) y P2(%d, %d) es de %.2f unidades.
                
                ¿Todas las coordenadas están entre -10 y 10?
                %s
                """.formatted(x1, y1, x2, y2, distancia, dentroRango);

        JOptionPane.showMessageDialog(null, resultadoAlgoritmo);
    }
}





    


