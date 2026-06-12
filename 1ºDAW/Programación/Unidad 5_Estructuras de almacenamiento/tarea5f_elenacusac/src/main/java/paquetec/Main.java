package paquetec;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
         * En una estructura map, asocia a cada objeto de tipo Vaquería un identificador
         * único. Se deben poder guardar Vaquerías con sus identificadores asociados,
         * obtener una Vaquería según su identificador y obtener todas los Vaquerías
         * contenidas en la estructura map.
         */

        // Crear vacas
        Vaca vaca1 = new Vaca(1, LocalDate.of(2020, 3, 15), "Vaca Holstein negra y blanca");
        Vaca vaca2 = new Vaca(2, LocalDate.of(2021, 6, 20), "Vaca Jersey marrón");
        Vaca vaca3 = new Vaca(3, LocalDate.of(2019, 1, 10), "Vaca Guernsey dorada");
        Vaca vaca4 = new Vaca(4, LocalDate.of(2022, 5, 8), "Vaca Simmental blanca");
        Vaca vaca5 = new Vaca(5, LocalDate.of(2021, 11, 25), "Vaca Parda Alpina");
        Vaca vaca6 = new Vaca(6, LocalDate.of(2020, 7, 30), "Vaca Bretona");

        // Crear vaquerías
        // Vaquería 1
        Vaqueria vaqueria1 = new Vaqueria();
        vaqueria1.añadirVaca(vaca1);
        vaqueria1.añadirVaca(vaca2);
        vaqueria1.añadirVaca(vaca3);
        
        // Vaquería 2
        Vaqueria vaqueria2 = new Vaqueria();
        vaqueria2.añadirVaca(vaca4);
        vaqueria2.añadirVaca(vaca5);
        
        // Vaquería 3
        Vaqueria vaqueria3 = new Vaqueria();
        vaqueria3.añadirVaca(vaca6);

        // Crear un gestor de vaquería
        GestorVaquerias gestor = new GestorVaquerias();
        
        // Guardar vaquerías en el gestor
        gestor.guardarVaqueria(vaqueria1, "Vaqueria_norte");
        gestor.guardarVaqueria(vaqueria2, "Vaqueria_sur");
        gestor.guardarVaqueria(vaqueria3, "Vaqueria_este");
        
        // Obtener una vaquería específica
        System.out.println();
        System.out.println(gestor.obtenerVaqueria("Vaqueria_norte").mostrarVacas());
        
        // Imprimir todas las vaquerías
        System.out.println();
        gestor.imprimirVaquerias();
        System.out.println();
        
    }
}
