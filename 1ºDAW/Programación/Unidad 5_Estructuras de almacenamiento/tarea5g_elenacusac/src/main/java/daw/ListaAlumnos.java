package daw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ListaAlumnos {
    private Set<Alumnos> listaAlumnos;
    private ArrayList<Alumnos> lista;

    public ListaAlumnos(ArrayList<Alumnos> lista) {
        this.listaAlumnos = new HashSet<>(lista);
    }

    public void setListaAlumnos() {
        this.listaAlumnos = new HashSet<>();
    }

    public Set<Alumnos> getListaAlumnos() {
        return listaAlumnos;
    }

    // Método para añadir un estudiante a la lista
    public void guardarEstudiante(Alumnos alumno){
        listaAlumnos.add(alumno);
    }

    // Método para eliminar un estudiante de la lista (pasando el objeto)
    public void eliminarEstudiante(Alumnos alumno){
        listaAlumnos.remove(alumno);
    }

    // Método para eliminar un estudiante de la lista (pasando el id)
    public void eliminarEstudiante(int id){
        for (Alumnos alumno : listaAlumnos) {
            if (alumno.getId() == id) {
                listaAlumnos.remove(alumno);
                break; // Salir del bucle después de eliminar el estudiante
            }
        }
    }

    // Método para ver si existe un estudiante en la lista (pasando el objeto)
    public boolean existeEstudiante(Alumnos alumno){
        return listaAlumnos.contains(alumno);
    }

    // Método para ver si existe un estudiante en la lista (pasando el id)
    public boolean existeEstudiante(int id){
        for (Alumnos alumno : listaAlumnos) {
            if (alumno.getId() == id) {
                return listaAlumnos.contains(alumno);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "[Lista de Alumnos = " + listaAlumnos + "]";
    }


}
