package daw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            Path rutaFichero = localizarFicheroCsv("vehiculos.csv");
            System.out.println("Leyendo fichero: " + rutaFichero);
            List<Vehiculo> vehiculos = leerVehiculosDesdeCsv(rutaFichero);
            System.out.println("Lista de vehículos:");
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }

            System.out.println();

            Set<String> fabricantesPink2007 = fabricantesPink2007(vehiculos);
            System.out.println("Fabricantes de coches Pink fabricados en 2007:");
            System.out.println(fabricantesPink2007);

            System.out.println();

            Set<String> fabricantesPink2007Streams = fabricantesPink2007ConStreams(vehiculos);
            System.out.println("Fabricantes de coches Pink fabricados en 2007 (Streams):");
            System.out.println(fabricantesPink2007Streams);

            System.out.println();

            Map<String, Integer> cochesPorColor = contarCochesPorColor(vehiculos);
            System.out.println("Total de coches por color:");
            System.out.println(cochesPorColor);

            System.out.println();

            Map<String, Integer> cochesPorColorStreams = contarCochesPorColorConStreams(vehiculos);
            System.out.println("Total de coches por color (Streams):");
            System.out.println(cochesPorColorStreams);

            System.out.println();

            guardarMapEnCsv(cochesPorColorStreams, "conteo_coches_por_color.csv");
            System.out.println("Se ha guardado el fichero: conteo_coches_por_color.csv");
        } catch (IOException e) {
            System.err.println("Error leyendo el fichero: " + e.getMessage());
        }
    }

    private static Path localizarFicheroCsv(String nombreFichero) throws IOException {
        Path fichero = Path.of(nombreFichero);
        if (Files.exists(fichero)) {
            return fichero;
        }
        throw new IOException("No se encontró el fichero '" + nombreFichero + "'. Asegúrate de ejecutarlo desde la carpeta del proyecto donde está '" + nombreFichero + "'.");
    }

    public static List<Vehiculo> leerVehiculosDesdeCsv(Path ruta) throws IOException {
        List<String> lineas = Files.readAllLines(ruta);
        List<Vehiculo> vehiculos = new ArrayList<>();

        for (int i = 1; i < lineas.size(); i++) {
            String linea = lineas.get(i);
            if (linea == null || linea.isBlank()) {
                continue;
            }
            Vehiculo vehiculo = crearVehiculoDesdeLinea(linea);
            vehiculos.add(vehiculo);
        }

        return vehiculos;
    }

    private static Vehiculo crearVehiculoDesdeLinea(String linea) {
        String[] columnas = linea.split(",", -1);
        if (columnas.length < 6) {
            throw new IllegalArgumentException("Línea CSV inválida: " + linea);
        }

        String marca = columnas[0].trim();
        String modelo = columnas[1].trim();
        String anio = columnas[2].trim();
        String vin = columnas[3].trim();
        String color = columnas[4].trim();
        String numLicencia = columnas[5].trim();

        return new Vehiculo(marca, modelo, anio, vin, color, numLicencia);
    }

    public static Set<String> fabricantesPink2007(List<Vehiculo> vehiculos) {
        Set<String> fabricantes = new HashSet<>();
        for (Vehiculo vehiculo : vehiculos) {
            if ("Pink".equalsIgnoreCase(vehiculo.color()) && vehiculo.anio() == "2007") {
                fabricantes.add(vehiculo.marca());
            }
        }
        return fabricantes;
    }

    public static Set<String> fabricantesPink2007ConStreams(List<Vehiculo> vehiculos) {
        return vehiculos.stream()
                .filter(vehiculo -> "Pink".equalsIgnoreCase(vehiculo.color()) && "2007".equals(vehiculo.anio()))
                .map(Vehiculo::marca)
                .collect(Collectors.toCollection(HashSet::new));
    }

    public static Map<String, Integer> contarCochesPorColor(List<Vehiculo> vehiculos) {
        Map<String, Integer> conteo = new HashMap<>();
        for (Vehiculo vehiculo : vehiculos) {
            String color = vehiculo.color();
            conteo.put(color, conteo.getOrDefault(color, 0) + 1);
        }
        return new TreeMap<>(conteo);
    }

    public static Map<String, Integer> contarCochesPorColorConStreams(List<Vehiculo> vehiculos) {
        return vehiculos.stream()
                .collect(Collectors.groupingBy(
                        Vehiculo::color,
                        TreeMap::new,
                        Collectors.summingInt(v -> 1)
                ));
    }

    public static void guardarMapEnCsv(Map<String, Integer> mapa, String nombreFichero) throws IOException {
        Path ruta = Path.of(nombreFichero);
        List<String> lineas = mapa.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toList());
        Files.write(ruta, lineas);
    }
}