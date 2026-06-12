package daw;

import java.util.Scanner;

public class ParteC {
    public static void main(String[] args) {
        // Hacer un programa que lea una serie de números enteros, precedida del número total de enteros a leer. 
        // El programa debe calcular el total de números pares, el total de números impares, y el promedio de todos los números.

        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Cuántos números vas a introducir?");
        int totalNumeros = teclado.nextInt();

        int contadorPares = 0;
        int contadorImpares = 0;
        int suma = 0;

        for (int i = 0; i < totalNumeros; i++) {
            System.out.println("Introduce un número:");
            int numero = teclado.nextInt();
            suma += numero;

            if (numero % 2 == 0) {
                contadorPares++;
            } else {
                contadorImpares++;
            }
        }

        double promedio = (double) suma / totalNumeros;

        System.out.println("Total de números pares: " + contadorPares);
        System.out.println("Total de números impares: " + contadorImpares);
        System.out.println("Promedio de todos los números: " + promedio);

        teclado.close();
    }
}
