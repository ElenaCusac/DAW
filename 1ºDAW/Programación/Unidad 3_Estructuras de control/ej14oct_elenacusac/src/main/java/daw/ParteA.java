package daw;

public class ParteA {
    public static void main(String[] args) {
        
        //A. Imprimir por pantalla las 10 tablas de multiplicar, del 1 al 10.

        for (int i = 1; i <= 10; i++) {
            System.out.println("Tabla del " + i);
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " x " + j + " = " + (i * j));
            }
            System.out.println();
        }
    }
}