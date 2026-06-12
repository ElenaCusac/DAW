package biblioteca;

public enum Genero {
    NOVELA("Novela"),
    FICCION("Ficción"),
    POESIA("Poesía"),
    RELATO("Relato");

    private final String descripcion;

    Genero(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}