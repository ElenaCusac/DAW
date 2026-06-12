package paquetea;

import java.util.SortedMap;
import java.util.TreeMap;

public class Traductor {

    // Atributos
    private String palabraExtranjera;
    private String palabraEspaniol;

    private SortedMap<String, String> traductor;

    // Constructor vacío
    public Traductor() {
        this.traductor = new TreeMap<>();
    }

    // Getters y Setters
    public String getPalabraExtranjera() {
        return palabraExtranjera;
    }

    public void setPalabraExtranjera(String palabraExtranjera) {
        this.palabraExtranjera = palabraExtranjera;
    }

    public String getPalabraEspaniol() {
        return palabraEspaniol;
    }

    public void setPalabraEspaniol(String palabraEspaniol) {
        this.palabraEspaniol = palabraEspaniol;
    }

    // Método para guardar una traducción
    public void guardar(String palabraExtranjera, String palabraEspaniol) {
        traductor.put(palabraExtranjera, palabraEspaniol);
    }

    // Método para borrar una traducción
    public void borrar(String palabraExtranjera) {
        if (traductor.containsKey(palabraExtranjera)) {
            traductor.remove(palabraExtranjera);
        }
    }

    // Método para modificar una entrada
    public void modificar(String palabraExtranjera, String nuevaPalabraEspaniol) {
        if (traductor.containsKey(palabraExtranjera)) {
            traductor.put(palabraExtranjera, nuevaPalabraEspaniol);
        }
    }

    // Método para traducir una palabra dada
    public String traducir(String palabraExtranjera) {
        return traductor.get(palabraExtranjera);
    }

    // Método para imprimir sólo las palabras en ingles
    public void imprimirIngles(){
        for (String entrada : traductor.keySet()) {
            System.out.println(" " + entrada);
        }
    }

    // Método para imprimir sólo las palabras en ingles
    public void imprimirEspaniol(){
        for (String entrada : traductor.values()) {
            System.out.println(" " + entrada);
        }
    }

    // Método para obtener la lista de palabras extranjeras
    public SortedMap<String, String> imprimir() {
        return traductor;
    }

}
