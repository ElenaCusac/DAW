package aceptaelreto.Volumen1;

import java.util.Arrays;
import java.util.Scanner;

public class p100 {

    static Scanner in = new Scanner(System.in);

    public static void casoDePrueba() {

        int numero = in.nextInt();

        // Si ya es 6174
        if (numero == 6174) {
            System.out.println(0);
            return;
        }

        String cadena = String.format("%04d", numero);

        // Comprobar si es repdigit
        if (cadena.charAt(0) == cadena.charAt(1)
                && cadena.charAt(1) == cadena.charAt(2)
                && cadena.charAt(2) == cadena.charAt(3)) {

            System.out.println(8);
            return;
        }

        int contador = 0;
        int actual = numero;

        while (actual != 6174) {

            String s = String.format("%04d", actual);
            char[] cifras = s.toCharArray();

            Arrays.sort(cifras);

            int asc = Integer.parseInt(new String(cifras));

            StringBuilder sb = new StringBuilder(new String(cifras));
            int desc = Integer.parseInt(sb.reverse().toString());

            actual = desc - asc;
            contador++;
        }

        System.out.println(contador);
    }

    public static void main(String[] args) {

        int numCases = in.nextInt();

        for (int i = 0; i < numCases; i++) {
            casoDePrueba();
        }
    }
}