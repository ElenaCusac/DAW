package daw;

import java.util.Random;
import java.util.Arrays;

public class Ejercicio2 {
    public static void main(String[] args) {
        
        // Crea dos matrices de NxM con números aleatorios entre 1 y 9.
        // En un método que recibe las dos matrices, suma los elementos que ocupan las mismas posiciones 
        // en ambas matrices y guarda el resultado en una nueva matriz, en la misma posición y devuelve
        // el resultado. Imprime el resultado.

        // Crear las matrices
        int[][] matriz1 = new int[5][6];
        int[][] matriz2 = new int[5][6];

        // Rellenar las matrices con números aleatorios
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                matriz1[i][j] = new Random().nextInt(1, 10); 
                matriz2[i][j] = new Random().nextInt(1, 10); 
            }
        }

        // Mostrar la matriz 1
        System.out.println("Matriz 1: ");
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                System.out.print(" " + matriz1[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // Mostrar la matriz 2
        System.out.println("Matriz 2: ");
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                System.out.print(" " + matriz2[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        int[][] matrizSumada = sumarPosiciones(matriz1, matriz2);

        // Mostrar la matriz sumada resultante
        System.out.println("Las dos matrices sumadas dan como resultado: ");
        for (int i = 0; i < matrizSumada.length; i++) {
            for (int j = 0; j < matrizSumada[i].length; j++) {
                System.out.print(" " + matrizSumada[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] sumarPosiciones(int[][] matriz1, int[][] matriz2){
        int[][] matrizSuma = new int[5][6];

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                matrizSuma[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return matrizSuma;
    }
}
