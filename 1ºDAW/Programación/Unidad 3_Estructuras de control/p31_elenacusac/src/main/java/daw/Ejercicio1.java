package daw;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        /* Primero le hemos pedido al usuario que introduzca un número entre 1 y 99.999
         * Luego limpiamos el teclado para introducir una parabra o frase (String)
         * Le pedimos al usuario que introduzca su nombre
         * Mediante la estructura if comprobamos si el número introducido está entre 1 y 99999
         * Si es así, el programa muestra el nombre introducido, el número y su longitud
         * Si no es así, muestra un error al introducir el dato
         */
        
        System.out.println("Introduce un número entre 1 y 99999: ");
        int num = teclado.nextInt();

        teclado.nextLine();

        System.out.println("Introduce tu nombre: ");
        String nombre = teclado.nextLine();

        int contador = 0;
        int copia = num; 

        if (num == 0) {
            contador = 1;
        } else if (num < 1) {
            System.out.println("Error al introducir el número");    
            System.out.println("El número debe estar entre 1 y 99999.");   
        } else {
            do {
                contador++;
                copia = copia/10;
            } while (copia > 0);
        }

        if (1 <= num && num <= 99999) {
            System.out.println("Hola, soy " + nombre + ", el número es " + num + " y tengo " + contador + " cifra/s");
            
        } else {
            System.out.println("Error al introducir el dato.");
            System.out.println("El número debe estar entre 1 y 99999.");
        }

        teclado.close();
    }
}