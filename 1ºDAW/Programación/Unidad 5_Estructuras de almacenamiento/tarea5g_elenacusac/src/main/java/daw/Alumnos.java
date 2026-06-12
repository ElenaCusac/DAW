package daw;

public class Alumnos {
    // Atributos
    private String nombre;
    private String nif;
    private int id;
    
    // Constructor
    public Alumnos(String nombre, String nif, int id) {
        this.nombre = nombre;
        this.nif = nif;
        this.id = id;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Método toString
    @Override
    public String toString() {
        return "Alumnos [Nombre = " + nombre + ", NIF = " + nif + "]";
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
        Alumnos other = (Alumnos) obj;
        if (id != other.id)
            return false;
        return true;
    }
    
    

}
