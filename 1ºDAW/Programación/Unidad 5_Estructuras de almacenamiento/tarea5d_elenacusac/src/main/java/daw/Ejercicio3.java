package daw;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {
    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        /*
         * Realiza un programa que permita gestionar los asientos de un avión.
         * El avión tendrá 30 filas y 6 columnas. Se debe permitir reservar un asiento
         * ("R"), o liberarlo ("L"), según su identificador (1A, 3B...), que es un
         * String.
         * Las butacas se identifican mediante su fila (1,2,3,4,5...30) y su columna
         * (A,B, C, D, E, F).
         * A la hora de imprimir el estado de los asientos hay que seguir el siguiente
         * esquema:
         * 
        * A B C D ...
        * 1 L R L L
        * 2 R R R L
        * 3 ....
         */

        // Crear la matriz de asientos
        String[][] asientos = new String[30][6];

        // Rellenar la matriz con los identificadores de los asientos
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (i == 0 && j >= 0) {
                    int letra = 65;
                    asientos[i][j] = (char) (letra + j) + "";
                } else if (j == 0 && i > 0) {
                    int num = 0;
                    num = i;
                    asientos[i][j] = (num) + "";
                } else {
                    asientos[i][j] = "L";
                }
            }
        }

        // Mostrar la matriz de asientos
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print("   " + asientos[i][j]);
            }
            System.out.println();
        }

        // Menú de opciones
        String menu = """
                ------------------------------------------------------
                        ~ Sistema de asientos de avión ~

                ¿Qué quieres hacer? Selecciona el número de la opción:
                    1. Reservar un asiento.
                    2. Cancelar la reserva de un asiento.
                    3. Mostrar todos los asientos
                    4. Salir

                """;

        boolean salir = false;

        do {
            try {
                System.out.println(menu);
                int opcion = teclado.nextInt();
                System.out.println("------------------------------------------------------");
                teclado.nextLine();

                // Validar que la opción está entre 1 y 4
                if (opcion < 1 || opcion > 4) {
                    System.out.println();
                    System.out.println("No has introducido una opción correcta. Vuelve a intentarlo.");
                    salir = false;
                }

                // Switch para las opciones del menú
                switch (opcion) {
                    case 1:
                        opcion1(asientos);
                        break;

                    case 2:
                        opcion2(asientos);
                        break;

                    case 3:
                        mostrarMatriz(asientos);
                        break;

                    case 4:
                        salir = true;
                        break;
                }

            } catch (IllegalArgumentException iae) {
                System.out.println("No has introducido un número. Vuelve a intentarlo.");
                salir = false;
            } catch (InputMismatchException ime) {
                System.out.println("No has introducido un número. Vuelve a intentarlo.");
                salir = false;
            }

        } while (!salir);
    }

    public static void mostrarMatriz(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("   " + matriz[i][j]);
            }
            System.out.println();
        }
    }

    public static void opcion1(String[][] matriz) {
        System.out.println("Introduce el asiento que quieres reservar: ");
        String reser = teclado.nextLine().trim().toUpperCase();

        String reserva = reser.trim().toUpperCase();

        // Buscar el asiento en la matriz, por ejemplo, 12B, y reservarlo si está libre
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i > 0 && j > 0) {
                    String asiento = matriz[i][0] + matriz[0][j];
                    if (asiento.equals(reserva)) {
                        if (matriz[i][j].equals("L")) {
                            matriz[i][j] = "R";
                            System.out.println("Asiento " + reserva + " reservado correctamente.");
                        } else {
                            System.out.println("El asiento " + reserva + " ya está reservado.");
                        }
                    }
                }
            }
        }
    }

    public static void opcion2(String[][] matriz) {
        System.out.println("Introduce el asiento que quieres cancelar: ");
        String cancel = teclado.nextLine().trim().toUpperCase();

        String cancelacion = cancel.trim().toUpperCase();

        // Buscar el asiento en la matriz, por ejemplo, 12B, y reservarlo si está libre
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i > 0 && j > 0) {
                    String asiento = matriz[i][0] + matriz[0][j];
                    if (asiento.equals(cancelacion)) {
                        if (matriz[i][j].equals("R")) {
                            matriz[i][j] = "L";
                            System.out.println("Asiento " + cancelacion + " cancelado correctamente.");
                        } else {
                            System.out.println("El asiento " + cancelacion + " ya está libre.");
                        }
                    }
                }
            }
        }
    }
}

