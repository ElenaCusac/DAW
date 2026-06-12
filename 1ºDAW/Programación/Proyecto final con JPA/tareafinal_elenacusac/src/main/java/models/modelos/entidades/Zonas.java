package models.modelos.entidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "zonas")
@IdClass(ZonasPK.class)
@NamedQueries({
    @NamedQuery(name = "Zonas.findAll", query = "SELECT z FROM Zonas z"),
    @NamedQuery(name = "Zonas.findByCodZona", query = "SELECT z FROM Zonas z WHERE z.codZona = :codZona"),
    @NamedQuery(name = "Zonas.findByCodParque", query = "SELECT z FROM Zonas z WHERE z.codParque = :codParque"),
    @NamedQuery(name = "Zonas.findByNombre", query = "SELECT z FROM Zonas z WHERE z.nombre = :nombre")
})
public class Zonas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "codZona")
    private Integer codZona;

    @Basic(optional = false)
    @Column(name = "nombre", length = 40)
    private String nombre;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @Id
    @Basic(optional = false)
    @Column(name = "codParque")
    private Integer codParque;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "codParque", referencedColumnName = "codParque", insertable = false, updatable = false)
    private Parques parque;

    @OneToMany(mappedBy = "zona", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<Atracciones> atraccionesCollection;

    public Integer getCodZona() {
        return codZona;
    }

    public void setCodZona(Integer codZona) {
        this.codZona = codZona;
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

    public Integer getCodParque() {
        return codParque;
    }

    public void setCodParque(Integer codParque) {
        this.codParque = codParque;
    }

    public Parques getParque() {
        return parque;
    }

    public void setParque(Parques parque) {
        this.parque = parque;
    }

    public Collection<Atracciones> getAtraccionesCollection() {
        return atraccionesCollection;
    }

    public void setAtraccionesCollection(Collection<Atracciones> atraccionesCollection) {
        this.atraccionesCollection = atraccionesCollection;
    }

    public Zonas() {
    }

    public Zonas(Integer codZona, Integer codParque) {
        this.codZona = codZona;
        this.codParque = codParque;
    }

    public Zonas(Integer codZona, String nombre, String descripcion, Integer codParque) {
        this.codZona = codZona;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codParque = codParque;
    }
}

