package models.modelos.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "clientes")
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findById", query = "SELECT c FROM Clientes c WHERE c.codCliente = :codCliente"),
    @NamedQuery(name = "Clientes.findByNombre", query = "SELECT c FROM Clientes c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Clientes.findByDni", query = "SELECT c FROM Clientes c WHERE c.dni = :dni"),
    @NamedQuery(name = "Clientes.findByEmail", query = "SELECT c FROM Clientes c WHERE c.email = :email"),
    @NamedQuery(name = "Clientes.findByTelefono", query = "SELECT c FROM Clientes c WHERE c.telefono = :telefono")
})
public class Clientes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codCliente")
    private Integer codCliente;

    @Basic(optional = false)
    @Column(name = "nombre", length = 40)
    private String nombre;

    @Basic(optional = false)
    @Column(name = "ape1cli", length = 40)
    private String ape1cli;

    @Column(name = "ape2cli", length = 40)
    private String ape2cli;

    @Basic(optional = false)
    @Column(name = "dni", unique = true, length = 9)
    private String dni;

    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;

    @Basic(optional = false)
    @Column(name = "telefono", unique = true, length = 9)
    private String telefono;

    @Basic(optional = false)
    @Column(name = "email", unique = true, length = 40)
    private String email;

    @Column(name = "codResponsable")
    private Integer codResponsable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codResponsable", referencedColumnName = "codCliente", insertable = false, updatable = false)
    private Clientes responsable;

    @OneToMany(mappedBy = "responsable", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<Clientes> dependientesCollection;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<Entradas> entradasCollection;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<DetalleServicios> detalleServiciosCollection;

    public Clientes() {
    }

    public Clientes(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Clientes(Integer codCliente, String nombre, String email, Integer codResponsable) {
        this.codCliente = codCliente;
        this.nombre = nombre;
        this.email = email;
        this.codResponsable = codResponsable;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1cli() {
        return ape1cli;
    }

    public void setApe1cli(String ape1cli) {
        this.ape1cli = ape1cli;
    }

    public String getApe2cli() {
        return ape2cli;
    }

    public void setApe2cli(String ape2cli) {
        this.ape2cli = ape2cli;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCodResponsable() {
        return codResponsable;
    }

    public void setCodResponsable(java.lang.Integer codResponsable) {
        this.codResponsable = codResponsable;
    }

    public Clientes getResponsable() {
        return responsable;
    }

    public void setResponsable(Clientes responsable) {
        this.responsable = responsable;
    }

    public Collection<Clientes> getDependientesCollection() {
        return dependientesCollection;
    }

    public void setDependientesCollection(Collection<Clientes> dependientesCollection) {
        this.dependientesCollection = dependientesCollection;
    }

    public Collection<Entradas> getEntradasCollection() {
        return entradasCollection;
    }

    public void setEntradasCollection(Collection<Entradas> entradasCollection) {
        this.entradasCollection = entradasCollection;
    }

    public Collection<DetalleServicios> getDetalleServiciosCollection() {
        return detalleServiciosCollection;
    }

    public void setDetalleServiciosCollection(Collection<DetalleServicios> detalleServiciosCollection) {
        this.detalleServiciosCollection = detalleServiciosCollection;
    }
}

