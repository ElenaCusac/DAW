package daw;

public interface SeDescarga {
    default void descargar() {
        System.out.println("http://elenacusac.daw/" + this.hashCode());
    }
}
