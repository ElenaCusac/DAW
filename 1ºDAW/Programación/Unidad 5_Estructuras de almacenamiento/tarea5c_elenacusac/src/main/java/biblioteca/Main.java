package biblioteca;

import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        CarteraEstudiantes carteraEstudiante = new CarteraEstudiantes();
        CatalogoLibros catalogoLibro = new CatalogoLibros();
        CantidadPretamos prestamosLista = new CantidadPretamos();

        // Crear estudiantes
        Estudiante estudiante1 = new Estudiante("Soledad", "Sánchez", "12345678A");
        Estudiante estudiante2 = new Estudiante("Angustias", "Pérez", "23456789A");
        Estudiante estudiante3 = new Estudiante("Gregorio Luis", "Rodríguez", "12345678B");
        Estudiante estudiante4 = new Estudiante("Jesús", "Santos", "11235813D");
        Estudiante estudiante5 = new Estudiante("Jorge", "Herrera", "98765432A");

        // Añadirlos a la cartera
        carteraEstudiante.añadir(estudiante1);
        carteraEstudiante.añadir(estudiante2);
        carteraEstudiante.añadir(estudiante3);
        carteraEstudiante.añadir(estudiante4);
        carteraEstudiante.añadir(estudiante5);

        // Crear libros
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "9788420603354",
                Genero.NOVELA, true);
        Libro libro2 = new Libro("La Odisea", "Homero", 800, "9788420612345", Genero.NOVELA, true);
        Libro libro3 = new Libro("Veinte poemas de amor y una canción desesperada", "Pablo Neruda", 1924,
                "9788420656789", Genero.POESIA, true);
        Libro libro4 = new Libro("Ficciones", "Jorge Luis Borges", 1944, "9788420691012", Genero.FICCION, true);
        Libro libro5 = new Libro("El Aleph", "Jorge Luis Borges", 1949, "9788420634567", Genero.RELATO, true);

        // Añadirlos al catálogo de libros
        catalogoLibro.guardar(libro1);
        catalogoLibro.guardar(libro2);
        catalogoLibro.guardar(libro3);
        catalogoLibro.guardar(libro4);
        catalogoLibro.guardar(libro5);

        // Hacemos varios préstamos de prueba
        Prestamo p1 = new Prestamo(carteraEstudiante.obtenerEstudiante(), catalogoLibro.obtenerLibro(), 1);
        Prestamo p2 = new Prestamo(carteraEstudiante.obtenerEstudiante(), catalogoLibro.obtenerLibro(), 2);
        Prestamo p3 = new Prestamo(carteraEstudiante.obtenerEstudiante(), catalogoLibro.obtenerLibro(), 3);
        Prestamo p4 = new Prestamo(carteraEstudiante.obtenerEstudiante(), catalogoLibro.obtenerLibro(), 4);
        Prestamo p5 = new Prestamo(carteraEstudiante.obtenerEstudiante(), catalogoLibro.obtenerLibro(), 5);
        prestamosLista.guardar(p1);
        prestamosLista.guardar(p2);
        prestamosLista.guardar(p3);
        prestamosLista.guardar(p4);
        prestamosLista.guardar(p5);

        boolean continuar = true;

        Prestamo prestamo = null;

        do {
            String menu = """
                                            ~ Menú ~

                    ¿Qué quieres hacer? Selecciona el número de la opción:

                        1. Ver libros.
                        2. Ver estudiantes.
                        3. Hacer un préstamo.
                        4. Ver datos del préstamo
                        5. Salir.

                    """;

            int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1:
                    JOptionPane.showMessageDialog(null, libro1.toString() + " \n" +
                            libro2.toString() + " \n" +
                            libro3.toString() + " \n" +
                            libro4.toString() + " \n" +
                            libro5.toString());
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, estudiante1.toString() + " \n" +
                            estudiante2.toString() + " \n" +
                            estudiante3.toString() + " \n" +
                            estudiante4.toString() + " \n" +
                            estudiante5.toString());
                    break;

                case 3:
                    String libroISBN = JOptionPane
                            .showInputDialog("Introduce el ISBN del libro que te quieres llevar: ");
                    String dniEstudiante = JOptionPane
                            .showInputDialog("Introduce el DNI del estudiante que va a prestar el libro: ");

                    Estudiante estudiantePrestamo = carteraEstudiante.buscar(dniEstudiante);
                    Libro libroPrestamo = catalogoLibro.buscar(libroISBN);

                    if (libroPrestamo != null && estudiantePrestamo != null) {
                        int id = Integer.parseInt(
                                JOptionPane.showInputDialog("Introduce un número para identificar su préstamo: "));
                        prestamo = new Prestamo(estudiantePrestamo, libroPrestamo, id, LocalDate.now());
                        JOptionPane.showMessageDialog(null, "Préstamo realizado con éxito.");
                        prestamosLista.guardar(prestamo);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha podido realizar el préstamo.");
                    }
                    break;
                case 4:
                    if (prestamo != null) {
                        JOptionPane.showMessageDialog(null, prestamo.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay ningún préstamo registrado.");
                    }
                    break;

                case 5:
                    continuar = false;
                    break;
                default:
                    break;
            }
        } while (continuar);

        // 1. Buscar préstamo por ID (búsqueda secuencial)
        Prestamo prestamoBuscado = prestamosLista.busquedaPorID(1);
        System.out.println("Búsqueda por ID:");
        System.out.println(prestamoBuscado);
        System.out.println();

        // 2. Modificar el libro de un préstamo
        prestamosLista.modificar(1, libro5);
        System.out.println(prestamosLista.busquedaPorID(1));
        System.out.println();

        // 3. Modificar el estudiante de un préstamo
        prestamosLista.modificar(1, estudiante3);
        System.out.println("Modificar Estudiante:");
        System.out.println(prestamosLista.busquedaPorID(1));
        System.out.println();

        // 4. Buscar todos los préstamos de un libro
        var prestamosLibro = prestamosLista.prestamosLibro(libro5);
        System.out.println("Préstamos de un libro:");
        System.out.println(prestamosLibro);
        System.out.println();

        // 5. Buscar todos los préstamos de un estudiante
        var prestamosEstudiante = prestamosLista.prestamosEstudiante(estudiante3);
        System.out.println("Préstamos de un estudiante:");
        System.out.println(prestamosEstudiante);
        System.out.println();

        // 6. Buscar todos los préstamos vencidos
        var prestamosVencidos = prestamosLista.prestamosVencidos();
        System.out.println("Préstamos vencidos:");
        System.out.println(prestamosVencidos);
        System.out.println();

        // 7. Buscar préstamos que vencen en una fecha concreta
        LocalDate fecha = LocalDate.now().plusDays(15);
        var prestamosFecha = prestamosLista.prestamosQueVencen(fecha);;
        System.out.println("PRÉSTAMOS QUE VENCEN EN FECHA:");
        System.out.println(prestamosFecha);
        System.out.println();

        // ---- MOSTRAR Y ORDENAR PRÉSTAMOS ----

        // Ordenar por ID
        prestamosLista.ordenarPorID();
        System.out.println("---- PRÉSTAMOS ORDENADOS POR ID ----");
        System.out.println(prestamosLista);

        // Ordenar por fecha de inicio
        prestamosLista.ordenarPorFechaInicio();
        System.out.println("---- PRÉSTAMOS ORDENADOS POR FECHA DE INICIO ----");
        System.out.println(prestamosLista);

        // Ordenar por fecha de devolución
        prestamosLista.ordenarPorFechaDevolucion();
        System.out.println("---- PRÉSTAMOS ORDENADOS POR FECHA DE DEVOLUCIÓN ----");
        System.out.println(prestamosLista);

        // Ordenar por título del libro
        prestamosLista.ordenarPorTitulo();
        System.out.println("---- PRÉSTAMOS ORDENADOS POR TÍTULO ----");
        System.out.println(prestamosLista);

        // Ordenar por nombre del alumno/a
        prestamosLista.ordenarPorAlumno();
        System.out.println("---- PRÉSTAMOS ORDENADOS POR ALUMNO/A ----");
        System.out.println(prestamosLista);
    }
}
