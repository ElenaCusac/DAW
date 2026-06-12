package daw;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Academia {
    // Atributos
    private String nombre;
    private Direccion direccion;
    private List<Empleado> empleados;
    private Set<Alumno> alumnado;

    // Constructor parametrizado
    public Academia(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.alumnado = new HashSet<>();
        this.empleados = new ArrayList<>();
    }

    // Constructor por defecto
    public Academia() {
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Set<Alumno> getAlumnado() {
        return alumnado;
    }

    public void setAlumnado(Set<Alumno> alumnado) {
        this.alumnado = alumnado;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    // Método para contratar a un empleado
    public void contratarEmpleado(Empleado emp){
        empleados.add(emp);
    }

    // Método para matricular a un alumno
    public void matricularAlumno(Alumno a){
        alumnado.add(a);
    }

    public void bajaAlumno(Alumno a, LocalDate fecha){
        alumnado.remove(a);
        a.setFechaBaja(fecha);
    }

    public void bajaEmpleado(Empleado emp, LocalDate fecha){
        empleados.remove(emp);
        
        // Conversión explícita: cast de Empleado a Interino para acceder a métodos específicos
        if (emp instanceof Interino) {
            ((Interino)emp).setFechaCese(fecha);
        }
    }
}
