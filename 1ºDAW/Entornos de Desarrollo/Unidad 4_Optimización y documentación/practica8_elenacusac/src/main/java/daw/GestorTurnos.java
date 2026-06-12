package daw;

public class GestorTurnos {
    public static void main(String[] args) {
        // 1. Intenta obtener la instancia (simula que alguien entra a la tienda)
        // GestorTurnos dispensador = ... (completar)
        GestorTurnos dispensador = getInstance();

        // 2. Pide dos turnos e imprímelos (Deberían ser 1 y 2)
        int turno1 = dispensador.tomarTurno();
        dispensador.mostrarTurnoActual();

        int turno2 = dispensador.tomarTurno();
        dispensador.mostrarTurnoActual();

        // 3. Pide la instancia de nuevo en OTRA variable (simula charcutería)
        // GestorTurnos mostrador = ... (Completar)
        GestorTurnos mostrador = getInstance();

        // 4. Pide dos turnos más (Deberían ser 3 y 4)
        int turno3 = mostrador.tomarTurno();
        dispensador.mostrarTurnoActual();

        int turno4 = mostrador.tomarTurno();
        dispensador.mostrarTurnoActual();

        // 5. Verificación final:
        // Comprueba con 'if (dispensador == mostrador)' si son el mismo objeto en memoria
        if (dispensador == mostrador) {
            System.out.println();
            System.out.println("Los objetos 'dispensador' y 'mostrador' son el mismo objeto en memoria.");
        } else {
            System.out.println();
            System.out.println("Los objetos 'dispensador' y 'mostrador' no son el mismo objeto en memoria.");
        }

    }

    // Crear variable para el turno actual
    private int turnoActual;

    // Crear la instancia única
    private static GestorTurnos instancia = null;

    // Crear constructor privado y vacío
    private GestorTurnos(int turnoActual){
        this.turnoActual = turnoActual;
    }

    // Método para obtener la instancia
    public static GestorTurnos getInstance(){
        if (instancia == null) {
            instancia = new GestorTurnos(0);
        }

        return instancia;
    }

    // Método tomarTurno()
    public int tomarTurno(){
        return turnoActual++;
    }

    // Método mostrarTurnoActual
    public void mostrarTurnoActual(){
        System.out.println("Turno actual: " + turnoActual);
    }

    // Método resetearContador
    public void resetearContador(){
        turnoActual = 0;
    }       
}