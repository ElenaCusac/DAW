package modelo;

public enum EstadoAnimal {
    COMIENDO, DURMIENDO, REPOSANDO, JUGANDO;

    private final String estado;

    private EstadoAnimal() {
        this.estado = this.name().toLowerCase();
    }

    public String getEstado() {
        return estado;
    }
}
