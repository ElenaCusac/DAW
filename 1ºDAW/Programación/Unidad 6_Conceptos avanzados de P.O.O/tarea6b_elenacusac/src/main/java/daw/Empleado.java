package daw;

public abstract class Empleado extends Persona{
    // Atributos
    private String numeroSeguridadSocial;
    private double salarioBase;

    // Constructor parametrizado
    public Empleado(String nombre, String apellidos, String nif, String numeroSeguridadSocial, double salarioBase) {
        super(nombre, apellidos, nif);
        this.numeroSeguridadSocial = numeroSeguridadSocial;
        this.salarioBase = salarioBase;
    }

    // Constructor por defecto
    public Empleado() {
        
    }

    // Getters y Setters
    public String getNumeroSeguridadSocial() {
        return numeroSeguridadSocial;
    }
    
    public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
        this.numeroSeguridadSocial = numeroSeguridadSocial;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
    
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public abstract double calcularIRPF();
}
