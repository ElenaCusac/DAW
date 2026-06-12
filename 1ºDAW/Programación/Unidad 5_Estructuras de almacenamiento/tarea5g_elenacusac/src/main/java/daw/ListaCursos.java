package daw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ListaCursos {
    private Set<Cursos> listaCursos;
    private ArrayList<Cursos> lista;

    public ListaCursos(ArrayList<Cursos> lista) {
        this.listaCursos = new HashSet<>(lista);
    }

    public ListaCursos() {
        this.listaCursos = new HashSet<>();
    }

    public Set<Cursos> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(Set<Cursos> listaCursos) {
        this.listaCursos = listaCursos;
    }

    // Método para añadir un curso a la lista
    public void guardarCurso(Cursos curso){
        listaCursos.add(curso);
    }

    // Método para eliminar un estudiante de la lista (pasando el objeto)
    public void eliminarCurso(Cursos curso){
        listaCursos.remove(curso);
    }

    // Método para eliminar un estudiante de la lista (pasando el id)
    public void eliminarCurso(int id){
        for (Cursos curso : listaCursos) {
            if (curso.getId() == id) {
                listaCursos.remove(curso);
            }
        }
    }

    // Método para ver si existe un estudiante en la lista (pasando el objeto)
    public boolean existeCurso(Cursos curso){
        return listaCursos.contains(curso);
    }

    // Método para ver si existe un estudiante en la lista (pasando el id)
    public boolean existeCurso(int id){
        for (Cursos curso : listaCursos) {
            if (curso.getId() == id) {
                return listaCursos.contains(curso);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "[Lista de Cursos = " + listaCursos + "]";
    }
    
}
