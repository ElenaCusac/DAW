package daw;

import java.time.DateTimeException;
import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio5 {
    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        /*
         * Realiza un programa que permita gestionar las temperaturas anuales de una
         * localidad cualquiera.
         * Las temperaturas válidas están entre -199.9 grados celsius y 199.9.
         * 
         * Hay que tener en cuenta que no se pueden gestionar datos en casillas no
         * válidas (por ejemplo, abril tiene 30 días, febrero 28 ó 29, etc). Controla
         * las coordenadas para no provocar excepciones.
         * 
         * En una clase con el método main, solicita al usuario los datos de una
         * localidad y un año por teclado. Crea un menú para guardar, borrar o mostrar
         * datos. Este menú se repite hasta que se decida salir.
         */

        boolean salir;
        String menu = """

                ~ Menú de gestión de temperaturas ~

                ¿Qué quieres hacer? Selecciona una opción:
                1. Guardar temperatura
                2. Borrar temperatura
                3. Mostrar temperaturas de una localidad y año
                4. Mostrar temperaturas de un mes
                5. Mostrar temperaturas de un día
                6. Salir

                """;

        System.out.println("Introduce el nombre de una localidad: ");
        String localidad = teclado.nextLine();

        System.out.println();
        Year anio = pedirAnio();

        Temperaturas matrizTemperaturas = new Temperaturas(localidad, anio);

        do {
            salir = false;
            teclado.nextLine();
            try {
                System.out.println(menu);
                int opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        // Introducir el mes
                        int mes = pedirMes();

                        // Introducir el día
                        int dia = pedirDiaSegunMes(mes);

                        Coordenadas fechaCaso1 = new Coordenadas(mes - 1, dia - 1);

                        System.out.println("Introduce la temperatura: ");
                        double temperatura = pedirTemperatura();

                        matrizTemperaturas.guardarTemperatura(fechaCaso1, temperatura);

                        break;
                    case 2:
                        // Introducir el mes
                        int mesCaso2 = pedirMes();

                        // Introducir el día
                        int diaCaso2 = pedirDiaSegunMes(mesCaso2);

                        Coordenadas fechaCaso2 = new Coordenadas(mesCaso2 - 1, diaCaso2 - 1);

                        matrizTemperaturas.borrarTemperatura(fechaCaso2);
                        break;
                    case 3:
                        matrizTemperaturas.mostrarTemperaturas();
                        break;
                    case 4:
                        int mesCaso4 = pedirMes();
                        matrizTemperaturas.mostrarTemperaturaMes(mesCaso4 - 1);
                        break;
                    case 5:
                        int diaCaso5 = pedirDia();

                        matrizTemperaturas.mostrarTemperaturaDia(diaCaso5 - 1);
                        break;
                    case 6:
                        salir = true;
                        break;

                    default:
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println("Has introducido un valor no válido. Inténtalo de nuevo.");
            } catch (InputMismatchException ime) {
                System.out.println("Has introducido un valor no válido. Inténtalo de nuevo.");
            }
        } while (!salir);

    }

    // Función que pide al usuario que introduzca un mes
    public static int pedirMes() {
        boolean salir = false;
        int mes = 0;

        do {
            teclado.nextLine();
            try {
                System.out.println("-----------------------------------------------------");
                System.out.println("Introduce el número del mes: ");
                mes = teclado.nextInt();
                System.out.println("-----------------------------------------------------");

                salir = true;
                if (mes > 12 || mes < 1) {
                    System.out.println();
                    System.out.println("Has introducido un mes que no existe. Vuelve a intentarlo.");
                    salir = false;
                }

            } catch (IllegalArgumentException iae) {
                System.out.println();
                System.out.println("Has introducido un valor no válido. Inténtalo de nuevo.");
            } catch (InputMismatchException ime) {
                System.out.println();
                System.out.println("Has introducido un valor no válido. Inténtalo de nuevo.");
            }
        } while (!salir);

        return mes;
    }

    // Función que pide al usuario que introduzca un día en función del mes
    public static int pedirDiaSegunMes(int mes) {
        boolean salir = false;
        int dia = 0;
        do {
            teclado.nextLine();
            try {
                System.out.println("-----------------------------------------------------");
                System.out.println("Introduce el día para poder registrar su temperatura: ");
                dia = teclado.nextInt();
                System.out.println("-----------------------------------------------------");

                salir = true;
                if (mes % 2 == 0) {
                    if (dia > 31 || dia < 1) {
                        System.out.println();
                        System.out.println("Has introducido un día que no existe. Vuelve a intentarlo.");
                        salir = false;
                    }
                } else if (mes == 2) {
                    if (dia > 28 || dia < 1) {
                        System.out.println("Has introducido un día que no existe. Vuelve a intentarlo.");
                        salir = false;
                    }
                } else if (mes % 2 != 0) {
                    if (dia > 30 || dia < 1) {
                        System.out.println("Has introducido un día que no existe. Vuelve a intentarlo.");
                        salir = false;
                    }
                } else if (mes > 12 || mes < 1) {
                    System.out.println("Has introducido un mes que no existe. Vuelve a intentarlo.");
                    salir = false;
                }

            } catch (IllegalArgumentException iae) {
                System.out.println("Has introducido un valor no válido. Inténtalo de nuevo.");
            } catch (InputMismatchException ime) {
                System.out.println("Has introducido un valor no válido. Inténtalo de nuevo.");
            }
        } while (!salir);
        return dia;
    }

    // Función que pide al usuario que introduzca un día independientemente del mes
    public static int pedirDia() {
        boolean salir = false;
        int dia = 0;
        do {
            teclado.nextLine();
            try {
                System.out.println("-----------------------------------------------------");
                System.out.println("Introduce el día para poder registrar su temperatura: ");
                dia = teclado.nextInt();
                System.out.println("-----------------------------------------------------");

                salir = true;
                if (dia > 31 || dia < 1) {
                    System.out.println("Has introducido un día que no existe. Vuelve a intentarlo.");
                    salir = false;
                }

            } catch (IllegalArgumentException iae) {
                System.out.println("Has introducido un valor no válido. Inténtalo de nuevo.");
            } catch (InputMismatchException ime) {
                System.out.println("Has introducido un valor no válido. Inténtalo de nuevo.");
            }
        } while (!salir);
        return dia;
    }

    // Función que pide al usuario introducir la temperatura
    public static double pedirTemperatura() {
        boolean salir = false;
        double temperatura = 0;

        do {
            try {
                System.out.println("-----------------------------------------------------");
                System.out.println("Introduce la temperatura: ");
                temperatura = teclado.nextDouble();
                System.out.println("-----------------------------------------------------");

                salir = true;
                if (temperatura > 199.9 || temperatura < -199.9) {
                    System.out.println("Has introducido una temperatura inalcanzable. Vuelve a intentarlo.");
                    salir = false;
                }

            } catch (IllegalArgumentException iae) {
                System.out.println("Has introducido un valor no válido. Inténtalo de nuevo.");
            } catch (InputMismatchException ime) {
                System.out.println("Has introducido un valor no válido. Inténtalo de nuevo.");
            }
        } while (!salir);

        return temperatura;
    }

    // Función que pide el año al usuario
    public static Year pedirAnio() {
        boolean salir = true;
        Year anio = Year.of(0);

        do {
            try {
                System.out.println();
                System.out.println("Introduce un año: ");
                anio = Year.of(teclado.nextInt());
            } catch (DateTimeException e) {
                System.out.println("No has introducido un año correcto. Vuelve a intentarlo.");
                salir = false;
            }
        } while (!salir);

        return anio;
    }
}
