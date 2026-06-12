package daw;

public final class Musica extends Producto{
    // Atributo
    private String grupo;

    // Constructor
    public Musica(int codigo, double precio, double iva, String descripcion, String grupo) {
        super(codigo, precio, iva, descripcion);
        this.grupo = grupo;
    }

    // Getter y Setter
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    // Método toString
    @Override
    public String toString() {
        return super.toString() + " Música [Grupo = " + grupo + "]";
    }
}
