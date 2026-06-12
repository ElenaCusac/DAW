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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "detalleEmpleado")
@NamedQueries({
    @NamedQuery(name = "DetalleEmpleado.findAll", query = "SELECT d FROM DetalleEmpleado d"),
    @NamedQuery(name = "DetalleEmpleado.findById", query = "SELECT d FROM DetalleEmpleado d WHERE d.codDetalle = :codDetalle"),
    @NamedQuery(name = "DetalleEmpleado.findByCodEmpleado", query = "SELECT d FROM DetalleEmpleado d WHERE d.codEmpleado = :codEmpleado"),
    @NamedQuery(name = "DetalleEmpleado.findByCodParque", query = "SELECT d FROM DetalleEmpleado d WHERE d.codParque = :codParque"),
    @NamedQuery(name = "DetalleEmpleado.findByFechaInicio", query = "SELECT d FROM DetalleEmpleado d WHERE d.fechaInicio = :fechaInicio")
})
public class DetalleEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codDetalle")
    private Integer codDetalle;

    @Basic(optional = false)
    @Column(name = "codEmpleado")
    private Integer codEmpleado;

    @Basic(optional = false)
    @Column(name = "codParque")
    private Integer codParque;

    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaInicio")
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaFin")
    private Date fechaFin;

    @Column(name = "observaciones", length = 100)
    private String observaciones;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "codEmpleado", referencedColumnName = "codEmpleado", insertable = false, updatable = false)
    private Empleados empleado;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "codParque", referencedColumnName = "codParque", insertable = false, updatable = false)
    private Parques parque;

    public DetalleEmpleado() {
    }

    public DetalleEmpleado(Integer codDetalle) {
        this.codDetalle = codDetalle;
    }

    public DetalleEmpleado(Integer codDetalle, Integer codEmpleado, Integer codParque) {
        this.codDetalle = codDetalle;
        this.codEmpleado = codEmpleado;
        this.codParque = codParque;
    }

    public Integer getCodDetalle() {
        return codDetalle;
    }

    public void setCodDetalle(Integer codDetalle) {
        this.codDetalle = codDetalle;
    }

    public Integer getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Integer codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public Integer getCodParque() {
        return codParque;
    }

    public void setCodParque(Integer codParque) {
        this.codParque = codParque;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public Parques getParque() {
        return parque;
    }

    public void setParque(Parques parque) {
        this.parque = parque;
    }
}

