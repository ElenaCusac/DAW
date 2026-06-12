package daw;

public final class LibroDigital extends Libro implements SeDescarga{
    // Atributo
    private int numKBytes;

    // Constructor
    public LibroDigital(int codigo, double precio, double iva, String descripcion, String isbn, int numKBytes) {
        super(codigo, precio, iva, descripcion, isbn);
        this.numKBytes = numKBytes;
    }

    // Getter y Setter
    public int getNumKBytes() {
        return numKBytes;
    }

    public void setNumKBytes(int numKBytes) {
        this.numKBytes = numKBytes;
    }

    // Método toString
    @Override
    public String toString() {
        return super.toString() +  " LibroDigital [Número de kB = " + numKBytes + "]";
    }

    // Método descargar
    @Override
    public void descargar() {

    }

    // Método específico de la clase
    public void tipoLectura() {
        System.out.println("Lectura digital. ");
    }
}
