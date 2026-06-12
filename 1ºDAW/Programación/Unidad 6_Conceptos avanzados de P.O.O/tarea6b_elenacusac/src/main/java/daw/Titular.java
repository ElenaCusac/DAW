package daw;

import java.time.LocalDate;

public final class Titular extends Profesor {
    // Atributo
    private LocalDate fechaJubilacion;

    // Constructor parametrizado
    public Titular(String nombre, String apellidos, String nif, String numeroSeguridadSocial, double salarioBase,
            Especialidad especialidad, double complementoSalarial, LocalDate fechaJubilacion) {
        super(nombre, apellidos, nif, numeroSeguridadSocial, salarioBase, especialidad, complementoSalarial);
        this.fechaJubilacion = fechaJubilacion;
    }

    // Constructor por defecto
    public Titular() {
    }

    // Getter y Setter
    public LocalDate getFechaJubilacion() {
        return fechaJubilacion;
    }

    public void setFechaJubilacion(LocalDate fechaJubilacion) {
        this.fechaJubilacion = fechaJubilacion;
    }

    // Método calcularIRPF()
    @Override
    public double calcularIRPF() {
        return (getSalarioBase() + getComplementoSalarial()) * getEspecialidad().getIrpf();
    }

    // Método para pedir una prórroga
    public boolean pedirProrroga(int meses) {
        if (fechaJubilacion.plusMonths(meses).isAfter(LocalDate.of(2030, 01, 01))) {
            return false;
        }

        setFechaJubilacion(fechaJubilacion.plusMonths(meses));
        return true;
    }

    // Método toString
    @Override
    public String toString() {
        return "Titular [Nombre = " + nombre + ", Apellidos = " + apellidos + ", Fecha de Jubilación=" + fechaJubilacion
                + ", NIF = " + nif + ", Número Seguridad Social = " + getNumeroSeguridadSocial() + ", Especialidad = "
                + getEspecialidad() + ", Salario Base = " + getSalarioBase() + ", Complemento Salarial = "
                + getComplementoSalarial() + "]";
    }
}
