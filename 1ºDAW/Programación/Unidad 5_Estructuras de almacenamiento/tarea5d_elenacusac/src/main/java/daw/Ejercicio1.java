package daw;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio1 {
    public static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        
        // Crea una matriz de números aleatorios entre 1 y 9, de tamaño NxM e imprime el resultado por consola. 
        // Pide al usuario un número entre 1 y 9 y comprueba si está o no en la matriz, indicando su fila y columna.
        // Para ello crea un método que devuelva la fila y columna donde está o -1 -1 si no está en la matriz. 
        // Puedes devolver un array de dos posiciones o bien crea una clase Coordenada para guardar las posiciones i, j.

        // Crear la matriz
        int[][] matriz = new int[3][6];

        // Rellenar la matriz con números aleatorios
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = new Random().nextInt(1, 10); 
            }
        }

        // Mostrar la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println();
        }

        // Pedir un número a buscar
        boolean valido = true;

        int num;        

        do {
            num = -1;
            try {
                System.out.println("Introduce un número del 1 al 10 para buscar en la matriz: ");
                num = teclado.nextInt();

                if (num < 1 || num > 9) {
                    System.out.println("Has introducido un número fuera de rango, vuelve a introducirlo.");
                    valido = false;
                }

            } catch (IllegalArgumentException iae) {
                System.out.println("Has introducido un caracter incorrecto, vuelve a introducirlo");
                teclado.nextLine();
                valido = false;
            }
        } while (!valido);
        

        System.out.println("La primera posición del número " + num + " está en la posición " + Arrays.toString(encontrarNumero(num, matriz)));
        
    }

    // Buscar el número dentro de la matriz
    public static int[] encontrarNumero(int numero, int[][] matriz){
        int[] posiciones = new int[2];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == numero) {
                    posiciones[0] = i;
                    posiciones[1] = j;
                } else {
                    posiciones[0] = -1;
                    posiciones[1] = -1;
                }
            }
        }

        return posiciones;
    }
}