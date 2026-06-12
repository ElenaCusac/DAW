package biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random; 

public class CarteraEstudiantes {
    private ArrayList<Estudiante> estudiantes;

    // Constructor predeterminado con un tamaño 100
    public CarteraEstudiantes() {
        this.estudiantes = new ArrayList<>(100);
    }

    // 1. Método para añadir un estudiante a la lista
    public void añadir(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    // 2.1. Método para borrar un estudiante de la lista 
    public void borrar(Estudiante estudiante) {
        estudiantes.remove(estudiante);
    }

    // 2.2. Método para borrar un estudiante de la lista según su DNI
    public void borrar(String dni) {
        estudiantes.removeIf(estudiante -> estudiante.getDni().equals(dni));
    }

    // 2.3. Método para borrar un estudiante de la lista según su posición
    public void borrar(int pos) {
        if (pos < 0 || pos >= estudiantes.size()) {
            throw new IllegalArgumentException("Posición fuera de rango.");
        }
        estudiantes.remove(pos);
    }

    // 3.1. Método para buscar la posición de un estudiante de la lista
    public int buscar(Estudiante estudiante){
        return estudiantes.indexOf(estudiante);
    }

    // 3.2. Método para buscar a un estudiante de la lista según su DNI
    public boolean buscarPorDNI(String dni){
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }

    // 3.3. Método para buscar a un estudiante de la lista según su DNI y devuelva al estudiante
    public Estudiante buscar(String dni) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getDni().equals(dni)) {
                return estudiante;
            }
        }
        return null;
    }

    // 4. Método para ver si la lista de esudiantes está vacía
    public boolean estaVacia(ArrayList<Estudiante> estudiantes) {
        return estudiantes.isEmpty();
    }

    // 5. Método que devuelve el tamaño de la lista
    public int tamaño() {
        return estudiantes.size();
    }

    // 6. Método para ordenar la lista alfabéticamente por los nombres
    public void ordenarLista(ArrayList<Estudiante> lista){
        Collections.sort(lista, (l1, l2) -> l1.getNombre().compareTo(l2.getNombre()));
    }

    // 7. Método que elige y devuelve un estudiante aleatorio de la cartera
    public Estudiante obtenerEstudiante(){
        return estudiantes.get(new Random().nextInt(0, estudiantes.size()));
    }

}
