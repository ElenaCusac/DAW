package daw;

public final class Pantalon extends Ropa{
    // Atributo
    private String talla;

    // Constructor
    public Pantalon(int codigo, double precio, double iva, String descripcion, String marca, String talla) {
        super(codigo, precio, iva, descripcion, marca);
        this.talla = talla;
    }

    // Getter y Setter
    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    // Método toString
    @Override
    public String toString() {
        return super.toString() + " Pantalon [Talla = " + talla + "]";
    }

    // Método enviar
    @Override
    public void enviar(String direccion) {
        System.out.println("Enviando Ropa -> " + this + " a " + direccion);
    }
}
