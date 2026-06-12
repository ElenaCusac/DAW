package daw;
public class Cursos {
    // Atributos
    private String nombre;
    private int horas;
    private int id;
    
    // Constructor que inicializa el nombre y las horas del curso
    public Cursos(String nombre, int horas, int id) {
        this.nombre = nombre;
        this.horas = horas;
        this.id = id;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
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
        return "Cursos [Nombre = " + nombre + ", Horas = " + horas + "]";
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
        Cursos other = (Cursos) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
