package daw;

public class Singleton {
    // Atributo estático que almacenará la única instancia
    private static Singleton instance;

    // Constructor privado para evitar la instanciación con 'new'
    private Singleton() {
    }

    // Método estático público para acceder a la instancia
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Método para registrar logs
    public void log(String message) {
        System.out.println("[LOG SYSTEM]: " + message);
    }
}
