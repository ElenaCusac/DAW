package modelo;

import java.time.LocalDate;

public class Animal {
    // Atributos de la clase
    private String nombre;
    private double peso; // en gramos
    private LocalDate fechaNacimiento;

    private final String[] tipoAnimal = { "gato", "perro", "lagarto", "cobaya", "periquito" };
    private final String[] estadoAnimal = { "comiendo", "durmiendo", "reposando", "jugando" };

    private String estado;
    private final String tipo;

    // Constructor por defecto
    public Animal() {
        this.nombre = "Nombre por defecto";
        this.peso = 5000; // gramos
        this.fechaNacimiento = LocalDate.of(2020, 1, 1);
        this.estado = "reposando";
        this.tipo = "perro";
    }

    // Constructor parametrizado
    public Animal(String nombre, double peso, LocalDate fechaNacimiento, String tipo) {
        // Asegurarse de que los parámetros son válidos
        // Si el nombre es nulo
        if (nombre == null) {
            throw new IllegalArgumentException("Error: Nombre no válido.");
        }

        // Si el peso está fuera del rango válido
        if (peso < 10 || peso > 100000) {
            throw new IllegalArgumentException("Error: Peso no válido.");
        }

        // Si la fecha de nacimiento está fuera del rango válido
        if (fechaNacimiento == null || fechaNacimiento.isBefore(LocalDate.of(2000, 1, 1)) || fechaNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Error: Fecha de nacimiento no válida.");
        }

        // Si el tipo de animal no es válido
        boolean tipoValido = false;
        // Recorre todo el array de tipos válidos. Si se ha introducido mal, salta una excepción
        for (String tipoAnimalValido : tipoAnimal) {
            if (tipo.equalsIgnoreCase(tipoAnimalValido)) {
                tipoValido = true;
                break;
            }
        }

        if (!tipoValido) {
            throw new IllegalArgumentException("Error: Tipo de animal no válido.");
        }

        this.nombre = nombre;
        this.peso = peso;
        this.fechaNacimiento = fechaNacimiento;
        this.tipo = tipo.toLowerCase();
        this.estado = "reposando";
    }

    // Constructor copia
    public Animal(Animal pet) {
        if (pet == null) {
            throw new IllegalArgumentException("Error: Animal nulo.");
        }
        this.nombre = pet.nombre;
        this.peso = pet.peso;
        this.fechaNacimiento = pet.fechaNacimiento;
        this.tipo = pet.tipo;
        this.estado = pet.estado;
    }

    // Método clonar
    public static Animal clonar(Animal pet) {
        if (pet == null) {
            throw new NullPointerException("Error: No se puede clonar un animal nulo.");
        }
        return new Animal(pet);
    }

    // Getters y Setters de Nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Error: Nombre no válido.");
        }
        this.nombre = nombre;
    }

    // Getters y Setters de Peso
    public double getPeso() {
        return peso;
    }

    // Si quieren cambiar el peso, debe estar entre 10 y 100000 gramos
    public void setPeso(double peso) {
        if (peso < 10 || peso > 100000) {
            throw new IllegalArgumentException("Error: Peso no válido.");
        }
        this.peso = peso;
    }

    // Getters y Setters de Fecha de Nacimiento
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null ||
                fechaNacimiento.isBefore(LocalDate.of(2000, 1, 1)) ||
                fechaNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Error: Fecha de nacimiento no válida.");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y Setters de Tipo
    public String[] getTipoAnimal() {
        return tipoAnimal;
    }

    public String getTipo() {
        return tipo;
    }

    // Getters y Setters de Estado
    public String[] getEstadoAnimal() {
        return estadoAnimal;
    }

    public void setEstadoAnimal(String estado) {
        // Verificar que el estado existe y es válido
        boolean valido = false;
        for (String e : estadoAnimal) {
            if (e.equalsIgnoreCase(estado)) {
                valido = true;
                break;
            }
        }
        if (!valido) {
            throw new IllegalArgumentException("Error: Estado no válido.");
        }
        this.estado = estado.toLowerCase();
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Animal [Nombre = " + nombre +
                ", Peso = " + peso +
                ", Fecha de Nacimiento = " + fechaNacimiento +
                ", Tipo de Animal = " + tipo +
                ", Estado del Animal = " + estado + "]";
    }

    // Método para comer
    public void comer(double cantidadGramos) {
        if (cantidadGramos < 0) {
            cantidadGramos = -cantidadGramos;
        }
        this.peso += cantidadGramos;
        this.estado = "comiendo";
    }

    // Método para dormir
    public void dormir() {
        this.estado = "durmiendo";
    }

    // Método para despertar
    public void despertar() {
        this.estado = "reposando";
    }

    // Método para descansar
    public void descansar() {
        this.estado = "reposando";
    }

    // Método para descansar
    public void jugar(int cantidadMinutos) {

        // Si los minutos son negativos, se cambia a positivo
        if (cantidadMinutos < 0) {
            cantidadMinutos = -cantidadMinutos;
        }

        // 
        if (cantidadMinutos > 180) {
            throw new IllegalArgumentException("Error: El animal no puede jugar tanto tiempo.");
        }

        if (cantidadMinutos < 30) {
            peso *= 0.90;
        } else {
            int bloques = cantidadMinutos / 30;
            for (int i = 0; i < bloques; i++) {
                peso *= 0.80;
            }
        }

        this.estado = "jugando";
    }
}
