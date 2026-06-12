package biblioteca;

import java.time.LocalDate;

public class Prestamo {

    // Atributo de tipo estudiante
    private Estudiante estudiante;

    // Atributo de tipo libro
    private Libro libro;

    // Fecha de préstamo
    private LocalDate fechaPrestamo;

    // Fecha de devolución (que es 15 días después de la fecha de préstamo)
    private LocalDate fechaDevolucion;

    // Número de identificación del préstamo
    private final int id;

    // Constructor
    public Prestamo(Estudiante estudiante, Libro libro, int id, LocalDate fechaPrestamo) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = this.fechaPrestamo.plusDays(15);
        this.id = id;
        libro.prestar();
    }

    // Sobrecarga de constructores
    public Prestamo(Estudiante estudiante, Libro libro, int id) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = this.fechaPrestamo.plusDays(15);
        this.id = id;
        libro.prestar();
    }

    // Constructor por defecto
    public Prestamo() {
        this.id = 0;
        // Si no indico nada, los atributos Estudiante, Libro y LocalDate son null
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = this.fechaPrestamo.plusDays(15);
    }

    // Getters y Setters
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaPrestamo.plusDays(15);
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID = " + id +
               ", Estudiante = " + estudiante.getNombre() +
               ", Libro = " + libro.getTitulo() +
               ", Fecha del Préstamo = " + fechaPrestamo +
               ", Fecha de Devolución = " + fechaDevolucion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Prestamo other = (Prestamo) obj;
        return id == other.id;
    }
}
