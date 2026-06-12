package daw;

import java.lang.Comparable;

public class Libro extends Producto implements Comparable<Libro>{
    // Atributo
    private String isbn;

    // Constructor
    public Libro(int codigo, double precio, double iva, String descripcion, String isbn) {
        super(codigo, precio, iva, descripcion);
        this.isbn = isbn;
        
    }

    // Getter y Setter
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Método toString
    @Override
    public String toString() {
        return super.toString() +  " Libro [ISBN = " + isbn + "]";
    }

    // Método hashCode
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        return result;
    }

    // Método equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Libro other = (Libro) obj;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        return true;
    }

    // Método compareTo
    @Override
    public int compareTo(Libro otro) {
        return this.isbn.compareTo(otro.isbn);
    }

}
