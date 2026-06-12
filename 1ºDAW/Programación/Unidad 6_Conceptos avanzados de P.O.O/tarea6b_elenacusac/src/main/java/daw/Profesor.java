package daw;

public abstract class Profesor extends Empleado{
    // Atributos
    private Especialidad especialidad;
    private double complementoSalarial;

    // Constructor parametrizado
    public Profesor(String nombre, String apellidos, String nif, String numeroSeguridadSocial, double salarioBase,
            Especialidad especialidad, double complementoSalarial) {
        super(nombre, apellidos, nif, numeroSeguridadSocial, salarioBase);
        this.especialidad = especialidad;
        this.complementoSalarial = complementoSalarial;
    }

    // Constructor por defecto
    public Profesor() {
    }

    // Getters y Setters
    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public double getComplementoSalarial() {
        return complementoSalarial;
    }

    public void setComplementoSalarial(double complementoSalarial) {
        this.complementoSalarial = complementoSalarial;
    }

    

    
}
