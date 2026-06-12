package paqueteb;

import java.util.Scanner;

public class Main {
    public static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        
        /*
         * Implementa en una estructura de tipo map un sistema de almacenamiento de
         * números de décimos de lotería nacional y su premio asociado.
         * 
         * Inserta en la estructura 1000 registros, inventando los números de los
         * décimos y el premio asociado.
         * 
         * Ten en cuenta que el número de décimo debe contemplar ceros a la izquierda
         * (09876, 00234, ...).
         * 
         * La aplicación debe ofrecer al usuario la posibilidad de consultar por número
         * de décimo el premio obtenido.
         */


        Loteria l1 = new Loteria();

        boolean continuar = true; 
        String menu = """

                        ~ Menú ~
                
                ¿Qué quieres hacer? Selecciona el número de la opción:

                1. Ver el premio de tu número.
                2. Ver todos los números premiados.
                3. Salir

                """;

        do {
            System.out.println(menu);
            int opcion = teclado.nextInt();
            try {
                teclado.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println();
                        System.out.println("Introduce el número de tu lotería (recuerda que debe tener 5 cifras, incluyendo ceros a la izquierda): ");
                        String numero = teclado.nextLine();
                        System.out.println("-------------------------------------------------------------");
                        System.out.println(l1.consultarPremio(numero));
                        System.out.println("-------------------------------------------------------------");

                        break;
                    case 2:
                        l1.mostrarNumerosPremiados();
                        break;
                    case 3:
                        continuar = false;                       
                        break;
                
                    default:
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println("Has introducido un número erróneo. Vuelve a introducirlo.");
            }
        } while (continuar);
    }
}
