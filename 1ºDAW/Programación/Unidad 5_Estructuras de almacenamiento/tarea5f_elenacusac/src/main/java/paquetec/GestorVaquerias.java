package paquetec;

import java.util.HashMap;
import java.util.Map;

public class GestorVaquerias {
    /*
     * En una estructura map, asocia a cada objeto de tipo Vaquería un identificador
     * único. Se deben poder guardar Vaquerías con sus identificadores asociados,
     * obtener una Vaquería según su identificador y obtener todas los Vaquerías
     * contenidas en la estructura map.
     */

    // Atributos
    private Vaqueria vaqueria;
    private Map<String, Vaqueria> gestorVacas;

    // Constructor
    public GestorVaquerias() {
        this.gestorVacas = new HashMap<>();
    }

    // Guardar una vaquería en el gestor
    public void guardarVaqueria(Vaqueria vaqueria, String key){
        gestorVacas.put(key, vaqueria);
    }

    // Obtener una vaquería por su identificador
    public Vaqueria obtenerVaqueria(String key){
        return gestorVacas.get(key);
    }

    // Obtener todas las vaquerías contenidas en la estructura MAP
    public void imprimirVaquerias(){
        for (Map.Entry<String, Vaqueria> entry : gestorVacas.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Vaquería: " + entry.getValue());
        }
    }
    
}
