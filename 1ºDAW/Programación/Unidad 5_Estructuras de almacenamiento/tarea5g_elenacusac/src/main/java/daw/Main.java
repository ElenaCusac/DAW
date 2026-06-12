package daw;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // - Crea una lista de alumnos y una lista de cursos, en las que puede haber
        // elementos repetidos, con datos inventados.
        // Crear 4 alumnos con datos inventados
        Alumnos a1 = new Alumnos("Sandra Pérez", "12345678A", 1);
        Alumnos a2 = new Alumnos("Manolo Ortiz", "98765432C", 2);
        Alumnos a3 = new Alumnos("Ramón Jiménez", "78451296A", 3);
        Alumnos a4 = new Alumnos("Lucía Gil", "13467985B", 4);

        // Guardar a los alumnos en un ArrayList (repitiendo el alumno a2)
        ArrayList<Alumnos> lista1 = new ArrayList<>();
        lista1.add(a1);
        lista1.add(a2);
        lista1.add(a3);
        lista1.add(a4);
        lista1.add(a2);
        
        // Transformar el ArrayList en un HashSet
        ListaAlumnos listaAlumnos = new ListaAlumnos(lista1);

        // Crear 4 cursos con datos inventados
        Cursos c1 = new Cursos("Lengua Castellana y Literatura", 125, 1);
        Cursos c2 = new Cursos("Historia de la Filosofía", 125, 2);
        Cursos c3 = new Cursos("Matemáticas", 250, 3);
        Cursos c4 = new Cursos("Física", 250, 4);

        // Guardar a los alumnos en una ArrayList (repitiendo el alumno a2)
        ArrayList<Cursos> lista2 = new ArrayList<>();
        lista2.add(c1);
        lista2.add(c2);
        lista2.add(c3);
        lista2.add(c4);
        lista2.add(c2);

        // Transformar el ArrayList en un HashSet
        ListaCursos listaCursos = new ListaCursos(lista2);

        // - Crea un objeto de tipo Instituto a partir de las listas anteriores.
       Instituto instituto = new Instituto("IES Mar de Alborán", listaCursos, listaAlumnos);

        // - Imprime el conjunto de alumnos y el conjunto de cursos del instituto
        System.out.println(instituto.getConjuntoAlumnos());
        System.out.println();
        System.out.println(instituto.getConjuntoCursos());
        System.out.println();

        // - Matricula a varios alumnos en varios cursos.
        instituto.matricular(1, c4);
        instituto.matricular(1, c2);
        instituto.matricular(2, c1);
        instituto.matricular(2, c3);
        instituto.matricular(3, c3);
        instituto.matricular(3, c4);
        instituto.matricular(4, c1);
        instituto.matricular(4, c2);

        // - Imprime los cursos matriculados de cada alumno.
        System.out.println(instituto.getMatriculaciones());

        // - Imprime por cada curso, sus alumnos matriculados.
        System.out.println();
        Map<String, ArrayList<Alumnos>> porCurso = instituto.CursoYMatriculados();
        for (Map.Entry<String, ArrayList<Alumnos>> entry : porCurso.entrySet()) {
            System.out.println("Curso: " + entry.getKey() + " -> " + entry.getValue());
        }

        // - Desmatricula a unos cuantos alumnos de algunos cursos.
        instituto.desmatricular(2, c1);
        instituto.desmatricular(1, c4);
        instituto.desmatricular(3, c3);

        /*
         * Vuelve a imprimir los cursos matriculados de cada alumno
         * y los alumnos matriculados en cada curso.
         */
        System.out.println();
        System.out.println(instituto.getMatriculaciones());
        System.out.println();
        Map<String, ArrayList<Alumnos>> porCurso2 = instituto.CursoYMatriculados();
        for (Map.Entry<String, ArrayList<Alumnos>> entry : porCurso2.entrySet()) {
            System.out.println("Curso: " + entry.getKey() + " -> " + entry.getValue());
        }

        /*
         * En un método de clase que reciba los cursos matriculados de cada alumno del
         * instituto, devuelve en una estructura apropiada el total de horas que cursa
         * cada alumno, según su id, e imprime por pantalla, siguiendo el siguiente
         * formato. Ten en cuenta que los id deben estar ordenados alfabéticamente:
         * id: 1 ---> Nº HORAS: 340
         * id: 2 ---> Nº HORAS: 140
         * id: 3 ---> Nº HORAS: 5
         */
        System.out.println();
        Map<Integer, Integer> horas = instituto.horasPorAlumno();
        ArrayList<Integer> ids = new ArrayList<>(horas.keySet());
        ids.sort((a, b) -> String.valueOf(a).compareTo(String.valueOf(b)));
        for (Integer id : ids) {
            System.out.println("id: " + id + " ---> Nº HORAS: " + horas.get(id));
        }
    }
}