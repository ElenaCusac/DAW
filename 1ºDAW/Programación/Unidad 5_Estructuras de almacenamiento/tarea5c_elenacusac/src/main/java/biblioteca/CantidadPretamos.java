package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

public class CantidadPretamos {

    private ArrayList<Prestamo> prestamos;

    // Constructor predeterminado con un tamaño 100
    public CantidadPretamos() {
        this.prestamos = new ArrayList<>(100);
    }

    // Guardar préstamo
    public void guardar(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    // Borrar préstamo
    public void eliminar(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }

    // Modificar el libro de un préstamo de la lista, para ello se debe aportar el id del préstamo, y el nuevo libro a asignar.
    public void modificar(int id, Libro libro) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getId() == id) {
                prestamo.setLibro(libro);
                return;
            }
        }
    }

    // Modificar el estudiante de un préstamo de la lista, para ello se debe aportar el id del préstamo, y el nuevo estudiante a asignar.
    public void modificar(int id, Estudiante estudiante) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getId() == id) {
                prestamo.setEstudiante(estudiante);
                return;
            }
        }
    }

    // Buscar préstamo por id (usa búsqueda secuencial)
    public Prestamo busquedaPorID(int id) {
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getId() == id) {
                return prestamos.get(i);
            }
        }
        return null;
    }

    // Buscar todos los préstamos de un libro
    public ArrayList<Prestamo> prestamosLibro(Libro libro) {
        ArrayList<Prestamo> prestamosLibro = new ArrayList<>();

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().equals(libro)) {
                prestamosLibro.add(prestamo);
            }
        }
        return prestamosLibro;
    }

    // Buscar todos los préstamos de un estudiante
    public ArrayList<Prestamo> prestamosEstudiante(Estudiante estudiante) {
        ArrayList<Prestamo> prestamosEstudiante = new ArrayList<>();

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getEstudiante().equals(estudiante)) {
                prestamosEstudiante.add(prestamo);
            }
        }
        return prestamosEstudiante;
    }

    // Buscar todos los prestamos vencidos
    public ArrayList<Prestamo> prestamosVencidos() {
        ArrayList<Prestamo> prestamosVencidos = new ArrayList<>();

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getFechaDevolucion().isBefore(LocalDate.now())) {
                prestamosVencidos.add(prestamo);
            }
        }
        return prestamosVencidos;
    }

    // Buscar los préstamos que vencen en una fecha determinada
    public ArrayList<Prestamo> prestamosQueVencen(LocalDate fechaVencimiento) {
        ArrayList<Prestamo> prestamosQueVencen = new ArrayList<>();

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getFechaDevolucion().isEqual(fechaVencimiento)) {
                prestamosQueVencen.add(prestamo);
            }
        }
        return prestamosQueVencen;
    }

    // Ordenar préstamos por id
    public void ordenarPorID() {
        prestamos.sort((p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
    }

    // Búsqueda binaria de préstamos por id
    public void ordenarPorIDBinario() {
        ordenarPorID();
    }

    // Ordenar préstamos por fecha de inicio
    public void ordenarPorFechaInicio() {
        prestamos.sort((p1, p2) ->
                p1.getFechaPrestamo().compareTo(p2.getFechaPrestamo()));
    }

    // Ordenar por fecha de devolución
    public void ordenarPorFechaDevolucion() {
        prestamos.sort((p1, p2) ->
                p1.getFechaDevolucion().compareTo(p2.getFechaDevolucion()));
    }

    // Ordenar por título de libro
    public void ordenarPorTitulo() {
        prestamos.sort((p1, p2) ->
                p1.getLibro().getTitulo().compareToIgnoreCase(p2.getLibro().getTitulo()));
    }

    // Ordenar por nombre de alumno/a
    public void ordenarPorAlumno() {
        prestamos.sort((a1, a2) ->
                a1.getEstudiante().getNombre()
                        .compareToIgnoreCase(a2.getEstudiante().getNombre()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Prestamo p : prestamos) {
            sb.append(p).append("\n");
        }
        return sb.toString();
    }
}
