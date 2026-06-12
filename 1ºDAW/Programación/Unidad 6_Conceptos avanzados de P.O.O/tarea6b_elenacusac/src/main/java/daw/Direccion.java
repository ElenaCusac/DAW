package daw;

public class Direccion {
    // Atributos
    private String calleNumero;
    private String cpostal;
    private String poblacion;

    // Constructor parametrizado
    public Direccion(String calleNumero, String cpostal, String poblacion) {
        if (cpostal.length() != 5) {
            this.cpostal = "00000";
        }
        
        this.calleNumero = calleNumero;
        this.cpostal = cpostal;
        this.poblacion = poblacion;
    }

    // Constructor por defecto
    public Direccion() {
    }

    // Getters y Setters
    public String getCalleNumero() {
        return calleNumero;
    }

    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

    public String getCpostal() {
        return cpostal;
    }

    public void setCpostal(String cpostal) {
        if (cpostal.length() != 5) {
            this.cpostal = "00000";
        }

        this.cpostal = cpostal;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }
}
