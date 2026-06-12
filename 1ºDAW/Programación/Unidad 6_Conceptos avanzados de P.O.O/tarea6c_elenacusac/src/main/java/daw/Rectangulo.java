package daw;

import java.awt.Point;

public final class Rectangulo extends Poligono implements Dibujable, Movible {
    private Point esquinaInferiorDerecha;
    private Point esquinaInferiorIzquierda;
    private Point esquinaSuperiorDerecha;
    private Point esquinaSuperiorIzquierda;

    // Constructor parametrizado
    public Rectangulo(String id, String color, int base, int altura, int numeroLados) {
        super(id, color, base, altura, numeroLados);

        this.esquinaInferiorIzquierda = new Point(0, 0);
        this.esquinaSuperiorIzquierda = new Point(0, getAltura());

        this.esquinaInferiorDerecha = new Point(base, 0);
        this.esquinaSuperiorDerecha = new Point(base, altura);
    }

    // Getters
    public Point getEsquinaInferiorDerecha() {
        return esquinaInferiorDerecha;
    }

    public Point getEsquinaInferiorIzquierda() {
        return esquinaInferiorIzquierda;
    }

    public Point getEsquinaSuperiorDerecha() {
        return esquinaSuperiorDerecha;
    }

    public Point getEsquinaSuperiorIzquierda() {
        return esquinaSuperiorIzquierda;
    }

    // Método abstracto para calcular el área del triángulo
    @Override
    public double area() {
        return getAltura() * getBase();
    }

    // Método toString con los atributos de la superclase
    @Override
    public String toString() {
        return "Rectángulo [Base = " + getBase() + ", Altura = " + getAltura() + ", Número de Lados = "
                + getNumeroLados() + ", ID = " + getId() + ", Color = " + getColor() + "]";
    }

    @Override
    public void mover(int dx, int dy) {
        this.esquinaInferiorIzquierda = new Point(dx, dy);
        this.esquinaInferiorDerecha = new Point(getBase() + dx, dy);
        this.esquinaSuperiorIzquierda = new Point(dx, getAltura() + dy);
        this.esquinaSuperiorDerecha = new Point(getBase() + dx, getAltura() + dy);
    }

    @Override
    public void dibujar() {
        // Dibuja el contorno hueco del rectángulo con asteriscos
        for (int i = 0; i < getAltura(); i++) {
            for (int j = 0; j < getBase(); j++) {
                // Primera fila: dibuja asteriscos en toda la base
                // Última fila: dibuja asteriscos en toda la base
                // Filas intermedias: asteriscos solo en los extremos (columna 0 y columna base-1)
                if (i == 0 || i == getAltura() - 1 || j == 0 || j == getBase() - 1) {
                    System.out.print("*");
                } else {
                    // Interior vacío: solo espacios en blanco
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
