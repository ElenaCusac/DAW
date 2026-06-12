package models.modelos.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "atracciones")
@NamedQueries({
    @NamedQuery(name = "Atracciones.findAll", query = "SELECT a FROM Atracciones a"),
    @NamedQuery(name = "Atracciones.findById", query = "SELECT a FROM Atracciones a WHERE a.codAtraccion = :codAtraccion"),
    @NamedQuery(name = "Atracciones.findByNombre", query = "SELECT a FROM Atracciones a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Atracciones.findByFechaInstalacion", query = "SELECT a FROM Atracciones a WHERE a.fechaInstalacion = :fechaInstalacion"),
    @NamedQuery(name = "Atracciones.findByCapacidadMaxima", query = "SELECT a FROM Atracciones a WHERE a.capacidadMaxima = :capacidadMaxima"),
    @NamedQuery(name = "Atracciones.findByEdadMinima", query = "SELECT a FROM Atracciones a WHERE a.edadMinima = :edadMinima"),
    @NamedQuery(name = "Atracciones.findByCodParque", query = "SELECT a FROM Atracciones a WHERE a.codParque = :codParque"),
    @NamedQuery(name = "Atracciones.findByCodParqueAndCodZona", query = "SELECT a FROM Atracciones a WHERE a.codParque = :codParque AND a.codZona = :codZona")
})
public class Atracciones implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codAtraccion")
    private Integer codAtraccion;

    @Basic(optional = false)
    @Column(name = "nombre", length = 40)
    private String nombre;

    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaInstalacion")
    private Date fechaInstalacion;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @Basic(optional = false)
    @Column(name = "capacidadMaxima")
    private long capacidadMaxima;

    @Basic(optional = false)
    @Column(name = "edadMinima")
    private Integer edadMinima;

    @Basic(optional = false)
    @Column(name = "codZona")
    private Integer codZona;

    @Basic(optional = false)
    @Column(name = "codParque")
    private Integer codParque;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "codZona", referencedColumnName = "codZona", insertable = false, updatable = false),
        @JoinColumn(name = "codParque", referencedColumnName = "codParque", insertable = false, updatable = false)
    })
    private Zonas zona;

    public Integer getCodAtraccion() {
        return codAtraccion;
    }

    public void setCodAtraccion(Integer codAtraccion) {
        this.codAtraccion = codAtraccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInstalacion() {
        return fechaInstalacion;
    }

    public void setFechaInstalacion(Date fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(long capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public Integer getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(Integer edadMinima) {
        this.edadMinima = edadMinima;
    }

    public Integer getCodZona() {
        return codZona;
    }

    public void setCodZona(Integer codZona) {
        this.codZona = codZona;
    }

    public Integer getCodParque() {
        return codParque;
    }

    public void setCodParque(Integer codParque) {
        this.codParque = codParque;
    }

    public Zonas getZona() {
        return zona;
    }

    public void setZona(Zonas zona) {
        this.zona = zona;
    }

    public Atracciones() {
    }

    public Atracciones(Integer codAtraccion) {
        this.codAtraccion = codAtraccion;
    }

    public Atracciones(Integer codAtraccion, String nombre, Integer codZona, Integer codParque, Integer edadMinima, long capacidadMaxima) {
        this.codAtraccion = codAtraccion;
        this.nombre = nombre;
        this.codZona = codZona;
        this.codParque = codParque;
        this.edadMinima = edadMinima;
        this.capacidadMaxima = capacidadMaxima;
    }
}

