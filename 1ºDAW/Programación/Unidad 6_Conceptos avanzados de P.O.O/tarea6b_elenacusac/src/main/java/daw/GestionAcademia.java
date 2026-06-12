package daw;

import java.time.LocalDate;
import java.util.*;

public class GestionAcademia {
    public static void main(String[] args) {
        // a) Crea una academia con los datos que tú quieras.
        Direccion direccion = new Direccion("Calle Mayor 123", "28013", "Madrid");
        Academia academia = new Academia("Academia DAW", direccion);

        // b) Contrata a dos empleados de cada tipo.
        // Dos Interinos
        Interino interino1 = new Interino("Juan", "Pérez", "12345678A", "SS001", 2000.0, Especialidad.SECUNDARIA, 300.0, LocalDate.of(2023, 9, 1));
        Interino interino2 = new Interino("Ana", "García", "87654321B", "SS002", 2100.0, Especialidad.PROFESORTECNICO, 350.0, LocalDate.of(2023, 10, 1));
        academia.contratarEmpleado(interino1);
        academia.contratarEmpleado(interino2);

        // Dos Titulares
        Titular titular1 = new Titular("Carlos", "López", "11223344C", "SS003", 2500.0, Especialidad.SECUNDARIA, 400.0, LocalDate.of(2050, 1, 1));
        Titular titular2 = new Titular("María", "Rodríguez", "44332211D", "SS004", 2600.0, Especialidad.PROFESORTECNICO, 450.0, LocalDate.of(2055, 1, 1));
        academia.contratarEmpleado(titular1);
        academia.contratarEmpleado(titular2);

        // c) Matricula a dos alumnos iguales y a dos alumnos diferentes.
        Alumno alumno1 = new Alumno("Pedro", "Martín", "11111111E", "EXP001", null);
        Alumno alumno2 = new Alumno("Pedro", "Martín", "11111111E", "EXP001", null); // Igual
        Alumno alumno3 = new Alumno("Lucía", "Sánchez", "22222222F", "EXP002", null);
        Alumno alumno4 = new Alumno("David", "Fernández", "33333333G", "EXP003", null);
        academia.matricularAlumno(alumno1);
        academia.matricularAlumno(alumno2);
        academia.matricularAlumno(alumno3);
        academia.matricularAlumno(alumno4);

        // d) Muestra por consola a los empleados y a los alumnos de la academia.
        System.out.println("Empleados de la academia:");
        for (Empleado emp : academia.getEmpleados()) {
            System.out.println(emp);
        }
        System.out.println();

        System.out.println("Alumnos de la academia:");
        for (Alumno al : academia.getAlumnado()) {
            System.out.println(al);
        }
        System.out.println();

        // e) Recorre la estructura de datos de los empleados, mostrando el resultado de calcularIRPF de cada uno y además pide una prórroga para los titulares, con un número de meses de tu elección, mostrando los resultados de las ejecuciones.
        System.out.println("Cálculo de IRPF y prórrogas:");
        for (Empleado emp : academia.getEmpleados()) {
            System.out.println("Empleado: " + emp.getNombre() + " " + emp.getApellidos() + ", IRPF: " + emp.calcularIRPF());
            if (emp instanceof Titular) {
                Titular titular = (Titular) emp;
                boolean prorrogado = titular.pedirProrroga(12); // 12 meses
                System.out.println("Prórroga de 12 meses concedida: " + prorrogado + ", Nueva fecha jubilación: " + titular.getFechaJubilacion());
            }
        }
        System.out.println();

        // h) Invoca al método calcularDiasInterinos y muestra los resultados por consola.
        Map<String, Integer> diasInterinos = calcularDiasInterinos(academia);
        System.out.println("Días trabajados por interinos:");
        for (Map.Entry<String, Integer> entry : diasInterinos.entrySet()) {
            System.out.println("NIF: " + entry.getKey() + ", Días trabajados: " + entry.getValue());
        }
        System.out.println();

        // f) Crea una lista de objetos que se puedan dar de baja e incluye aquellos objetos susceptibles de darse de baja de la academia. Recorre esta lista y solicita la baja, mostrando el resultado.
        List<Object> objetosBaja = new ArrayList<>();
        objetosBaja.addAll(academia.getAlumnado());
        objetosBaja.addAll(academia.getEmpleados());

        System.out.println("Dando de baja a objetos:");
        for (Object obj : objetosBaja) {
            if (obj instanceof Alumno) {
                Alumno al = (Alumno) obj;
                academia.bajaAlumno(al, LocalDate.now());
                System.out.println("Alumno dado de baja: " + al.getNombre() + " " + al.getApellidos());

            } else if (obj instanceof Empleado) {
                Empleado emp = (Empleado) obj;
                academia.bajaEmpleado(emp, LocalDate.now());
                if (emp instanceof Interino) {
                    System.out.println("Interino dado de baja: " + emp.getNombre() + " " + emp.getApellidos());
                } else {
                    System.out.println("Titular dado de baja: " + emp.getNombre() + " " + emp.getApellidos());
                }
            }
        }
        System.out.println();
    }

    // g) Crea un método de clase, llamado calcularDiasInterinos, que reciba una academia y devuelva una estructura de datos con el nif del interino y sus días trabajados.
    public static Map<String, Integer> calcularDiasInterinos(Academia academia) {
        Map<String, Integer> resultado = new HashMap<>();
        for (Empleado emp : academia.getEmpleados()) {
            if (emp instanceof Interino) {
                Interino interino = (Interino) emp;
                resultado.put(interino.getNif(), interino.calcularDiasTrabajados());
            }
        }
        return resultado;
    }
}
