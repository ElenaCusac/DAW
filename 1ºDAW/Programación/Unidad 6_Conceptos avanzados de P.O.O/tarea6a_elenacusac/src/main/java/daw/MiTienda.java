package daw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MiTienda {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        // 1. Crear productos
        Producto p1 = new Pantalon(1, 30, 21, "Pantalón Vaquero", "Springfield", "M");
        Producto p2 = new Pantalon(2, 325, 21, "Pantalón ancho de viscosa fluida", "Sandro", "38");

        Producto p3 = new LibroPapel(3, 20, 4, "Apocalipsis Z: El Principio del Fin", "978-3-7047-6814-8", 429);
        Producto p4 = new LibroPapel(4, 8.85, 4, "El Abisinio", "978-1-9491-8594-2", 475);

        Producto p5 = new LibroDigital(5, 12, 4, "El Caballo de Troya", "978-9-4400-8670-6", 96453);
        Producto p6 = new LibroDigital(6, 22, 4, "Tetuán y Larache", "978-1-9267-7165-6", 156519);

        Producto p7 = new Musica(7, 44, 21, "Liebe ist für alle da", "Rammstein");
        Producto p8 = new Musica(8, 40, 21, "Appetite for Destruction", "Guns N' Roses");

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);
        productos.add(p6);
        productos.add(p7);
        productos.add(p8);


        // 2. Mostrar productos
        System.out.println("---- Mostrar Productos ----");
        for (Producto p : productos) {
            System.out.println(p);
        }
        System.out.println();

        // 3. Ordenar por precio
        productos.sort((a, b) -> Double.compare(a.getPrecio(), b.getPrecio()));

        // 4. Mostrar
        System.out.println("---- Ordenados por precio ----");
        productos.forEach(System.out::println);
        System.out.println();

        // 5. Ordenar por código
        productos.sort((a, b) -> Integer.compare(a.getCodigo(), b.getCodigo()));

        // 6. Mostrar
        System.out.println("---- Ordenados por código ---- ");
        productos.forEach(System.out::println);
        System.out.println();

        // 7. Búsqueda binaria
        int pos = Collections.binarySearch(productos, p7, Comparator.comparingInt(Producto::getCodigo));

        System.out.println("Posición producto encontrado: " + pos);
        System.out.println();

        // 8. Lista de libros
        List<Libro> libros = new ArrayList<>();

        for (Producto p : productos) {
            if (p instanceof Libro) {
                libros.add((Libro) p); // conversión explícita
            }
        }

        // 9. Mostrar libros
        libros.forEach(System.out::println);
        System.out.println();

        // 10. Ordenar por ISBN
        Collections.sort(libros);

        // 11. Mostrar
        System.out.println("---- Libros ordenados por ISBN ----");
        libros.forEach(System.out::println);

        // 12. enviar o descargar
        for (Libro libro : libros) {

            if (libro instanceof SeEnvia) {
                ((SeEnvia) libro).enviar("Calle Mayor 10");
            }

            if (libro instanceof SeDescarga) {
                ((SeDescarga) libro).descargar();
            }
        }
        System.out.println();

        // 14. contains
        System.out.println(libros.contains(p2));

        // 15. lista de SeEnvia
        List<SeEnvia> envios = new ArrayList<>();

        for (Producto p : productos) {
            if (p instanceof SeEnvia) {
                envios.add((SeEnvia) p);
            }
        }
        System.out.println();

        // 16. ejecutar método
        for (SeEnvia e : envios) {
            e.enviar("Avenida Andalucía 25");
        }

    }
}
