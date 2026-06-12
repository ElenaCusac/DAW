package models.modelos.entidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "servicios")
@NamedQueries({
    @NamedQuery(name = "Servicios.findAll", query = "SELECT s FROM Servicios s"),
    @NamedQuery(name = "Servicios.findById", query = "SELECT s FROM Servicios s WHERE s.codServicio = :codServicio"),
    @NamedQuery(name = "Servicios.findByNombre", query = "SELECT s FROM Servicios s WHERE s.nombre = :nombre")
})
public class Servicios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codServicio")
    private Integer codServicio;

    @Basic(optional = false)
    @Column(name = "nombre", length = 40)
    private String nombre;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<DetalleServicios> detalleServiciosCollection;

    public Integer getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(Integer codServicio) {
        this.codServicio = codServicio;
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

    public Collection<DetalleServicios> getDetalleServiciosCollection() {
        return detalleServiciosCollection;
    }

    public void setDetalleServiciosCollection(Collection<DetalleServicios> detalleServiciosCollection) {
        this.detalleServiciosCollection = detalleServiciosCollection;
    }

    public Servicios() {
    }

    public Servicios(Integer codServicio) {
        this.codServicio = codServicio;
    }

    public Servicios(Integer codServicio, String nombre, String descripcion) {
        this.codServicio = codServicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}

