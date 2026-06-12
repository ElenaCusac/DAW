package daw;

import java.awt.Point;

public class Circulo extends Figura implements Movible {
    // Atributo
    private int longitudRadio;
    private final double PI = Math.PI;
    private Point centro;

    // Constructor parametrizado
    public Circulo(String id, String color, int longitudRadio) {
        super(id, color);
        this.longitudRadio = longitudRadio;
        this.centro = new Point(0, 0);
    }

    // Getter y Setter
    public int getLongitudRadio() {
        return longitudRadio;
    }

    public void setLongitudRadio(int longitudRadio) {
        this.longitudRadio = longitudRadio;
    }

    public Point getCentro() {
        return centro;
    }

    // Método toString con atributos de clase y de superclase
    @Override
    public String toString() {
        return "Circulo [Longitud del Radio = " + longitudRadio + ", ID = " + getId() + ", Color = " + getColor() + "]";
    }

    // Método para calcular el área del círculo
    @Override
    public double area() {
        return PI * (longitudRadio * longitudRadio);
    }

    // Método para mover el centro del círculo 
    @Override
    public void mover(int dx, int dy) {
        this.centro = new Point(dx, dy);
    }
}
