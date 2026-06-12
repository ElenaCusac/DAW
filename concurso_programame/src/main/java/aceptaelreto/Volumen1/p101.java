package aceptaelreto.Volumen1;

import java.util.Scanner;

public class p101 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            int n = sc.nextInt();

            if (n == 0)
                break;

            long[][] m = new long[n][n];
            boolean[] usados = new boolean[n * n + 1];

            boolean numerosCorrectos = true;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    long valor = sc.nextLong();
                    m[i][j] = valor;

                    if (valor < 1 || valor > (long) n * n || usados[(int) valor]) {
                        numerosCorrectos = false;
                    } else {
                        usados[(int) valor] = true;
                    }
                }
            }

            long CM = 0;

            for (int j = 0; j < n; j++)
                CM += m[0][j];

            boolean diabolico = true;

            // Filas
            for (int i = 0; i < n && diabolico; i++) {
                long suma = 0;
                for (int j = 0; j < n; j++)
                    suma += m[i][j];

                if (suma != CM)
                    diabolico = false;
            }

            // Columnas
            for (int j = 0; j < n && diabolico; j++) {
                long suma = 0;
                for (int i = 0; i < n; i++)
                    suma += m[i][j];

                if (suma != CM)
                    diabolico = false;
            }

            // Diagonal principal
            if (diabolico) {
                long suma = 0;
                for (int i = 0; i < n; i++)
                    suma += m[i][i];

                if (suma != CM)
                    diabolico = false;
            }

            // Diagonal secundaria
            if (diabolico) {
                long suma = 0;
                for (int i = 0; i < n; i++)
                    suma += m[i][n - 1 - i];

                if (suma != CM)
                    diabolico = false;
            }

            if (!diabolico) {
                System.out.println("NO");
                continue;
            }

            // Para ser esotérico también deben estar exactamente los números 1..n²
            if (!numerosCorrectos) {
                System.out.println("DIABOLICO");
                continue;
            }

            long CM2 = (4 * CM) / n;

            boolean esoterico = true;

            // Esquinas
            long esquinas = m[0][0] + m[0][n - 1] + m[n - 1][0] + m[n - 1][n - 1];

            if (esquinas != CM2)
                esoterico = false;

            if (esoterico) {

                if (n % 2 == 1) {

                    int c = n / 2;

                    // Centro
                    if (4 * m[c][c] != CM2)
                        esoterico = false;

                    // Mitad de los lados
                    long lados = m[0][c] + m[c][0] + m[c][n - 1] + m[n - 1][c];

                    if (lados != CM2)
                        esoterico = false;

                } else {

                    int a = n / 2 - 1;
                    int b = n / 2;

                    // Centro
                    long centro = m[a][a] + m[a][b] + m[b][a] + m[b][b];

                    if (centro != CM2)
                        esoterico = false;

                    // Centros de los lados
                    long lados = 0;

                    // Superior
                    lados += m[0][a] + m[0][b];

                    // Inferior
                    lados += m[n - 1][a] + m[n - 1][b];

                    // Izquierdo
                    lados += m[a][0] + m[b][0];

                    // Derecho
                    lados += m[a][n - 1] + m[b][n - 1];

                    if (lados != 2 * CM2)
                        esoterico = false;
                }
            }

            if (esoterico)
                System.out.println("ESOTERICO");
            else
                System.out.println("DIABOLICO");
        }

        sc.close();
    }
}