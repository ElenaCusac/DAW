package models.modelos.entidades;

import java.io.Serializable;

public class ZonasPK implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer codZona;
    private Integer codParque;

    public ZonasPK() {
    }

    public ZonasPK(Integer codZona, Integer codParque) {
        this.codZona = codZona;
        this.codParque = codParque;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codZona == null) ? 0 : codZona.hashCode());
        result = prime * result + ((codParque == null) ? 0 : codParque.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ZonasPK other = (ZonasPK) obj;
        if (codZona == null) {
            if (other.codZona != null)
                return false;
        } else if (!codZona.equals(other.codZona))
            return false;
        if (codParque == null) {
            if (other.codParque != null)
                return false;
        } else if (!codParque.equals(other.codParque))
            return false;
        return true;
    }

    
}

