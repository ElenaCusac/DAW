package daw;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random nAleatorio = new Random();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el tamaño del array: ");
        int tamanio = teclado.nextInt();
        System.out.println("------------------------------");

        int[] arrayDesordenado = new int[tamanio];

        for (int i = 0; i < tamanio; i++) {
            int numAleatorio = nAleatorio.nextInt(1, 26);
            arrayDesordenado[i] = numAleatorio;
        }

        System.out.println("El array con los números desordenados es: " + Arrays.toString(arrayDesordenado));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("El array ordenado es: " + Arrays.toString(ordenarArray(arrayDesordenado)));

    }

    public static int[] ordenarArray(int[] arrayDesordenado) {
        int[] arrayOrdenado = new int[arrayDesordenado.length];

        // Doble bucle para ordenar el array
        for (int i = 0; i < arrayDesordenado.length; i++) {
            for (int j = 0; j < arrayDesordenado.length; j++) {

                if (arrayDesordenado[i] < arrayDesordenado[j]) {
                    // Intercambiamos los valores
                    int temp = arrayDesordenado[i];
                    arrayDesordenado[i] = arrayDesordenado[j];
                    arrayDesordenado[j] = temp;
                }
            }
        }

        // Copiamos el array ya ordenado
        for (int i = 0; i < arrayDesordenado.length; i++) {
            arrayOrdenado[i] = arrayDesordenado[i];
        }

        return arrayOrdenado;
    }
}

