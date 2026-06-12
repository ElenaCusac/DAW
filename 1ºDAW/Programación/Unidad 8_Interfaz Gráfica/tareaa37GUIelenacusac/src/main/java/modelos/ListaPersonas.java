
package modelos;

import java.util.ArrayList;

public class ListaPersonas {
    
    private final ArrayList<Persona> listaPersonas;

    public ListaPersonas() {
        listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("1", "Juan", "Perez", "Granada"));
        listaPersonas.add(new Persona("2", "Lucía", "Roldán", "Estepona"));
    }
    
    public ArrayList<Persona> getLista(){
        return listaPersonas;
    }
    
    public Persona getPersona(String id) {
        // Habría que controlar excepción NullPointerException en caso de que no 
        // exista el id en la lista
        return listaPersonas.stream().filter(p -> p.id().equalsIgnoreCase(id)).findFirst().orElseThrow(() -> new NullPointerException("Persona no encontrada"));
    }
    
}
