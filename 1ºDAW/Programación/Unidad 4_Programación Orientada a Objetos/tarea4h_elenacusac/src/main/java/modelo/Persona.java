package modelo;

public class Persona {
    // Los atributos de las personas son: Nombre y Edad
    private String nombre;
    private int edad;

    // Constructor por defecto 
    public Persona() {
        this.nombre = "Juanito el Golondrina";
        this.edad = 25;
    }

    // Constructor parametrizado
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getter y Setter de Nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter de Edad
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Metodo toString
    @Override
    public String toString() {  
        return "Persona [Nombre = " + nombre + ", Edad = " + edad + "]";
    }

    // llamar (Animal pet). Este método hace que la persona en cuestión despierte al animal pet.
    public void llamar(Animal pet) {
        if (pet == null) {
            throw new IllegalArgumentException("Error: Animal nulo.");
        }
        pet.despertar();
    }

    // alimentar (Animal pet, double cantidadGramos). En este caso la persona 
    // alimenta a pet con una cantidad de comida.
    public void alimentar(Animal pet, double cantidadGramos) {
        if (pet == null) {
            throw new IllegalArgumentException("Error: Animal nulo.");
        }
        if (cantidadGramos <= 0) {
            throw new IllegalArgumentException("Error: Cantidad de comida no válida.");
        }
        pet.comer(cantidadGramos);
    }

    // jugar(Animal pet, int cantidadMinutos). La persona juega con pet la cantidad 
    // de minutos indicada en el parámetro. Si la excepción se presenta, entonces
    // debe jugar con el animal la cantidad máxima de minutos permitida.
    public void jugar(Animal pet, int cantidadMinutos) {
        if (pet == null) {
            throw new IllegalArgumentException("Error: Animal nulo.");
        }
        if (cantidadMinutos <= 0) {
            throw new IllegalArgumentException("Error: Cantidad de minutos no válida.");
        }
        try {
            pet.jugar(cantidadMinutos);
        } catch (IllegalArgumentException e) {
            pet.jugar(180);
        }
    }
}
