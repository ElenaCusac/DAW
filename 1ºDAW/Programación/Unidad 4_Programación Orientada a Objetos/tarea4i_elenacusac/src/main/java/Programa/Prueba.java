package Programa;

import java.time.LocalDate;

import modelo.Animal;
import modelo.Persona;

public class Prueba {
    public static void main(String[] args) {
        // Crear las fechas de nacimiento de los animales
        LocalDate fecha1 = LocalDate.of(2020, 10, 8);
        LocalDate fecha2 = LocalDate.of(2012, 1, 1);

        // Crear los animales a1 y a2
        Animal a1 = new Animal("Juan de Dios", 625, fecha1, "periquito");
        Animal a2 = new Animal("Angustias", 4285, fecha2, "gato");

        // Crear las personas p1 y p2
        Persona p1 = new Persona("Manolo", 48);
        Persona p2 = new Persona("Paco", 22);

        // Mostrar los datos de los 2 primeros animales
        System.out.println(a1.toString());
        System.out.println(a2.toString());

        // Crear el tercer animal como una copia del segundo
        Animal a3 = a2.clonar(a2);
        System.out.println(a3.toString());

        // Despertar a todos los animales, aunque ya están reposando por defecto
        p1.llamar(a1);
        p1.llamar(a2);
        p1.llamar(a3);

        // Hacer que p2 juegue con el segundo animal durante 120 minutos
        p2.jugar(a2, 120);

        // Hacer que p1 alimente al primer animal 1000 gramos
        p1.alimentar(a1, 1000);
        System.out.println( "Nuevo peso del primer animal después de comer: " + a1.getPeso());

        // Hacer que p1 juegue con el primer animal 200 minutos
        p1.jugar(a1, 200);

        // Mostrar el nuevo peso del primer animal
        System.out.println( "Nuevo peso del primer animal después de jugar: " + a1.getPeso());

        // Creación de un par de animales nuevos con fechas y datos erróneos
        Animal a4 = new Animal("Segismunda", 5, LocalDate.of(1998, 12, 3), "lagarto");
        Animal a5 = new Animal("Canuto", 200000, LocalDate.of(2089, 1, 1), "gato");

        //Mostrar los datos de los animales con fallos 
        System.out.println(a4.toString());
        System.out.println(a5.toString());
    }
}
