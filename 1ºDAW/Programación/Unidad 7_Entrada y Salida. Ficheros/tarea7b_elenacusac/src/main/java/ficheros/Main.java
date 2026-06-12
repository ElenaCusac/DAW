package ficheros;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            // Leer vehículos del CSV
            List<Vehiculo> vehiculos = CsvReader.leer("vehiculos.csv");

            // Filtrar vehículos de color rojo
            List<Vehiculo> vehiculosRojos = vehiculos.stream()
                    .filter(v -> "Red".equals(v.getColor()))
                    .collect(Collectors.toList());

            // Escribir al nuevo CSV
            CsvWriter.escribir("resultado.csv", vehiculosRojos);

            System.out.println("Archivo resultado.csv generado con " + vehiculosRojos.size() + " vehículos rojos.");

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}