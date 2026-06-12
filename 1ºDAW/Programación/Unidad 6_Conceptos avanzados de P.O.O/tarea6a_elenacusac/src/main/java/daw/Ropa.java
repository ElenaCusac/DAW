package daw;

public abstract class Ropa extends Producto implements SeEnvia{
    // Atributo
    private String marca;

    // Constructor
    public Ropa(int codigo, double precio, double iva, String descripcion, String marca) {
        super(codigo, precio, iva, descripcion);
        this.marca = marca;
        
    }

    // Getter y Setter
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Método toString
    @Override
    public String toString() {
        return super.toString() + " Ropa [Marca = " + marca + "]";
    }
}
