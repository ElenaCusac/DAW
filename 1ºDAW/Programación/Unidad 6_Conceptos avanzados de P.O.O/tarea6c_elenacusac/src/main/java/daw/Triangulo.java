package daw;

import java.awt.Point;

public final class Triangulo extends Poligono implements Comparable<Triangulo>{
    // Atributos
    private Point esquinaDerecha;
    private Point esquinaIzquierda;
    private Point punta;
    
    // Constructor parametrizado
    public Triangulo(String id, String color, int base, int altura, int numeroLados) {
        super(id, color, base, altura, numeroLados);

        this.esquinaIzquierda = new Point(0, 0);
        this.esquinaDerecha = new Point(base, 0);

        this.punta = new Point(((int) esquinaIzquierda.distance(esquinaDerecha))/2, altura);
    }

    // Getters
    public Point getEsquinaDerecha() {
        return esquinaDerecha;
    }

    public Point getEsquinaIzquierda() {
        return esquinaIzquierda;
    }

    public Point getPunta() {
        return punta;
    }

    // Método abstracto para calcular el área del triángulo
    @Override
    public double area() {
        return (getAltura()*getBase())/2;
    }

    // Método toString con los atributos de la superclase
    @Override
    public String toString() {
        return "Triángulo [Base = " + getBase() + ", Altura = " + getAltura() + ", Número de Lados = " + getNumeroLados() + ", ID = " + getId()
                + ", Color = " + getColor() + "]";
    }

    // Método compareTo
    @Override
    public int compareTo(Triangulo arg0) {
        return Integer.compare(this.getBase(), arg0.getBase());
    }
}
