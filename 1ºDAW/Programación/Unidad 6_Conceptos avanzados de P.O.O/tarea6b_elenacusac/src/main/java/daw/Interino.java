package daw;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class Interino extends Profesor {
    // Atributos
    private LocalDate fechaInicio;
    private LocalDate fechaCese;

    // Constructor parametrizado
    public Interino(String nombre, String apellidos, String nif, String numeroSeguridadSocial, double salarioBase,
            Especialidad especialidad, double complementoSalarial, LocalDate fechaInicio) {
        super(nombre, apellidos, nif, numeroSeguridadSocial, salarioBase, especialidad, complementoSalarial);
        this.fechaInicio = LocalDate.now();
        this.fechaCese = LocalDate.now().plusMonths(6);
    }

    // Constructor por defecto
    public Interino() {

    }

    // Getters y Setters
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaCese() {
        return fechaCese;
    }

    public void setFechaCese(LocalDate fechaCese) {
        this.fechaCese = fechaCese;
    }

    // Método calcularIRPF()
    @Override
    public double calcularIRPF() {
        return getSalarioBase() * getEspecialidad().getIrpf();
    }

    // Método para calcular días trabajados
    public int calcularDiasTrabajados(){

        if (fechaCese.isBefore(LocalDate.now())) {
            return (int) ChronoUnit.DAYS.between(fechaInicio, fechaCese);
        } else {
            return (int) ChronoUnit.DAYS.between(fechaInicio, LocalDate.now());
        }

        
    }

    // Método toString
    @Override
    public String toString() {
        return "Titular [Nombre = " + nombre + ", Apellidos = " + apellidos + ", Fecha de Inicio=" + fechaInicio
                + ", Fecha de Cese = " + fechaCese + ", NIF = " + nif + ", Número Seguridad Social = " + getNumeroSeguridadSocial()
                + ", Especialidad = " + getEspecialidad() + ", Salario Base = " + getSalarioBase() 
                + ", Complemento Salarial = " + getComplementoSalarial() + "]";
    }
}
