package daw;

public class Ropa {

    // Atributos
    private String nombre;
    private double precio;
    private int stock; 

    // Contructor inicializando todos los objetos
    public Ropa(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    
    // Método toString
    @Override
    public String toString() {
        return "Producto [Nombre = " + nombre + ", Precio = " + precio + ", Stock = " + stock + "]";
    }

}
