package daw;

import java.util.Scanner;

public class ParteD {
    public static void main(String[] args) {
        // D. Pedir un día, un mes y un año. Si la fecha introducida es incorrecta, solicitar de nuevo los datos. 
        // Hay que tener en cuenta los años bisiestos. 
        // Por ejemplo, 32 de enero 1998 es una fecha incorrecta, 31 septiembre de 1996 es incorrecta, 29 febrero de 2025 es incorrecta, etc.

        Scanner teclado = new Scanner(System.in);
        int dia, mes, year;
        
        while (true) {
            // Solicitar fecha
            System.out.println("Introduce un día:");
            dia = teclado.nextInt();
            System.out.println("Introduce un mes (1-12):");
            mes = teclado.nextInt();
            System.out.println("Introduce un año:");
            year = teclado.nextInt();

            boolean esBisiesto = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            boolean fechaValida = true;

            if (mes < 1 || mes > 12) {
                fechaValida = false;
            } else {
                // Casos erróneos según el mes 
                switch (mes) {
                    case 2:
                        if (esBisiesto) {
                            if (dia < 1 || dia > 29) {
                                fechaValida = false;
                            }
                        } else {
                            if (dia < 1 || dia > 28) {
                                fechaValida = false;
                            }
                        }
                        break;
                    case 4: case 6: case 9: case 11:
                        if (dia < 1 || dia > 30) {
                            fechaValida = false;
                        }
                        break;
                    default:
                        if (dia < 1 || dia > 31) {
                            fechaValida = false;
                        }
                        break;
                }
            }

            if (fechaValida) {
                System.out.println("Fecha correcta: " + dia + "/" + mes + "/" + year);
                break;
            } else {
                System.out.println("Fecha incorrecta. Por favor, inténtalo de nuevo.");
            }
        }
        teclado.close();
    }

}
