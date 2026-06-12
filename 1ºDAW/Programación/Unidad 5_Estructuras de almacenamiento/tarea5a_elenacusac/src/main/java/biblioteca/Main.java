package biblioteca;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear libros: dos con isbn diferente, dos con isbn igual
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", 1605, "1234567890123", Genero.NOVELA, true);
        Libro libro2 = new Libro("1984", "Orwell", 1949, "9876543210987", Genero.FICCION, true);
        Libro libro3 = new Libro("Poesías", "Gustavo Adolfo Bécquer", 1871, "1234567890123", Genero.POESIA, false); // mismo
                                                                                                                    // isbn
                                                                                                                    // que
                                                                                                                    // libro1
        Libro libro4 = new Libro("Relatos", "Julio Cortázar", 1951, "1234567890123", Genero.RELATO, true); // mismo isbn
                                                                                                           // que libro1

        // Mostrar datos de los libros
        System.out.println("Datos de los libros:");
        System.out.println(libro1);
        System.out.println(libro2);
        System.out.println(libro3);
        System.out.println(libro4);
        System.out.println();

        // Probar métodos prestar y devolver
        System.out.println("Probando prestar y devolver:");
        System.out.println("Libro1 antes de prestar: disponible = " + libro1.isDisponible());
        libro1.prestar();
        System.out.println("Libro1 después de prestar: disponible = " + libro1.isDisponible());
        libro1.devolver();
        System.out.println("Libro1 después de devolver: disponible = " + libro1.isDisponible());
        System.out.println();

        // Ejecutar hashCode
        System.out.println("HashCodes:");
        System.out.println("Libro1 hashCode: " + libro1.hashCode());
        System.out.println("Libro2 hashCode: " + libro2.hashCode());
        System.out.println("Libro3 hashCode: " + libro3.hashCode());
        System.out.println("Libro4 hashCode: " + libro4.hashCode());
        System.out.println();

        // Ejecutar equals
        System.out.println("Equals:");
        System.out.println("libro1.equals(libro3): " + libro1.equals(libro3)); // mismo isbn, true
        System.out.println("libro1.equals(libro4): " + libro1.equals(libro4)); // mismo isbn, true
        System.out.println("libro1.equals(libro2): " + libro1.equals(libro2)); // diferente isbn, false
        System.out.println();

        // Crear Catálogo 1 y añadir 3 libros
        CatalogoLibros catalogo1 = new CatalogoLibros();
        catalogo1.guardar(libro1);
        catalogo1.guardar(libro2);
        catalogo1.guardar(libro3);

        // Crear Catálogo 2 y añadir 4 libros
        CatalogoLibros catalogo2 = new CatalogoLibros();
        catalogo2.guardar(libro1);
        catalogo2.guardar(libro4);
        catalogo2.guardar(libro3);
        catalogo2.guardar(libro2);

        // Probar métodos de la clase Catálogo Libros
        // Cantidad de libros del catálogo 2
        catalogo1.cantidad();
        System.out.println();

        // Cantidad de libros del catálogo 2
        catalogo2.cantidad();
        System.out.println();

        // Ver si el catálogo está vacío
        catalogo2.estaVacia();

        // Mirar el libro que se encuentra en la posición indicada
        System.out.println("El libro del catálogo 1 que está en la posición 0 es: \n" + catalogo1.obtener(0));

        // Cambiar de posición un libro de una lista
        catalogo2.cambiar(3, libro1);

        // Guardar al final de la lista un libro
        catalogo1.guardar(libro4);

        // Eliminar el libro de la posición indicada
        catalogo1.eliminar(1);

        // Eliminar el libro que tiene el ISBN indicado
        catalogo2.eliminar("1234567890123");

        // Imprimir los datos de los libros de la lista
        catalogo1.imprimir();

        // Buscar un libro y devolver su posición
        catalogo2.buscar(libro4);

        // Buscar todos los libros de un autor
        catalogo1.buscarPorAutor("Orwell");

        // Buscar si existe un libro según si ISBN
        catalogo2.buscar("1234567890123");

        // Menú de la aplicación usando JOptionPane
        CatalogoLibros catalogo = new CatalogoLibros();
        // Agregar algunos libros iniciales para prueba
        catalogo.guardar(libro1);
        catalogo.guardar(libro2);
        catalogo.guardar(libro3);
        catalogo.guardar(libro4);

        boolean continuar = true;
        while (continuar) {
            // Mostrar el menú de opciones
            String menu = """
                              ~ Menú ~

                    ¿Qué operación quieres hacer? Selecciona el número de la opción:

                    1. Obtener el número de libros del catálogo.
                    2. Verificar si el catálogo está vacío.
                    3. Obtener el libro de una posición determinada.
                    4. Cambiar la posición de un libro.
                    5. Añadir un nuevo libro.
                    6. Borrar un libro por posición.
                    7. Borrar un libro por ISBN.
                    8. Mostrar todos los libros.
                    9. Buscar un libro y mostrar su posición.
                    10. Buscar libros por autor.
                    11. Verificar si existe un libro por ISBN.
                    0. Salir.

                    """;
            String opcionString = JOptionPane.showInputDialog(menu);
            int opcion = Integer.parseInt(opcionString);

            try {
                switch (opcion) {
                    case 1:
                        opcion1(catalogo);
                        break;

                    case 2:
                        opcion2(catalogo);
                        break;

                    case 3:
                        opcion3(catalogo);
                        break;

                    case 4:
                        opcion4(catalogo);
                        break;

                    case 5:
                        opcion5(catalogo);
                        break;

                    case 6:
                        opcion6(catalogo);
                        break;

                    case 7:
                        opcion7(catalogo);
                        break;

                    case 8:
                        opcion8(catalogo);
                        break;

                    case 9:
                        opcion9(catalogo);
                        break;

                    case 10:
                        opcion10(catalogo);
                        break;

                    case 11:
                        opcion11(catalogo);
                        break;

                    case 0:
                        continuar = false;
                        break;

                    default:
                        break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Has introducido una letra junto al número. ");
                System.out.println("Vuelve a introducir el número.");
            }

        }

    }

    public static void opcion1(CatalogoLibros catalogo) {
        catalogo.cantidad();
    }

    public static void opcion2(CatalogoLibros catalogo) {
        catalogo.estaVacia();
    }

    public static void opcion3(CatalogoLibros catalogo) {
        boolean condition = false;
        do {
            try {
                String posicionString = JOptionPane.showInputDialog("Introduce la posición: ");
                int posicion = Integer.parseInt(posicionString);

                System.out.println("El libro de la posición " + posicion + " es " + catalogo.obtener(posicion));

            } catch (IllegalArgumentException iae) {
                System.out.println("Has introducido mal la posición. ");
                condition = true;
            }
        } while (condition);

    }

    public static void opcion4(CatalogoLibros catalogo) {
        boolean condition = false;
        do {
            try {
                String posicionString = JOptionPane.showInputDialog("Introduce la posición a cambiar: ");
                int posicion = Integer.parseInt(posicionString);
                
                String titulo = JOptionPane.showInputDialog("Introduce el título del nuevo libro: ");
                String autor = JOptionPane.showInputDialog("Introduce el autor del nuevo libro: ");
                String anioString = JOptionPane.showInputDialog("Introduce el año del nuevo libro: ");
                int anio = Integer.parseInt(anioString);
                String isbn = JOptionPane.showInputDialog("Introduce el ISBN del nuevo libro: ");
                String generoString = JOptionPane.showInputDialog("Introduce el género (NOVELA, FICCION, POESIA, RELATO): ");
                Genero genero = Genero.valueOf(generoString.toUpperCase());
                String disponibleString = JOptionPane.showInputDialog("¿Está disponible? (true/false): ");
                boolean disponible = Boolean.parseBoolean(disponibleString);
                
                Libro nuevoLibro = new Libro(titulo, autor, anio, isbn, genero, disponible);
                catalogo.cambiar(posicion, nuevoLibro);
                System.out.println("Libro en posición " + posicion + " cambiado exitosamente.");
                condition = false;
            } catch (IllegalArgumentException iae) {
                System.out.println("Has introducido datos inválidos. ");
                condition = true;
            }
        } while (condition);
    }

    public static void opcion5(CatalogoLibros catalogo) {
        boolean condition = false;
        do {
            try {
                String titulo = JOptionPane.showInputDialog("Introduce el título del nuevo libro: ");
                String autor = JOptionPane.showInputDialog("Introduce el autor del nuevo libro: ");
                String anioString = JOptionPane.showInputDialog("Introduce el año del nuevo libro: ");
                int anio = Integer.parseInt(anioString);
                String isbn = JOptionPane.showInputDialog("Introduce el ISBN del nuevo libro: ");
                String generoString = JOptionPane.showInputDialog("Introduce el género (NOVELA, FICCION, POESIA, RELATO): ");
                Genero genero = Genero.valueOf(generoString.toUpperCase());
                String disponibleString = JOptionPane.showInputDialog("¿Está disponible? (true/false): ");
                boolean disponible = Boolean.parseBoolean(disponibleString);
                
                Libro nuevoLibro = new Libro(titulo, autor, anio, isbn, genero, disponible);
                catalogo.guardar(nuevoLibro);
                System.out.println("Libro \"" + titulo + "\" añadido exitosamente.");
                condition = false;
            } catch (IllegalArgumentException iae) {
                System.out.println("Has introducido datos inválidos. ");
                condition = true;
            }
        } while (condition);
    }

    public static void opcion6(CatalogoLibros catalogo) {
        boolean condition = false;
        do {
            try {
                String posicionString = JOptionPane.showInputDialog("Introduce la posición del libro a borrar: ");
                int posicion = Integer.parseInt(posicionString);
                
                catalogo.eliminar(posicion);
                System.out.println("Libro en posición " + posicion + " borrado exitosamente.");
                condition = false;
            } catch (IllegalArgumentException iae) {
                System.out.println("Has introducido mal la posición. ");
                condition = true;
            }
        } while (condition);
    }

    public static void opcion7(CatalogoLibros catalogo) {
        boolean condition = false;
        do {
            try {
                String isbn = JOptionPane.showInputDialog("Introduce el ISBN del libro a borrar: ");
                catalogo.eliminar(isbn);
                System.out.println("Libro con ISBN " + isbn + " borrado exitosamente.");
                condition = false;
            } catch (IllegalArgumentException iae) {
                System.out.println("Ha ocurrido un error. ");
                condition = true;
            }
        } while (condition);
    }

    public static void opcion8(CatalogoLibros catalogo) {
        catalogo.imprimir();
    }

    public static void opcion9(CatalogoLibros catalogo) {
        boolean condition = false;
        do {
            try {
                String titulo = JOptionPane.showInputDialog("Introduce el título del libro a buscar: ");
                String autor = JOptionPane.showInputDialog("Introduce el autor del libro a buscar: ");
                String anioString = JOptionPane.showInputDialog("Introduce el año del libro a buscar: ");
                int anio = Integer.parseInt(anioString);
                String isbn = JOptionPane.showInputDialog("Introduce el ISBN del libro a buscar: ");
                String generoString = JOptionPane.showInputDialog("Introduce el género (NOVELA, FICCION, POESIA, RELATO): ");
                Genero genero = Genero.valueOf(generoString.toUpperCase());
                String disponibleString = JOptionPane.showInputDialog("¿Está disponible? (true/false): ");
                boolean disponible = Boolean.parseBoolean(disponibleString);
                
                Libro libroABuscar = new Libro(titulo, autor, anio, isbn, genero, disponible);
                int posicion = catalogo.buscar(libroABuscar);
                
                if (posicion != -1) {
                    System.out.println("El libro se encuentra en la posición: " + posicion);
                } else {
                    System.out.println("El libro no se encuentra en el catálogo.");
                }
                condition = false;
            } catch (IllegalArgumentException iae) {
                System.out.println("Has introducido datos inválidos. ");
                condition = true;
            }
        } while (condition);
    }

    public static void opcion10(CatalogoLibros catalogo) {
        boolean condition = false;
        do {
            try {
                String autor = JOptionPane.showInputDialog("Introduce el autor a buscar: ");
                ArrayList<Libro> librosAutor = catalogo.buscarPorAutor(autor);
                
                if (!librosAutor.isEmpty()) {
                    System.out.println("Libros del autor " + autor + ":");
                    System.out.println(librosAutor.toString());
                } else {
                    System.out.println("No se encontraron libros del autor " + autor + ".");
                }
                condition = false;
            } catch (IllegalArgumentException iae) {
                System.out.println("Ha ocurrido un error. ");
                condition = true;
            }
        } while (condition);
    }

    public static void opcion11(CatalogoLibros catalogo) {
        boolean condition = false;
        do {
            try {
                String isbn = JOptionPane.showInputDialog("Introduce el ISBN a buscar: ");
                Libro libroEncontrado = catalogo.buscar(isbn);
                
                if (libroEncontrado != null) {
                    System.out.println("Libro encontrado:\n" + libroEncontrado);
                } else {
                    System.out.println("No se encontró ningún libro con el ISBN " + isbn + ".");
                }
                condition = false;
            } catch (IllegalArgumentException iae) {
                System.out.println("Ha ocurrido un error. ");
                condition = true;
            }
        } while (condition);
    }

}