package elenacusacortigosa;

import java.util.Scanner;

public class Tarea3a {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        //Menu 
        String menu = """
                -Menu-
                
                Elige que función quieres inicializar: 

                1. Introduce un número y determina si es par o impar.
                2. Introduce dos números enteros y determina cuál es el mayor.
                3. Introduce un número entre 0 y 100 que representa una calificación, imprimir.
                4. Introduce un número entero e imprime si el número es positivo, negativo o cero. 
                5. Determinar si un año es bisiesto. 
                """;

        System.out.println(menu);
        int opcion = teclado.nextInt();

        //Estructura if principal
        if (opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4 || opcion == 5) {

            //Opción 1.-  Pide un número y determina si es par o impar.
            if (opcion == 1) {
                System.out.println("Introduce un número: ");
                double num1 = teclado.nextDouble();
                if (num1%2 == 0) {
                    System.out.println("El número " + num1 + " es par.");
                } else {
                     System.out.println("El número " + num1 + " es impar.");
                }
            
            //Operador ternario en la Opción 1
                String resultado = (num1 % 2 == 0) ? "par" : "impar";
                System.out.println("(ternario) El número " + num1 + " es " + resultado + ".");
            
            // Opción 2.-  Pide al usuario dos números enteros y determina cuál es el mayor.
            } else if (opcion == 2) {
                System.out.println("Introduce un primer número: ");
                int num1 = teclado.nextInt();
                System.out.println("Introduce un segundo número: ");
                int num2 = teclado.nextInt();

                if (num1 > num2) {
                    System.out.println("El número más grande es: " +num1);
                } else if (num1 < num2){
                    System.out.println("El número más grande es: " +num2);
                } else {
                    System.out.println("Los números son iguales");
                }

            // Operador ternario en la Opción 2
                String mayor = (num1 == num2) ? "Ambos son iguales." :
                               (num1 > num2) ? "El número mayor es: " + num1 :
                               "El número mayor es: " + num2;
                System.out.println("(ternario) " + mayor);

            //Opción 3.-  Pide un número entre 0 y 100 que representa una calificación, imprimir:
            // “Aprobado” si la nota es mayor o igual a 60.
            // “Suspenso” en caso contrario.
            }else if (opcion == 3) {
                System.out.println("Introduce un número entre 0 y 100: ");
                double num = teclado.nextDouble();
                if (num >= 0 && num < 60) {
                    System.out.println("Tu nota es de " +num+ " puntos y estás suspenso.");
                } else if (num >= 60 && num < 100){
                    System.out.println("Tu nota es de " +num+ " puntos y estás aprobado.");
                } else {
                    System.out.println("Error al introducir el dato.");
                }

                // Operador ternario en la Opción 3
                    String estado = (num >= 60) ? "aprobado" : "suspenso";
                    System.out.println("(ternario) Tu nota es de " + num + " puntos y estás " + estado + ".");

            // Opción 4.-  Pide un número entero e imprime si el número es positivo, negativo o cero. 
            //En este caso debes anidar el operador ternario.
            }else if (opcion == 4) {
                System.out.println("Introduce un número entero: ");
                int num = teclado.nextInt();
                
                if (num>0) {
                    System.out.println("El número " +num+ " es positivo.");
                } else if (num<0) {
                    System.out.println("El número " +num+ " es negativo.");
                }else {
                    System.out.println("El número es 0.");
                }

                // Operador ternario anidado en la Opción 4
                String tipo = (num > 0) ? "positivo" : ((num < 0) ? "negativo" : "cero");
                System.out.println("(ternario) El número " + num + " es " + tipo + ".");

            // Opción 5.-  Determinar si un año es bisiesto. 
            // Un año es bisiesto si es divisible por 400 o es divisible por 4 y no es divisible por 100.
            }else if (opcion == 5) {
                System.out.println("Introduce el número de días que tiene el año: ");
                int num = teclado.nextInt();

                if (num%2 == 0) {
                    System.out.println("El año es bisiesto.");
                } else if (num%2 != 0) {
                    System.out.println("El año no es bisiesto.");
                } else {
                    System.out.println("Error al introducir el número de días");
                }

                // Operador ternario en la Opción 5
                String bisiesto = ((num % 400 == 0) || (num % 4 == 0 && num % 100 != 0))
                        ? "es bisiesto" : "no es bisiesto";
                System.out.println("(ternario) El año " + num + " " + bisiesto + ".");
                
            } else {
            System.out.println("Error al introducir el dato. Introduce un número entero del 1 al 5");
        }
        teclado.close();
    }
}
}