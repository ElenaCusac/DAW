package daw;

public enum Especialidad {

    SECUNDARIA("Secundaria",  0.25), 
    PROFESORTECNICO("PT", 0.23);

    private String nombre;
    private double irpf;

    private Especialidad(String nombre, double irpf) {
        this.nombre = nombre;
        this.irpf = irpf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getIrpf() {
        return irpf;
    }

    public void setIrpf(double irpf) {
        this.irpf = irpf;
    } 
}
