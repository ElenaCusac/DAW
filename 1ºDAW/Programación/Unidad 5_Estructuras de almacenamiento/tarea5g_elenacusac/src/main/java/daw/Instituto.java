package daw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Instituto {
    // Atributos
    private ListaCursos conjuntoCursos;
    private ListaAlumnos conjuntoAlumnos;
    private String centro;
    private Map<Integer, ListaCursos> matriculaciones;

    // Constructor
    public Instituto(String centro, ListaCursos conjuntoCursos, ListaAlumnos conjuntoAlumnos) {
        this.centro = centro;
        this.conjuntoCursos = conjuntoCursos;
        this.conjuntoAlumnos = conjuntoAlumnos;
        this.matriculaciones = new HashMap<>();
    }

    public Instituto(String centro2, ListaAlumnos listaAlumnos, ListaCursos listaCursos) {
        this.centro = centro2;
        this.conjuntoCursos = listaCursos;
        this.conjuntoAlumnos = listaAlumnos;
        this.matriculaciones = new HashMap<>();
    }

    // Incluye getters y setters. No es necesario toString, equals ni hashcode.
    public String getCentro() {
        return centro;
    }

    public ListaCursos getConjuntoCursos() {
        return conjuntoCursos;
    }

    public void setConjuntoCursos(ListaCursos conjuntoCursos) {
        this.conjuntoCursos = conjuntoCursos;
    }

    public ListaAlumnos getConjuntoAlumnos() {
        return conjuntoAlumnos;
    }

    public void setConjuntoAlumnos(ListaAlumnos conjuntoAlumnos) {
        this.conjuntoAlumnos = conjuntoAlumnos;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public Map<Integer, ListaCursos> getMatriculaciones() {
        return matriculaciones;
    }

    public void setMatriculaciones(Map<Integer, ListaCursos> matriculaciones) {
        this.matriculaciones = matriculaciones;
    }

    // Un método público matricular, que recibe un id de alumno y un curso y si
    // ambos existen en las estructuras de datos del Instituto se actualiza la
    // lista de cursos del alumno, devolviendo true. Si no se matricula, se devuelve
    // false.
    public boolean matricular(int id, Cursos curso) {
        // Comprueba que el curso esté permitido
        if (!conjuntoCursos.existeCurso(curso)) {
            return false;
        }
        // Comprueba que el alumno exista
        if (!conjuntoAlumnos.existeEstudiante(id)) {
            return false;
        }

        // Obtiene o crea la lista de cursos del alumno y guarda el curso
        ListaCursos lista = matriculaciones.get(id);

        if (lista == null) {
            lista = new ListaCursos();
            matriculaciones.put(id, lista);
        }

        lista.guardarCurso(curso);

        return true;
    }

    // Un método público desmatricular, que recibe un id de alumno y un curso y si
    // ese alumno existe y tiene matriculado ese curso, se borra de su lista de
    // cursos
    // y se devuelve true (usa un objeto Iterator para realizar el borrado). Si no
    // existe el curso para ese alumno o el alumno no existe, devuelve false.
    public boolean desmatricular(int id, Cursos curso) {
        // Comprueba que el curso esté permitido
        Iterator<Alumnos> it = conjuntoAlumnos.getListaAlumnos().iterator();

        Alumnos encontrado = null;
        while (it.hasNext()) {
            Alumnos alumno = it.next();
            if (alumno.getId() == id) {
                encontrado = alumno;
            }
        }

        if (encontrado == null) {
            return false;
        }

        ListaCursos lista = matriculaciones.get(id);
        if (lista != null) {
            Iterator<Cursos> itc = lista.getListaCursos().iterator();
            while (itc.hasNext()) {
                Cursos c = itc.next();
                if (c.equals(curso)) {
                    itc.remove();
                    return true;
                }
            }
        }

        return false;

    }

    // Un método público que devuelve la lista de alumnos matriculados en un curso,
    // pasando el id del curso. Si un curso no tiene alumnos matriculados entonces
    // la lista está vacía.
    public ArrayList<Alumnos> alumnosMatriculados(int id) {
        ArrayList<Alumnos> alumnos = new ArrayList<>();
        for (Map.Entry<Integer, ListaCursos> entry : matriculaciones.entrySet()) {
            Integer alumnoId = entry.getKey();
            ListaCursos lista = entry.getValue();
            if (lista != null && lista.existeCurso(id)) {
                for (Alumnos alumno : conjuntoAlumnos.getListaAlumnos()) {
                    if (alumno.getId() == alumnoId) {
                        alumnos.add(alumno);
                    }
                }
            }
        }

        return alumnos;
    }

    // Un método público que devuelve una estructura de datos asociando el nombre
    // de cada curso permitido y una lista de sus alumnos matriculados. Si no hay
    // alumnos matriculados la lista está vacía.
    public Map<String, ArrayList<Alumnos>> CursoYMatriculados() {
        Map<String, ArrayList<Alumnos>> mapa = new HashMap<>();

        for (Cursos curso : conjuntoCursos.getListaCursos()) {
            ArrayList<Alumnos> listaAl = alumnosMatriculados(curso.getId());
            mapa.put(curso.getNombre(), listaAl);
        }

        return mapa;
    }

    // Devuelve un mapa (id alumno -> total horas cursadas) calculado a partir
    // de las matriculaciones actuales.
    public Map<Integer, Integer> horasPorAlumno() {
        Map<Integer, Integer> resultado = new HashMap<>();

        for (Map.Entry<Integer, ListaCursos> entry : matriculaciones.entrySet()) {
            int id = entry.getKey();
            ListaCursos lista = entry.getValue();
            int suma = 0;
            if (lista != null) {
                for (Cursos c : lista.getListaCursos()) {
                    suma += c.getHoras();
                }
            }
            resultado.put(id, suma);
        }

        return resultado;
    }
}
