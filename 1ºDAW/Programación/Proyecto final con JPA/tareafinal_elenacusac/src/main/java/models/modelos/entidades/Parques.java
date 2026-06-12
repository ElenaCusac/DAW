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
@Table(name = "parques")
@NamedQueries({
    @NamedQuery(name = "Parques.findAll", query = "SELECT p FROM Parques p"),
    @NamedQuery(name = "Parques.findById", query = "SELECT p FROM Parques p WHERE p.codParque = :codParque"),
    @NamedQuery(name = "Parques.findByNombre", query = "SELECT p FROM Parques p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Parques.findByCiudad", query = "SELECT p FROM Parques p WHERE p.ciudad = :ciudad"),
    @NamedQuery(name = "Parques.findByDireccion", query = "SELECT p FROM Parques p WHERE p.direccion = :direccion")
})
public class Parques implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codParque")
    private Integer codParque;

    @Basic(optional = false)
    @Column(name = "nombre", length = 40)
    private String nombre;

    @Basic(optional = false)
    @Column(name = "direccion", length = 40)
    private String direccion;

    @Basic(optional = false)
    @Column(name = "ciudad", length = 40)
    private String ciudad;

    @Basic(optional = false)
    @Column(name = "metrosCuadrados")
    private Long metrosCuadrados;

    @Basic(optional = false)
    @Column(name = "capacidadMaxima")
    private Long capacidadMaxima;

    @OneToMany(mappedBy = "parque", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<Oficinas> oficinasCollection;

    @OneToMany(mappedBy = "parque", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<Zonas> zonasCollection;

    @OneToMany(mappedBy = "parque", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<DetalleEmpleado> detalleEmpleadoCollection;

    @OneToMany(mappedBy = "parque", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<Entradas> entradasCollection;

    public Integer getCodParque() {
        return codParque;
    }

    public void setCodParque(Integer codParque) {
        this.codParque = codParque;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Long getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(Long metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public Long getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(Long capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public Collection<Oficinas> getOficinasCollection() {
        return oficinasCollection;
    }

    public void setOficinasCollection(Collection<Oficinas> oficinasCollection) {
        this.oficinasCollection = oficinasCollection;
    }

    public Collection<Zonas> getZonasCollection() {
        return zonasCollection;
    }

    public void setZonasCollection(Collection<Zonas> zonasCollection) {
        this.zonasCollection = zonasCollection;
    }

    public Collection<DetalleEmpleado> getDetalleEmpleadoCollection() {
        return detalleEmpleadoCollection;
    }

    public void setDetalleEmpleadoCollection(Collection<DetalleEmpleado> detalleEmpleadoCollection) {
        this.detalleEmpleadoCollection = detalleEmpleadoCollection;
    }

    public Collection<Entradas> getEntradasCollection() {
        return entradasCollection;
    }

    public void setEntradasCollection(Collection<Entradas> entradasCollection) {
        this.entradasCollection = entradasCollection;
    }

    public Parques() {
    }

    public Parques(Integer codParque) {
        this.codParque = codParque;
    }

    public Parques(Integer codParque, String nombre, String direccion, String ciudad, Long metrosCuadrados, Long capacidadMaxima) {
        this.codParque = codParque;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.metrosCuadrados = metrosCuadrados;
        this.capacidadMaxima = capacidadMaxima;
    }
}

