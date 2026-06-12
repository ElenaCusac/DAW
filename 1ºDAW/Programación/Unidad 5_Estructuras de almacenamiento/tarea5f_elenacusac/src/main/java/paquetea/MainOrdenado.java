package paquetea;

public class MainOrdenado {
    public static void main(String[] args) {
        // Realiza una clase conteniendo el main() y 10 registros en tu traductor. 
        // Prueba los métodos realizados.

        Traductor t1 = new Traductor();

        // Guardar 10 traducciones
        t1.guardar("Amuse", "Divertir");
        t1.guardar("Ball", "Pelota");
        t1.guardar("Pay", "Pagar");
        t1.guardar("Enjoy", "Disfrutar");
        t1.guardar("Realise", "Darse cuenta de");
        t1.guardar("God", "Dios");
        t1.guardar("Life", "Vida");
        t1.guardar("Time", "Tiempo");
        t1.guardar("People", "Gente");
        t1.guardar("Cow", "Vaca");

        // Probar los métodos
        // Traduccion de una palabra en inglés al español
        System.out.println("Traducción de 'God': " + t1.traducir("God"));

        // Mostrar todas las palabras 
        System.out.println();
        System.out.println("Palabras extranjeras: " + t1.imprimir());

        // Borrar una entrada
        t1.borrar("Amuse");

        // Modificar una entrada
        t1.modificar("People", "Personas");

        // Volver a mostrar todas las palabras 
        System.out.println();
        System.out.println("Palabras extranjeras: " + t1.imprimir());

        // Mostrar sólo las palabras en inglés
        System.out.println();
        t1.imprimirIngles();

        // Mostrar sólo las palabras en español
        System.out.println();
        t1.imprimirEspaniol();
        

    }
}