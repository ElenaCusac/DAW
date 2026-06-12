package daw;

import java.util.Scanner;

public class ParteB {
    public static void main(String[] args) {
        /* B. Pirámide de números. Genera un pirámide de números como esta.
            1
            22
            333
            4444
            55555
            666666 
        */

        // La pirámide tendrá tantos pisos como decida el usuario, de 1 a 10.

        System.out.println("Introduce la altura de la pirámide (1-10):");
        Scanner  teclado = new Scanner(System.in);
        int altura = teclado.nextInt();

        if (1 <= altura && altura <= 10) {
            System.out.println("------------------------------------------------");
            for (int i = 1; i <= altura; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(i);
                }
                System.out.println();
            }
        } else {
            System.out.println("Altura incorrecta.");
            System.out.println("Por favor, introduce un número entre 1 y 10.");
        }

        teclado.close();
        
    }
}