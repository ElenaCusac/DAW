package daw;

public abstract class Poligono extends Figura {
    // Atributos
    private int base;
    private int altura;
    private int numeroLados;

    // Construstor parametrizado
    public Poligono(String id, String color, int base, int altura, int numeroLados) {
        super(id, color);
        this.base = base;
        this.altura = altura;
        this.numeroLados = numeroLados;
    }

    // Getters y Setters
    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getNumeroLados() {
        return numeroLados;
    }

    public void setNumeroLados(int numeroLados) {
        this.numeroLados = numeroLados;
    }

    // Método toString con los atributos de clase y superclase
    @Override
    public String toString() {
        return "Polígono [Base = " + base + ", Altura = " + altura + ", Número de Lados = " + numeroLados + ", ID = " + getId()
                + ", Color = " + getColor() + "]";
    }
    
}
