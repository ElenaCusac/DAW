package paquetec;

import java.time.LocalDate;

public class Vaca implements Comparable<Vaca> {

    // Atributos (el ID del animal no se puede cambiar)
    private final int id;
    private final LocalDate fechaNacimiento;
    private final String descripcion;

    // Constructor
    // El constructor debe inicializar la estructura SET (no hay animales duplicados
    // y el orden no importa).
    public Vaca(int id, LocalDate fechaNacimiento, String descripcion) {
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.descripcion = descripcion;
    }

    // Getters
    public int getId() {
        return id;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Vaca [ID = " + id + ", Fecha de Nacimiento = " + fechaNacimiento + ", Descripción = " + descripcion
                + "]";
    }

    // HashCode del ID
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    // Equals del ID
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vaca other = (Vaca) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public int compareTo(Vaca arg0) {
        return Integer.compare(this.id, arg0.getId());
    }
}
