package passwords;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.commons.lang3.RandomStringUtils;

public class Main {

    /*
     * En una clase con el método main, implementa una aplicación para generar contraseñas y números pin de móvil.
     *
     * 1. La aplicación tendrá tres opciones: la primera, genera números pin aleatorios para tarjetas SIM
     *  de teléfonos móviles.
     * 
     * 2. La segunda opción genera contraseñas para usuarios de un sistema operativo con 8 caracteres, incluyendo 
     * números y letras.
     *
     * 3. La tercera opción, genera una secuencia de "n" caracteres aleatorios de un conjunto que tú elijas 
     * (debes pasar un array de char de 10 elementos).
     * 
     * El número "n" se debe solicitar por teclado. El programa se repite hasta que el usuario decida salir.
     * 
     * Se deben crear, al menos, tres métodos de clase (funciones) para generar las secuencias de cada opción.
     * 
     */

    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // Enunciado del menú con las cuatro opciones
        String enunciado = """

                ~ Menú de generación de contraseñas y PINs ~

                Selecciona una opción:

                1. Generar número PIN aleatorio (4 dígitos)
                2. Generar contraseña aleatoria (8 caracteres, letras y números)
                3. Generar secuencia aleatoria de 'n' caracteres
                4. Salir

                """;
        int opcion = 0;
        
        do {
            teclado.nextLine(); // Limpiar el buffer
            try {
                System.out.println(enunciado);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1 -> {
                        System.out.println();
                        System.out.println("Número PIN generado: " + generarPin());
                    }
                    case 2 -> {
                        System.out.println();
                        System.out.println("Contraseña generada: " + generarContrasena());
                    }   
                    case 3 -> {
                        System.out.println();
                        System.out.print("Introduce la longitud de la secuencia: ");
                        int n = teclado.nextInt();
                        char[] conjunto = { 'A', 'B', 'C', 'D', 'E', '1', '2', '3', '4', '5' };
                        System.out.println();
                        System.out.println("Secuencia generada: " + generarSecuencia(n, conjunto));
                    }
    
                    default -> System.out.println("Opción no válida. Por favor, selecciona una opción del 1 al 4.");
                }
    
                if (opcion != 4) {
                    System.out.println(enunciado);
                    opcion = teclado.nextInt();
                }


            } catch (InputMismatchException e) {

            }

        } while (opcion != 4);
    }

    public static String generarPin() {
        return RandomStringUtils.randomNumeric(4);
    }


    public static String generarContrasena() {
        return RandomStringUtils.randomAlphanumeric(8); 
    }


    public static String generarSecuencia(int n, char[] conjunto) {
        StringBuilder secuencia = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            int indiceAleatorio = (int) (Math.random() * conjunto.length);
            secuencia.append(conjunto[indiceAleatorio]);
        }

        return secuencia.toString();
    }
}