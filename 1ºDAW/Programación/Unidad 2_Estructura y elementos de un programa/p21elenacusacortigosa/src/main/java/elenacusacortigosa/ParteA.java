package elenacusacortigosa;

import java.util.Scanner;

public class ParteA {
    public static void main (String[] args) {

        //Definición de la constante
        final float pReparacion = 32.6f;

        //Insertar las reparaciones hechas cada día
        Scanner teclado = new Scanner(System.in);

        //Lunes
        System.out.println("Introduce los productos totales reparados el lunes: ");
        int prodLunes = teclado.nextInt();
        //Martes
        System.out.println("Introduce los productos totales reparados el martes: ");
        int prodMartes = teclado.nextInt();
        //Miércoles
        System.out.println("Introduce los productos totales reparados el miércoles: ");
        int prodMiercoles = teclado.nextInt();
        //Jueves
        System.out.println("Introduce los productos totales reparados el jueves: ");
        int prodJueves = teclado.nextInt();
        //Viernes
        System.out.println("Introduce los productos totales reparados el viernes: ");
        int prodViernes = teclado.nextInt();

        //Operaciones para ver cuánto se ha cobrado cada día
        //Lunes
        float gananciasLunes = prodLunes * pReparacion;
        System.out.printf("El lunes has tenido unas ganancias de: %.3f%n", gananciasLunes);

        //Martes
        float gananciasMartes = prodMartes * pReparacion;
        System.out.printf("El martes has tenido unas ganancias de: %.3f%n", gananciasMartes);

        //Miércoles
        float gananciasMiercoles = prodMiercoles * pReparacion;
        System.out.printf("El miércoles has tenido unas ganancias de: %.3f%n", gananciasMiercoles);

        //Jueves
        float gananciasJueves = prodJueves * pReparacion;
        System.out.printf("El jueves has tenido unas ganancias de: %.3f%n", gananciasJueves);

        //Viernes
        float gananciasViernes = prodViernes * pReparacion;
        System.out.printf("El viernes has tenido unas ganancias de: %.3f%n", gananciasViernes);

        //Ganancias semanales
        float gananciasSemana = gananciasLunes + gananciasMartes + gananciasMiercoles + gananciasJueves + gananciasViernes;
        System.out.printf("Tus ganancias totales de toda la semana han sido de: %.3f%n", gananciasSemana );
    
        // Comprobar si las ganancias semanales están entre 0 y 3000
        boolean gananciasValidas = gananciasSemana > 0 && gananciasSemana < 3000;
        System.out.println("¿Las ganancias semanales están entre 0 y 3000? " + gananciasValidas);

        teclado.close();
    }
}