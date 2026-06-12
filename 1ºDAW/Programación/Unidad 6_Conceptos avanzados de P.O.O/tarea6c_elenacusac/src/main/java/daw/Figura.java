package daw;

public abstract class Figura {
    // Atributos
    private String id;
    private String color;

    // Constructor
    public Figura(String id, String color) {
        this.id = id;
        this.color = color;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Equals y HashCode según su ID
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Figura other = (Figura) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    // Método toString
    @Override
    public String toString() {
        return "Figura [id=" + id + ", color=" + color + "]";
    }

    // Método abstracto para calcular el área de la figura
    public abstract double area();
}
