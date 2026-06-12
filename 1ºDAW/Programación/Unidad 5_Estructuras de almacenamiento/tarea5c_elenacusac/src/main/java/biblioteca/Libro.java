package biblioteca;

import java.util.Objects;
import java.util.Random;

public class Libro {
    private String titulo;
    private String autor;
    private int anoPublicacion;
    private final String isbn; // 13 dígitos, único, no cambia
    private Genero genero;
    private boolean disponible;

    // Constructor por defecto
    public Libro() {
        this.titulo = "Título por defecto";
        this.autor = "Autor por defecto";
        this.anoPublicacion = 2023;
        this.isbn = "1234567890123"; // Valor por defecto, 13 dígitos
        this.genero = Genero.NOVELA;
        this.disponible = true;
    }

    // Constructor parametrizado
    public Libro(String titulo, String autor, int anoPublicacion, String isbn, Genero genero, boolean disponible) {
        if (isbn.length() != 13) {
            throw new IllegalArgumentException("El ISBN debe tener exactamente 13 dígitos.");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
        this.isbn = isbn;
        this.genero = genero;
        this.disponible = disponible;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public Genero getGenero() {
        return genero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    // Setters (excepto disponible)
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    // toString
    @Override
    public String toString() {
        return "Libro{ " +
                "Título = '" + titulo + '\'' +
                ", Autor = '" + autor + '\'' +
                ", Año de Publicación = " + anoPublicacion +
                ", ISBN = " + isbn +
                ", Género = " + genero +
                ", Disponible = " + disponible +
                '}';
    }

    // equals y hashCode basados en isbn
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    // Método prestar
    public void prestar() {
        if (disponible) {
            disponible = false;
        }
    }

    // Método devolver
    public void devolver() {
        if (!disponible) {
            disponible = true;
        }
    }

    public Object compareTo(Libro libro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    
}