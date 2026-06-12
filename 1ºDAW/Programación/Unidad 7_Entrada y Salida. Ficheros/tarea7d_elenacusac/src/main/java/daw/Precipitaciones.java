package daw;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "fecha",
        "estacionMeteorologica",
        "provincia",
        "precipitacion"
})
@Generated("jsonschema2pojo")
public class Precipitaciones {

    @JsonProperty("fecha")
    private List<Long> fecha;
    @JsonProperty("estacionMeteorologica")
    private String estacionMeteorologica;
    @JsonProperty("provincia")
    private String provincia;
    @JsonProperty("precipitacion")
    private Double precipitacion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Precipitaciones() {
    }

    public Precipitaciones(List<Long> fecha, String estacionMeteorologica, String provincia, Double precipitacion) {
        this.fecha = fecha;
        this.estacionMeteorologica = estacionMeteorologica;
        this.provincia = provincia;
        this.precipitacion = precipitacion;
    }

    @JsonProperty("fecha")
    public List<Long> getFecha() {
        return fecha;
    }

    @JsonProperty("fecha")
    public void setFecha(List<Long> fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFechaLocalDate() {
        if (fecha == null || fecha.size() < 3) {
            return null;
        }
        try {
            return LocalDate.of(fecha.get(0).intValue(), fecha.get(1).intValue(), fecha.get(2).intValue());
        } catch (Exception e) {
            return null;
        }
    }

    @JsonProperty("estacionMeteorologica")
    public String getEstacionMeteorologica() {
        return estacionMeteorologica;
    }

    @JsonProperty("estacionMeteorologica")
    public void setEstacionMeteorologica(String estacionMeteorologica) {
        this.estacionMeteorologica = estacionMeteorologica;
    }

    @JsonProperty("provincia")
    public String getProvincia() {
        return provincia;
    }

    @JsonProperty("provincia")
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @JsonProperty("precipitacion")
    public Double getPrecipitacion() {
        return precipitacion;
    }

    @JsonProperty("precipitacion")
    public void setPrecipitacion(Double precipitacion) {
        this.precipitacion = precipitacion;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Precipitaciones.class.getName()).append('@')
                .append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("fecha");
        sb.append('=');
        sb.append(((this.fecha == null) ? "<null>" : this.fecha));
        sb.append(',');
        sb.append("estacionMeteorologica");
        sb.append('=');
        sb.append(((this.estacionMeteorologica == null) ? "<null>" : this.estacionMeteorologica));
        sb.append(',');
        sb.append("provincia");
        sb.append('=');
        sb.append(((this.provincia == null) ? "<null>" : this.provincia));
        sb.append(',');
        sb.append("precipitacion");
        sb.append('=');
        sb.append(((this.precipitacion == null) ? "<null>" : this.precipitacion));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}