package daw;

import java.util.Scanner;

import javax.swing.JOptionPane;

// Nombre: Elena Cusac  Ortigosa

public class Expresiones {
    public static void main(String[] args) {
        //  Lee dos variables int, una usando scanner y otra usando JOption, llamadas num1 y num2.
        //  Muestra los valores introducidos por teclado por el usuario.

        Scanner teclado = new Scanner (System.in);
        //Primer número
        System.out.println("Introduce el primer número: ");
        int num1 = teclado.nextInt();
        System.out.println("Tu primer número es: " + num1);

        //Segundo número
        String num2String = JOptionPane.showInputDialog("Introduce el segundo número: ");
        int num2 = Integer.parseInt(num2String);
        System.out.println("Tu segundo número es: " + num2 + "\n ");

        //a) num1 es mayor que num2 y num1 menos 10 es menor que num2-1.
        boolean a = (num1 > num2) && (num1 - 10 < num2 - 1);
        String resultadoA = """
                        a) El número %s es mayor que el número %s y 
                           el número %s menos 10 es menor que %s-1. 
                           -> %s
                        """. formatted(num1, num2, num1, num2, a);
        System.out.println(resultadoA);

        //b) num1 es par o num2 es par
        boolean b = (num1 % 2 == 0) || (num2 % 2 == 0);
        String resultadoB = """
                        b) El número %s es par o 
                           el número %s es par.
                           -> %s
                        """. formatted(num1, num2, b);
        System.out.println(resultadoB);
        
        //c) num2 es impar y num1 es par
        boolean c = (num1 % 2 == 0) && (num2 % 2 != 0); 
        String resultadoC = """
                        c) El número %s es par y 
                           el número %s es impar.
                           -> %s
                        """. formatted(num1, num2, c);
        System.out.println(resultadoC);

        //d) Al resto de dividir num1 entre 3 se le suma 1. Comprobar que el resultado es igual a 3
        boolean d = (num1 % 3) + 1 == 3;
        String resultadoD = """
                        d) Al resto de dividir el número %s entre 3 se le suma 1. 
                           ¿El resultado es igual a 3?
                           -> %s
                        """. formatted(num1, d);
        System.out.println(resultadoD);

        /* e) 10 es menor o igual que 2 multiplicado por num1 y 3 es menor que 4 
        o 8 no es mayor que 7 y num2 multiplicado por 2 es menor o igual que 4 por 2 menos 1
        */
        boolean e = ((10 <= 2 * num1) && (3 < 4)) || (!(8 > 7) && ((num2 * 2) <= (4 * 2 - 1)));
        String resultadoE = """
                        e) El número 10 es menor o igual que la multiplicación 
                           de 2 y el número %s y 3 es menor que 4 el número 8
                           no es mayor que 7 y el número %s multiplicado por 2 
                           es menor o igual que (4 * 2 - 1).
                           -> %s
                        """. formatted(num1, num2, e);
        System.out.println(resultadoE);

        /*f) El resultado de negar la expresión: num2 es mayor que num1 y 
        dos por num1 menor o igual a num2
        */
        boolean f = !(num2 > num1 && 2 * num1 <= num2);
        String resultadoF = """
                        f) EL número %s es menor o igual que el número %s, 
                           o bien el número %s es mayor o igual que el doble de %s. 
                           -> %s
                        """. formatted(num2, num1, num1, num2, f);
        System.out.println(resultadoF);

        //g) num2/2<num1 y num1++/2>num2
        boolean g = (num2 / 2 < num1) && (num1 ++ / 2 > num2);
        String resultadoG = """
                        g) El número %s dividido entre 2 es menor que el número %s y 
                           el número (%s+1)/2 es mayor que el número %s. 
                           -> %s
                        """. formatted(num2, num1, num1, num2, g);
        System.out.println(resultadoG);

        //h) num1 está entre 15 y 20
        boolean h = (15 < num1) && (num1 < 20);
        String resultadoH = """
                        h) El número %s está entre 15 y 20 
                           -> %s
                        """. formatted(num1,h);
        System.out.println(resultadoH);

        //i) num1 está entre 15 y 20 o num2 es distinto de 7
        boolean i = ((15 < num1) && (num1 < 20)) || (num2 != 7);
        String resultadoI = """
                        i) El número %s está entre 15 y 20 o 
                           el número %s es distinto de 7 
                           -> %s
                        """. formatted(num1, num2, i);
        System.out.println(resultadoI);

        //j) num2 no es 100
        boolean j = num2 != 100;
        String resultadoJ = """
                        j) El número %s es distinto de 100
                           -> %s
                        """. formatted(num2, j);
        System.out.println(resultadoJ);

        //k) num2 no está entre 50 y 100
        boolean k = !((50 < num2) && (num2 < 100));
        String resultadoK = """
                        k) El número %s no está 
                           entre 50 y 100
                           -> %s
                        """. formatted(num2, k);
        System.out.println(resultadoK);

        teclado.close();
    
    }
}