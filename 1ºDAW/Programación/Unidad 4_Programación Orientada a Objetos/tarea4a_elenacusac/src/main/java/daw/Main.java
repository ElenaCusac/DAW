package daw;

public class Main {
    public static void main(String[] args) {

        boolean salir = false;

        while (!salir) {
            System.out.println(Juegos.MensajeInicial);
            String puertaOVentana = Juegos.DecidirPuertaVentana();

            String resultado = "";

            if (puertaOVentana.equalsIgnoreCase("puerta")) {
                resultado = Juegos.CasoPuerta();
            } else if (puertaOVentana.equalsIgnoreCase("ventana")) {
                // Suponiendo que existe CasoVentana()
                resultado = Juegos.CasoVentana();
            }

            if (resultado.equalsIgnoreCase("salir")) {
                salir = true;
                System.out.println("Fin del juego. Gracias por jugar.");
            } else if (resultado.equalsIgnoreCase("salvado")) {
                System.out.println("¡Has logrado salir con vida! Fin del juego.");
                salir = true;
            } else if (resultado.equalsIgnoreCase("reiniciar")) {
                System.out.println("Reiniciando el juego...\n\n");
            }
        }
    }
}
