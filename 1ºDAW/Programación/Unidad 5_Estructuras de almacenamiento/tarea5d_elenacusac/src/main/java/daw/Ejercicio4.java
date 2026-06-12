package daw;

import java.util.Random;

public class Ejercicio4 {
    public static void main(String[] args) {
        /*
         * Implementa una aplicación que genere matrices de NxN (cuadrada) con números
         * aleatorios entre 0 y 1. Se debe poder imprimir la matriz en consola y
         * debe haber un método que busque dentro de la matriz las coordenadas de
         * la primera casilla que encuentre cuyo valor sea cero y esté rodeada de
         * unos en todas las casillas de su alrededor.
         */

        int filas = 8;
        int columnas = 8;
        

        int[][] matriz = new int[filas][columnas];

        // Rellenar matriz con números aleatorios
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = new Random().nextInt(0, 2);
            }
        }

        // Mostrar matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println();
        }

        Coordenadas coordenadasCero = encontrarCeroMalo(matriz);
        System.out.println(coordenadasCero.toString());
    }

    // Método que busca en la matriz si hay algún cero aislado alrededor de 1 (no valen esquinas)
    public static Coordenadas encontrarCeroMalo(int[][] matriz) {
        for (int i = 1; i < matriz.length - 1; i++) {
            for (int j = 1; j < matriz[i].length - 1; j++) {
                // Este if no funciona para los 0 que están en las esquinas
                if (matriz[i][j] == 0 && matriz[i-1][j-1] == 1 && matriz[i-1][j] == 1 && matriz[i-1][j+1] == 1 &&
                    matriz[i][j-1] == 1 && matriz[i+1][j-1] == 1 && matriz[i+1][j] == 1 && matriz[i+1][j+1] == 1 && matriz[i][j+1] == 1)
                    {
                    return new Coordenadas(i, j);
                }
            }
        }
        return new Coordenadas(-1, -1);
    }

}
