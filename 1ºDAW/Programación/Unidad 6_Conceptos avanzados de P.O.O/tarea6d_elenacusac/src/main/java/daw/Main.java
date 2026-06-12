package daw;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Vehiculo> vehiculos = CsvReader.leerVehiculos("vehiculos.csv");

            // Invocar métodos de StreamsJava
            StreamsJava.primerosCincoVehiculos(vehiculos);
            System.out.println();
            StreamsJava.vehiculos2012(vehiculos);
            System.out.println();
            StreamsJava.marcasDistintas(vehiculos);
            System.out.println();
            StreamsJava.vehiculosOrdenadosPorAnio(vehiculos);
            System.out.println();
            StreamsJava.siguientesCincoSaltandoDiez(vehiculos);
            System.out.println();
            StreamsJava.existeVehiculoVerde(vehiculos);
            System.out.println();
            StreamsJava.todosVehiculos1990OSuperior(vehiculos);
            System.out.println();
            StreamsJava.contarVehiculosFord(vehiculos);
            System.out.println();
            StreamsJava.anioMasPequeno(vehiculos);
            System.out.println();
            StreamsJava.coloresUnicosDespues2010(vehiculos);
            System.out.println();
            StreamsJava.mapaColores(vehiculos);
            System.out.println();
            StreamsJava.mapaPlacas(vehiculos);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}