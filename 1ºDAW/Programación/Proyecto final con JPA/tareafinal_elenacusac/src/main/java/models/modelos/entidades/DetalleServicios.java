package models.modelos.entidades;

import java.io.Serializable;

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

@Entity
@Table(name = "detalleServicios")
@NamedQueries({
        @NamedQuery(name = "DetalleServicios.findAll", query = "SELECT d FROM DetalleServicios d"),
        @NamedQuery(name = "DetalleServicios.findById", query = "SELECT d FROM DetalleServicios d WHERE d.codDetalleServicio = :codDetalleServicio"),
        @NamedQuery(name = "DetalleServicios.findByCodCliente", query = "SELECT d FROM DetalleServicios d WHERE d.codCliente = :codCliente"),
        @NamedQuery(name = "DetalleServicios.findByCodServicio", query = "SELECT d FROM DetalleServicios d WHERE d.codServicio = :codServicio"),
        @NamedQuery(name = "DetalleServicios.findByCantidad", query = "SELECT d FROM DetalleServicios d WHERE d.cantidad = :cantidad")
})
public class DetalleServicios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codDetalleServicio")
    private Integer codDetalleServicio;

    @Basic(optional = false)
    @Column(name = "codCliente")
    private Integer codCliente;

    @Basic(optional = false)
    @Column(name = "codServicio")
    private Integer codServicio;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "observaciones", length = 100)
    private String observaciones;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "codCliente", referencedColumnName = "codCliente", insertable = false, updatable = false)
    private Clientes cliente;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "codServicio", referencedColumnName = "codServicio", insertable = false, updatable = false)
    private Servicios servicio;

    public DetalleServicios() {
    }

    public DetalleServicios(Integer codDetalleServicio) {
        this.codDetalleServicio = codDetalleServicio;
    }

    public DetalleServicios(Integer codDetalleServicio, Integer codServicio, Integer codCliente) {
        this.codDetalleServicio = codDetalleServicio;
        this.codServicio = codServicio;
        this.codCliente = codCliente;
    }

    public Integer getCodDetalleServicio() {
        return codDetalleServicio;
    }

    public void setCodDetalleServicio(Integer codDetalleServicio) {
        this.codDetalleServicio = codDetalleServicio;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Integer getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(Integer codServicio) {
        this.codServicio = codServicio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Servicios getServicio() {
        return servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }
}

