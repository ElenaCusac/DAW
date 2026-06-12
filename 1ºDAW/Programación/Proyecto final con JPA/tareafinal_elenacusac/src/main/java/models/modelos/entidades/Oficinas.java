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
@Table(name = "oficinas")
@NamedQueries({
    @NamedQuery(name = "Oficinas.findAll", query = "SELECT o FROM Oficinas o"),
    @NamedQuery(name = "Oficinas.findById", query = "SELECT o FROM Oficinas o WHERE o.codOficina = :codOficina"),
    @NamedQuery(name = "Oficinas.findByDireccion", query = "SELECT o FROM Oficinas o WHERE o.direccion = :direccion"),
    @NamedQuery(name = "Oficinas.findByTelefono", query = "SELECT o FROM Oficinas o WHERE o.telefono = :telefono"),
    @NamedQuery(name = "Oficinas.findByCodParque", query = "SELECT o FROM Oficinas o WHERE o.codParque = :codParque")
})
public class Oficinas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codOficina")
    private Integer codOficina;

    @Basic(optional = false)
    @Column(name = "direccion", length = 40)
    private String direccion;

    @Basic(optional = false)
    @Column(name = "telefono", length = 9)
    private String telefono;

    @Basic(optional = false)
    @Column(name = "codParque")
    private Integer codParque;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "codParque", referencedColumnName = "codParque", insertable = false, updatable = false)
    private Parques parque;

    public Integer getCodOficina() {
        return codOficina;
    }

    public void setCodOficina(Integer codOficina) {
        this.codOficina = codOficina;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public Oficinas() {
    }

    public Oficinas(Integer codOficina) {
        this.codOficina = codOficina;
    }

    public Oficinas(Integer codOficina, String direccion, String telefono, Integer codParque) {
        this.codOficina = codOficina;
        this.direccion = direccion;
        this.telefono = telefono;
        this.codParque = codParque;
    }
}

