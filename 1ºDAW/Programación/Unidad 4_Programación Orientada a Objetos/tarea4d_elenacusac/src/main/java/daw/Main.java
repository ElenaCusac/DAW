package daw;

import javax.swing.JOptionPane;

/* Implementa un programa que haga uso exclusivamente de los métodos de las cadenas de texto. 
En una clase que contenga el main realiza un pequeño validador de nombres de usuario para una red social. 
El programa debe validar que un nombre de usuario (debe convertirse todo a minúsculas antes de validarlo) 
cumpla las siguientes condiciones:

1. Debe tener entre 4 y 15 caracteres
2. Debe comenzar con una letra
3. Solo puede contener letras, números y guiones bajos
4. No puede terminar en guion bajo
5. No puede contener dos guiones bajos seguidos

Cada uno de los puntos anteriores debe realizarse en una función diferente que reciba un String y 
devuelva si cumple la restricción correspondiente. Realiza diferentes pruebas en tu programa para 
comprobar que todo funciona correctamente.
 */

public class Main {
    public static void main(String[] args) {

        boolean nombreValido = true;

        do {
            String nombreUsuario = JOptionPane.showInputDialog("Introduce tu nombre de usuario:");
            nombreUsuario = nombreUsuario.toLowerCase();

            // Validar el nombre de usuario.

            // Si todas las validaciones son correctas, o lo que es lo mismo, si todas las
            // funciones devuelven true,
            // se muestra un mensaje indicando que el nombre de usuario es válido.
            if (validarLongitud(nombreUsuario) && validarInicioLetra(nombreUsuario) &&
                    validarCaracteres(nombreUsuario) && validarFinNoGuionBajo(nombreUsuario) &&
                    validarNoGuionesSeguidos(nombreUsuario)) {
                JOptionPane.showMessageDialog(null, "Nombre de usuario válido.");
                nombreValido = true;
                // Si alguna de las validaciones falla, se muestra un mensaje indicando que el
                // nombre de usuario es inválido con
                // el motivo correspondiente.
            } else if (validarLongitud(nombreUsuario) == false) {
                JOptionPane.showMessageDialog(null, "Nombre de usuario inválido.");
                JOptionPane.showMessageDialog(null, "Recuerda que el usuario debe tener entre 4 y 15 caracteres.");
                nombreValido = false;
            } else if (validarInicioLetra(nombreUsuario) == false) {
                JOptionPane.showMessageDialog(null, "Nombre de usuario inválido.");
                JOptionPane.showMessageDialog(null, "Recuerda que el usuario debe empezar por una letra.");
                nombreValido = false;
            } else if (validarCaracteres(nombreUsuario) == false) {
                JOptionPane.showMessageDialog(null, "Nombre de usuario inválido.");
                JOptionPane.showMessageDialog(null,
                        "Recuerda que el usuario solo puede contener letras, números y guiones bajos.");
                nombreValido = false;
            } else if (validarFinNoGuionBajo(nombreUsuario) == false) {
                JOptionPane.showMessageDialog(null, "Nombre de usuario inválido.");
                JOptionPane.showMessageDialog(null, "Recuerda que el usuario no puede terminar en guión bajo.");
                nombreValido = false;
            } else if (validarNoGuionesSeguidos(nombreUsuario) == false) {
                JOptionPane.showMessageDialog(null, "Nombre de usuario inválido.");
                JOptionPane.showMessageDialog(null,
                        "Recuerda que el usuario no puede tener dos guiones bajos seguidos.");
                nombreValido = false;
            }
        } while (!nombreValido);

    }

    // Función que valida la longitud del nombre de usuario.
    public static boolean validarLongitud(String nombreUsuario) {
        return nombreUsuario.length() >= 4 && nombreUsuario.length() <= 15;
    }


    // Función que valida que el nombre de usuario comienza con una letra.
    public static boolean validarInicioLetra(String nombreUsuario) {

        // Si el primer carácter del usuario no es una letra, devuelve false
        char primerCaracter = nombreUsuario.charAt(0);
        return Character.isLetter(primerCaracter);
    }


    // Función que valida que el nombre de usuario solo contiene letras, números y guiones bajos.
    public static boolean validarCaracteres(String nombreUsuario) {

        // Recorre todos los caracteres del array, y si no es ni una letra, ni un número ni 
        // un guión bajo, devuelve false
        for (int i = 0; i < nombreUsuario.length(); i++) {
            char caracterUsuario = nombreUsuario.charAt(i);
            if (!Character.isLetterOrDigit(caracterUsuario) && caracterUsuario != '_') {
                return false;
            }
        }
        return true;
    }


    // Función que valida que el nombre de usuario no termina en guion bajo.
    public static boolean validarFinNoGuionBajo(String nombreUsuario) {

        // Si el último carácter del usuario es guión bajo, devuelve false
        char ultimoCaracter = nombreUsuario.charAt(nombreUsuario.length() - 1);
        return ultimoCaracter != '_';
    }


    // Función que valida que el nombre de usuario no contiene dos guiones bajos seguidos.
    public static boolean validarNoGuionesSeguidos(String nombreUsuario) {

        // Si el nombre de usuario contiene "__", devuelve false, pero si no lo
        // contiene, devuelve true.
        return !nombreUsuario.contains("__");
    }
}