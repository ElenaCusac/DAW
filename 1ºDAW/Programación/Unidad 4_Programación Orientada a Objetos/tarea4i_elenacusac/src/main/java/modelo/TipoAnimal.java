package modelo;

public enum TipoAnimal {
    GATO, PERRO, LAGARTO, COBAYA, PERIQUITO;

    private final String tipo;

    private TipoAnimal() {
        this.tipo = this.name().toLowerCase();
    }

    public String getTipo() {
        return tipo;
    }
}

    

