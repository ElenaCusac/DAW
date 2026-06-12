package modelos;

import com.opencsv.bean.CsvBindByName;

public class Plato {

    @CsvBindByName(column = "idPlato")
    private String idPlato;

    @CsvBindByName(column = "nombre")
    private String nombre;

    @CsvBindByName(column = "descripcion")
    private String descripcion;

    @CsvBindByName(column = "precio")
    private double precio;

    @CsvBindByName(column = "esTemporada")
    private boolean esTemporada;

    public Plato() {
    }

    public String getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(String idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEsTemporada() {
        return esTemporada;
    }

    public void setEsTemporada(boolean esTemporada) {
        this.esTemporada = esTemporada;
    }

    @Override
    public String toString() {
        return "Plato{" +
                "idPlato='" + idPlato + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", esTemporada=" + esTemporada +
                '}';
    }
}
