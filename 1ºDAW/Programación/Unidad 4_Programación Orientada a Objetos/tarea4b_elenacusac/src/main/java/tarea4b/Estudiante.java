package tarea4b;

/*
​Atributos (Privados): ​nombre (String), ​idEstudiante (int), ​notaMedia (double, valor entre 0.0 y 10.0) y ​curso (String). 
​Encapsulamiento: Proporciona métodos get para todos los atributos y métodos set para notaMedia y curso.

​Constructores: ​Un constructor que inicialice nombre, idEstudiante y curso. La notaMedia debe inicializarse a 0.0.

Sobreescribe toString() para mostrar el nombre del estudiante, su ID, el curso y su nota media actual. 
​Ejemplo: "Estudiante: Ana Pérez (ID: 101), Curso: 1ESO, Nota Media: 8.5."
Un método aprobado() que devuelva true si la notaMedia es mayor o igual a 5.0, y false en caso contrario.

Añase una clase con el método main. Crea un par de objetos y prueba los métodos de la clase Estudiante. */

public class Estudiante {

    // Atributo Nombre
    private String nombre;
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Atributo ID Estudiante
    private int idEstudiante;

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    // Atributo Nota Media
    private double notaMedia;
    
    public double getNotaMedia() {
        return notaMedia;
    }

    // Atributo Curso
    private String curso;

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Estudiante(String nombre, int idEstudiante, String curso) {
        this.nombre = nombre;
        this.idEstudiante = idEstudiante;
        this.curso = curso;
        this.notaMedia = 0.0;
    }

    public void setNotaMedia(double notaMedia) {
        if (notaMedia >= 0.0 && notaMedia <= 10.0) {
            this.notaMedia = notaMedia;
        } else {
            throw new IllegalArgumentException("La nota media debe estar entre 0.0 y 10.0");
        }
    }

    public boolean aprobado() {
        return this.notaMedia >= 5.0;
    }

    @Override
    public String toString() {
        return "Estudiante: " + nombre + " (ID: " + idEstudiante + "), Curso: " + curso + ", Nota Media: " + notaMedia + ".";
    }

    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Auxiliadora Pérez", 101, "1ESO");
        estudiante1.setNotaMedia(8.5);
        System.out.println(estudiante1.toString());
        System.out.println("¿Está aprobado? " + (estudiante1.aprobado()));

        Estudiante estudiante2 = new Estudiante("Soledad Gómez", 102, "2ESO");
        estudiante2.setNotaMedia(4.3);
        System.out.println(estudiante2.toString());
        System.out.println("¿Está aprobado? " + (estudiante2.aprobado()));

        Estudiante estudiante3 = new Estudiante("Angustias Benítez", 103, "4ESO");
        estudiante3.setNotaMedia(5.2);
        System.out.println(estudiante3.toString());
        System.out.println("¿Está aprobado? " + (estudiante3.aprobado()));
    }
}