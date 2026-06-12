package biblioteca;

import java.util.ArrayList;
import java.util.Random;

public class CatalogoLibros { 

    private ArrayList<Libro> libros;

    // constructor predeterminado (creará e inicializará la lista con una capacidad inicial de 100 elementos, por eficiencia).
    public CatalogoLibros() {
        this.libros = new ArrayList<>(100);
    }

    // 1. cantidad(): devuelve el número de Libros de la lista.
    public int cantidad() {
        return libros.size();
    }

    // 2. estaVacia(): devuelve si la lista de libros está vacía.
    public boolean estaVacia() {
        return libros.isEmpty();
    }

    // 3. obtener(int pos): devuelve el libro que se encuentra en la posición indicada.
    public Libro obtener(int pos) {
        if (pos < 0 || pos >= libros.size()) {
            throw new IllegalArgumentException("Posición fuera de rango.");
        }
        return libros.get(pos);
    }

    // 4. cambiar(int pos, Libro nuevo): cambia el libro de la posición indicada por el nuevo libro proporcionado.
    public void cambiar(int pos, Libro nuevo) {
        if (pos < 0 || pos >= libros.size()) {
            throw new IllegalArgumentException("Posición fuera de rango.");
        }
        libros.set(pos, nuevo);
    }

    // 5. guardar(Libro libro): agrega al final de la lista el libro pasado.
    public void guardar(Libro libro) {
        libros.add(libro);
    }

    // 6. eliminar(int pos): elimina el libro que se encuentra en la posición indicada.
    public void eliminar(int pos) {
        if (pos < 0 || pos >= libros.size()) {
            throw new IllegalArgumentException("Posición fuera de rango.");
        }
        libros.remove(pos);
    }
    

    // 7. eliminar(String isbn), elimina el objeto libro que tiene ese isbn si se encuentra en la lista. 
    public void eliminar(String isbn) {
        libros.removeIf(libro -> libro.getIsbn().equals(isbn));
    }

    // 8. imprimir(). Método de clase que imprime los datos de los libros de la lista.
    public void imprimir() {
        System.out.println(libros.toString());
    }

    // 9. buscar(Libro libro), busca el libro en la lista y devuelve la posición en la que se encuentra. Usa el método indexOf.
    public int buscar(Libro libro) {
        return libros.indexOf(libro);
    }

    // 10. buscar(String autor), busca todos los libros de ese autor y los devuelve en una lista de libros.
    public ArrayList<Libro> buscarPorAutor(String autor) {
        ArrayList<Libro> librosAutor = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                librosAutor.add(libro);
            }
        }
        return librosAutor;
    }

    // 11. buscar(String isbn), busca el libro que tiene ese isbn y lo devuelve si existe. En caso de no existir devuelve null.
    public Libro buscar(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    // 7. Método que elige y devuelve un libro aleatorio de la cartera
    public Libro obtenerLibro(){
        return libros.get(new Random().nextInt(0, libros.size()));
    }
}