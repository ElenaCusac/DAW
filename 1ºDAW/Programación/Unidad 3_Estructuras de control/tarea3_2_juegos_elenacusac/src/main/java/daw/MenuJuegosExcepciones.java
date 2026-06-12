package daw;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MenuJuegosExcepciones {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int jugador1 = 0, jugador2 = 0, opcion = 0;
        boolean condiciones = true;
        Random numAleatorio = new Random();
        int nAleatorio1, nAleatorio2;

        String enunciado = """
                ~ Menú ~

                Elige a qué quieres jugar:

                1. Piedra, papel o tijera
                2. Pare o none
                3. Salir

                """;

        System.out.println(enunciado);

        do {
            try {
                System.out.println("Introduce una opción (1-3): ");
                opcion = teclado.nextInt();

                if (opcion == 1) {
                    boolean repetir = true;
                    do {
                        String enunciado1 = """
                                ~ Juego de piedra, papel o tijera ~

                                Elige el número de la opción con la que quieres jugar:

                                1. Piedra
                                2. Papel
                                3. Tijera

                                """;

                        try {
                            int opcion1 = Integer.parseInt(JOptionPane.showInputDialog(enunciado1));
                            nAleatorio2 = numAleatorio.nextInt(1, 4);

                            if (opcion1 == 1) {
                                JOptionPane.showMessageDialog(null, "Has elegido piedra");
                                if (opcion1 == nAleatorio2) {
                                    JOptionPane.showMessageDialog(null, "Ha habido un empate");
                                } else if (nAleatorio2 == 2) {
                                    JOptionPane.showMessageDialog(null, "Por desgracia, has perdido");
                                } else {
                                    JOptionPane.showMessageDialog(null, "¡Enhorabuena, has ganado!");
                                }
                                repetir = false;

                            } else if (opcion1 == 2) {
                                JOptionPane.showMessageDialog(null, "Has elegido papel");
                                if (opcion1 == nAleatorio2) {
                                    JOptionPane.showMessageDialog(null, "Ha habido un empate");
                                } else if (nAleatorio2 == 3) {
                                    JOptionPane.showMessageDialog(null, "Por desgracia, has perdido");
                                } else {
                                    JOptionPane.showMessageDialog(null, "¡Enhorabuena, has ganado!");
                                }
                                repetir = false;

                            } else if (opcion1 == 3) {
                                JOptionPane.showMessageDialog(null, "Has elegido tijeras");
                                if (opcion1 == nAleatorio2) {
                                    JOptionPane.showMessageDialog(null, "Ha habido un empate");
                                } else if (nAleatorio2 == 1) {
                                    JOptionPane.showMessageDialog(null, "Por desgracia, has perdido");
                                } else {
                                    JOptionPane.showMessageDialog(null, "¡Enhorabuena, has ganado!");
                                }
                                repetir = false;

                            } else {
                                JOptionPane.showMessageDialog(null, "Error al introducir el número. Debe estar entre 1 y 3.");
                            }

                        } catch (NumberFormatException nfe) {
                            System.out.println("Excepción leyendo número en JOption.");
                            System.out.println("Recuerda introducir un número entero válido.");
                        }

                    } while (repetir);
                }

                else if (opcion == 2) {
                    jugador1 = 0;
                    jugador2 = 0;

                    while (jugador1 < 2 && jugador2 < 2) {
                        teclado.nextLine();
                        System.out.println("Jugador 1 - Elige pare o none: ");
                        String pareONone = teclado.nextLine().trim();

                        nAleatorio1 = numAleatorio.nextInt(1, 11);
                        System.out.println("-------------------------------");

                        if (pareONone.equalsIgnoreCase("pare")) {
                            System.out.println("El jugador 1 es pare.");
                            System.out.println("El jugador 2 es none.");
                            System.out.println("-------------------------------");

                            if (nAleatorio1 % 2 == 0) {
                                jugador1++;
                                System.out.println("Ha salido el número: " + nAleatorio1);
                                System.out.println("El jugador 1 ha ganado esta partida");
                            } else {
                                jugador2++;
                                System.out.println("Ha salido el número: " + nAleatorio1);
                                System.out.println("El jugador 2 ha ganado esta partida");
                            }

                        } else if (pareONone.equalsIgnoreCase("none")) {
                            System.out.println("El jugador 1 es none.");
                            System.out.println("El jugador 2 es pare.");
                            System.out.println("-------------------------------");

                            if (nAleatorio1 % 2 == 0) {
                                jugador2++;
                                System.out.println("Ha salido el número: " + nAleatorio1);
                                System.out.println("El jugador 2 ha ganado esta partida");
                            } else {
                                jugador1++;
                                System.out.println("Ha salido el número: " + nAleatorio1);
                                System.out.println("El jugador 1 ha ganado esta partida");
                            }

                        } else {
                            System.out.println("Error al introducir el dato. Debes escribir 'pare' o 'none'.");
                            continue;
                        }

                        if (jugador1 == 2) {
                            System.out.println();
                            System.out.println("El ganador del juego es el jugador 1.");
                            break;
                        } else if (jugador2 == 2) {
                            System.out.println();
                            System.out.println("El ganador del juego es el jugador 2.");
                            break;
                        }
                    }
                }

                else if (opcion == 3) {
                    System.out.println("Fin del programa.");
                    condiciones = false;
                }

                else {
                    System.out.println("Opción incorrecta. Debe ser 1, 2 o 3.");
                }

            } catch (InputMismatchException ime) {
                System.out.println("Error al introducir el dato.");
                System.out.println("Recuerda que debes introducir un número entero sin letras.");
                teclado.nextLine(); // limpiar buffer
            }

        } while (condiciones);

        teclado.close();
    }
}
