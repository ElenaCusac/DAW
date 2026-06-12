package daw;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsJava {

    // 1. Obtener los primeros 5 vehículos de la lista original.
    public static List<Vehiculo> primerosCincoVehiculos(List<Vehiculo> vehiculos) {
        List<Vehiculo> primerosCinco = vehiculos.stream().limit(5).collect(Collectors.toList());
        System.out.println("Primeros 5 vehículos:");
        primerosCinco.forEach(System.out::println);
        return primerosCinco;
    }

    // 2. Obtener todos los vehículos del año 2012 e imprimir por consola.
    public static void vehiculos2012(List<Vehiculo> vehiculos) {
        System.out.println("Vehículos del año 2012:");
        vehiculos.stream().filter(v -> v.getYear() == 2012).forEach(System.out::println);
    }

    // 3. Obtener un conjunto de todos los nombres de marcas distintas.
    public static Set<String> marcasDistintas(List<Vehiculo> vehiculos) {
        Set<String> marcas = vehiculos.stream().map(Vehiculo::getMake).collect(Collectors.toSet());
        System.out.println("Marcas distintas: " + marcas);
        return marcas;
    }

    // 4. Obtener en una lista todos los vehículos ordenados por su año de fabricación, de menor a mayor.
    public static List<Vehiculo> vehiculosOrdenadosPorAnio(List<Vehiculo> vehiculos) {
        List<Vehiculo> ordenados = vehiculos.stream()
                .sorted(Comparator.comparingInt(Vehiculo::getYear))
                .collect(Collectors.toList());
        System.out.println("Vehículos ordenados por año:");
        ordenados.forEach(System.out::println);
        return ordenados;
    }

    // 5. A partir de la lista original, saltando los primeros 10 vehículos, guardar en otra lista los siguientes 5.
    public static List<Vehiculo> siguientesCincoSaltandoDiez(List<Vehiculo> vehiculos) {
        List<Vehiculo> siguientes = vehiculos.stream().skip(10).limit(5).collect(Collectors.toList());
        System.out.println("Siguientes 5 vehículos saltando los primeros 10:");
        siguientes.forEach(System.out::println);
        return siguientes;
    }

    // 6. Verificar si existe algún vehículo de color "Green".
    public static boolean existeVehiculoVerde(List<Vehiculo> vehiculos) {
        boolean existe = vehiculos.stream().anyMatch(v -> "Green".equals(v.getColor()));
        System.out.println("¿Existe algún vehículo verde? " + existe);
        return existe;
    }

    // 7. Verificar si todos los vehículos son del año 1990 o superior.
    public static boolean todosVehiculos1990OSuperior(List<Vehiculo> vehiculos) {
        boolean todos = vehiculos.stream().allMatch(v -> v.getYear() >= 1990);
        System.out.println("¿Todos los vehículos son del año 1990 o superior? " + todos);
        return todos;
    }

    // 8. Contar cuántos vehículos son marca "Ford".
    public static long contarVehiculosFord(List<Vehiculo> vehiculos) {
        long count = vehiculos.stream().filter(v -> "Ford".equals(v.getMake())).count();
        System.out.println("Número de vehículos Ford: " + count);
        return count;
    }

    // 9. Obtener el año más pequeño de toda la lista.
    public static int anioMasPequeno(List<Vehiculo> vehiculos) {
        int minAnio = vehiculos.stream().mapToInt(Vehiculo::getYear).min().orElse(0);
        System.out.println("Año más pequeño: " + minAnio);
        return minAnio;
    }

    // 10. Obtener un conjunto (Set) de colores únicos de vehículos fabricados después del 2010.
    public static Set<String> coloresUnicosDespues2010(List<Vehiculo> vehiculos) {
        Set<String> colores = vehiculos.stream()
                .filter(v -> v.getYear() > 2010)
                .map(Vehiculo::getColor)
                .collect(Collectors.toSet());
        System.out.println("Colores únicos después de 2010: " + colores);
        return colores;
    }

    // 11. Obtener un map, por cada color de vehículo asocie cuantos objetos hay de ese color. Usa groupingBy.
    public static Map<String, Long> mapaColores(List<Vehiculo> vehiculos) {
        Map<String, Long> mapa = vehiculos.stream()
                .collect(Collectors.groupingBy(Vehiculo::getColor, Collectors.counting()));
        System.out.println("Mapa de colores: " + mapa);
        return mapa;
    }

    // 12. Dado que hay matrículas repetidas (vehicle_license_plate), obtén un mapa donde para cada placa (licensePlate) se asocie la lista de vehículos con esa placa. Usa groupingBy
    public static Map<String, List<Vehiculo>> mapaPlacas(List<Vehiculo> vehiculos) {
        Map<String, List<Vehiculo>> mapa = vehiculos.stream()
                .collect(Collectors.groupingBy(Vehiculo::getLicensePlate));
        System.out.println("Mapa de placas:");
        mapa.forEach((placa, lista) -> {
            System.out.println("Placa: " + placa + " - Vehículos: " + lista.size());
        });
        return mapa;
    }
}
