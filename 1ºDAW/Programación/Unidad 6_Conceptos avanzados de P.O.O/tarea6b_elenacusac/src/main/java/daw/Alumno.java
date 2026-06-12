package daw;

import java.time.LocalDate;

public class Alumno extends Persona{
    // Atributos
    private String numeroExpediente;
    private LocalDate fechaBaja;

    // Constructor parametrizado
    public Alumno(String nombre, String apellidos, String nif, String numeroExpediente, LocalDate fechaBaja) {
        super(nombre, apellidos, nif);
        this.numeroExpediente = numeroExpediente;
        this.fechaBaja = LocalDate.MAX;
    }

    // Constructor por defecto
    public Alumno() {
    }

    // Getters y Setters
    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    // Método toString
    @Override
    public String toString() {
        return "Alumno [Nombre = " + nombre + ", Apellidos = " + apellidos + ", Número de Expediente = " + numeroExpediente
                + ", NIF = " + nif + ", Fecha de la Baja = " + fechaBaja + "]";
    }

    // Método equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numeroExpediente == null) ? 0 : numeroExpediente.hashCode());
        result = prime * result + ((fechaBaja == null) ? 0 : fechaBaja.hashCode());
        return result;
    }

    // Método equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Alumno other = (Alumno) obj;
        if (numeroExpediente == null) {
            if (other.numeroExpediente != null)
                return false;
        } else if (!numeroExpediente.equals(other.numeroExpediente))
            return false;
        if (fechaBaja == null) {
            if (other.fechaBaja != null)
                return false;
        } else if (!fechaBaja.equals(other.fechaBaja))
            return false;
        return true;
    }

    
    
    
}
