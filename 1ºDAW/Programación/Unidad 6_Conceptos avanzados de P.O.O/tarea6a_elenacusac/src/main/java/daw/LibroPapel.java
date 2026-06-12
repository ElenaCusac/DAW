package daw;

public final class LibroPapel extends Libro{
    // Atributo
    private int numPaginas;

    // Constructor
    public LibroPapel(int codigo, double precio, double iva, String descripcion, String isbn, int numPaginas) {
        super(codigo, precio, iva, descripcion, isbn);
        this.numPaginas = numPaginas;
    }

    // Getter y Setter
    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    // Método toString
    @Override
    public String toString() {
        return super.toString() + " LibroPapel [Número de Páginas = " + numPaginas + "]";
    }

    // 
    
    public void tipoLectura() {
        System.out.println("Lectura física en papel.");
    }
}
