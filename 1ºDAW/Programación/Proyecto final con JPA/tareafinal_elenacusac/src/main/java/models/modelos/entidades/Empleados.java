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
@Table(name = "empleados")
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findById", query = "SELECT e FROM Empleados e WHERE e.codEmpleado = :codEmpleado"),
    @NamedQuery(name = "Empleados.findByNombre", query = "SELECT e FROM Empleados e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleados.findByDni", query = "SELECT e FROM Empleados e WHERE e.dni = :dni"),
    @NamedQuery(name = "Empleados.findByEmail", query = "SELECT e FROM Empleados e WHERE e.email = :email"),
    @NamedQuery(name = "Empleados.findByRol", query = "SELECT e FROM Empleados e WHERE e.rol = :rol"),
    @NamedQuery(name = "Empleados.findByTelefono", query = "SELECT e FROM Empleados e WHERE e.telefono = :telefono")
})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codEmpleado")
    private Integer codEmpleado;

    @Basic(optional = false)
    @Column(name = "nombre", length = 40)
    private String nombre;

    @Basic(optional = false)
    @Column(name = "ape1emp", length = 40)
    private String ape1emp;

    @Column(name = "ape2emp", length = 40)
    private String ape2emp;

    @Basic(optional = false)
    @Column(name = "rol", length = 40)
    private String rol;

    @Basic(optional = false)
    @Column(name = "horario", length = 40)
    private String horario;

    @Basic(optional = false)
    @Column(name = "sueldo", precision = 10, scale = 2)
    private Double sueldo;

    @Basic(optional = false)
    @Column(name = "dni", unique = true, length = 9)
    private String dni;

    @Basic(optional = false)
    @Column(name = "email", length = 40)
    private String email;

    @Basic(optional = false)
    @Column(name = "telefono", length = 9)
    private String telefono;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<DetalleEmpleado> detalleEmpleadoCollection;

    public Empleados() {
    }

    public Empleados(Integer codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public Empleados(Integer codEmpleado, String nombre, String dni) {
        this.codEmpleado = codEmpleado;
        this.nombre = nombre;
        this.dni = dni;
    }

    public Integer getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Integer codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1emp() {
        return ape1emp;
    }

    public void setApe1emp(String ape1emp) {
        this.ape1emp = ape1emp;
    }

    public String getApe2emp() {
        return ape2emp;
    }

    public void setApe2emp(String ape2emp) {
        this.ape2emp = ape2emp;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Collection<DetalleEmpleado> getDetalleEmpleadoCollection() {
        return detalleEmpleadoCollection;
    }

    public void setDetalleEmpleadoCollection(Collection<DetalleEmpleado> detalleEmpleadoCollection) {
        this.detalleEmpleadoCollection = detalleEmpleadoCollection;
    }

    
}

