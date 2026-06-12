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
@Table(name = "entradas")
@NamedQueries({
    @NamedQuery(name = "Entradas.findAll", query = "SELECT e FROM Entradas e"),
    @NamedQuery(name = "Entradas.findById", query = "SELECT e FROM Entradas e WHERE e.codEntrada = :codEntrada"),
    @NamedQuery(name = "Entradas.findByFecha", query = "SELECT e FROM Entradas e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Entradas.findByTipoEntrada", query = "SELECT e FROM Entradas e WHERE e.tipoEntrada = :tipoEntrada"),
    @NamedQuery(name = "Entradas.findByCodParque", query = "SELECT e FROM Entradas e WHERE e.codParque = :codParque"),
    @NamedQuery(name = "Entradas.findByCodCliente", query = "SELECT e FROM Entradas e WHERE e.codCliente = :codCliente")
})
public class Entradas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codEntrada")
    private Integer codEntrada;

    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    @Basic(optional = false)
    @Column(name = "tipoEntrada", length = 20)
    private String tipoEntrada;

    @Basic(optional = false)
    @Column(name = "codParque")
    private Integer codParque;

    @Basic(optional = false)
    @Column(name = "codCliente")
    private Integer codCliente;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "codParque", referencedColumnName = "codParque", insertable = false, updatable = false)
    private Parques parque;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "codCliente", referencedColumnName = "codCliente", insertable = false, updatable = false)
    private Clientes cliente;

    public Integer getCodEntrada() {
        return codEntrada;
    }

    public void setCodEntrada(Integer codEntrada) {
        this.codEntrada = codEntrada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public Integer getCodParque() {
        return codParque;
    }

    public void setCodParque(Integer codParque) {
        this.codParque = codParque;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Parques getParque() {
        return parque;
    }

    public void setParque(Parques parque) {
        this.parque = parque;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Entradas() {
    }

    public Entradas(Integer codEntrada) {
        this.codEntrada = codEntrada;
    }

    public Entradas(Integer codEntrada, Date fecha, String tipoEntrada, Integer codParque, Integer codCliente) {
        this.codEntrada = codEntrada;
        this.fecha = fecha;
        this.tipoEntrada = tipoEntrada;
        this.codParque = codParque;
        this.codCliente = codCliente;
    }
}

