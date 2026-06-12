package paqueteb;

import java.util.Map;
import java.util.Random;
import java.util.HashMap;

public class Loteria {

    /*
     * Implementa en una estructura de tipo map un sistema de almacenamiento de
     * números de décimos de lotería nacional y su premio asociado.
     * 
     * Inserta en la estructura 1000 registros, inventando los números de los
     * décimos y el premio asociado.
     * 
     * Ten en cuenta que el número de décimo debe contemplar ceros a la izquierda
     * (09876, 00234, ...).
     * 
     * La aplicación debe ofrecer al usuario la posibilidad de consultar por número
     * de décimo el premio obtenido.
     */

    private Map<String, Double> premiosLoteria;
    private String numero;
    private double premio;

    public Loteria() {

        int cantidadPremios = 1000;
        this.premiosLoteria = new HashMap<>(cantidadPremios);

        for (int i = 0; i < cantidadPremios; i++) {
            String numeroFormateado = String.format("%05d", new Random().nextInt(99999));
            premiosLoteria.put(numeroFormateado, new Random().nextDouble(1000000));
        }

    }

    // Getters y Setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    // Método para consultar el premio según el número de décimo
    public Double consultarPremio(String numeroDecimo) {
        if (premiosLoteria.containsKey(numeroDecimo)) {
            return premiosLoteria.get(numeroDecimo);
        }
        
        return 0.0;
    }

    // Método para mostrar todos los números y sus premios    
    public void mostrarNumerosPremiados() {
        for (Map.Entry<String, Double> entry : premiosLoteria.entrySet()) {
            System.out.println("Número: " + entry.getKey() + ", Premio: " + entry.getValue());
        }
    }

}