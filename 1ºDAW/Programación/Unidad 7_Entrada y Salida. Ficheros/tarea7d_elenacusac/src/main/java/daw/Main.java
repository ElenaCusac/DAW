package daw;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Main {
    public static void main(String[] args) {
        try {
            List<Precipitaciones> registros = LeerJson.leerVehiculos();

            System.out.println("Registros leídos:");
            registros.forEach(System.out::println);

            Map<String, Double> precipitacionPorEstacion = registros.stream()
                    .collect(Collectors.groupingBy(Precipitaciones::getEstacionMeteorologica,
                            Collectors.summingDouble(r -> r.getPrecipitacion() == null ? 0.0 : r.getPrecipitacion())));

            System.out.println();
            System.out.println("Precipitación acumulada por estación:");
            precipitacionPorEstacion.forEach((estacion, total) ->
                    System.out.printf("%s -> %.2f\n", estacion, total));

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            Path salida = Paths.get(System.getProperty("user.dir"), "mapa_precipitaciones.json");
            objectMapper.writeValue(salida.toFile(), precipitacionPorEstacion);
            System.out.println();
            System.out.println("Mapa guardado en: " + salida.toAbsolutePath());

            Optional<Precipitaciones> maxPrecipitacion = registros.stream()
                    .filter(r -> r.getPrecipitacion() != null)
                    .max(Comparator.comparingDouble(Precipitaciones::getPrecipitacion));

            System.out.println();
            System.out.println("Registro con mayor precipitación:");
            maxPrecipitacion.ifPresent(System.out::println);

            LocalDate inicio = LocalDate.of(2017, 10, 10);
            LocalDate fin = LocalDate.of(2017, 10, 20);

            List<Precipitaciones> entreFechas = registros.stream()
                    .filter(r -> {
                        LocalDate fecha = r.getFechaLocalDate();
                        return fecha != null && (fecha.isEqual(inicio) || fecha.isEqual(fin)
                                || (fecha.isAfter(inicio) && fecha.isBefore(fin)));
                    })
                    .toList();

            System.out.println();
            System.out.println("Número de registros entre 10/10/2017 y 20/10/2017: " + entreFechas.size());

            double media = entreFechas.stream()
                    .filter(r -> r.getPrecipitacion() != null)
                    .mapToDouble(Precipitaciones::getPrecipitacion)
                    .average()
                    .orElse(0.0);

            System.out.printf("Media de precipitaciones entre 10/10/2017 y 20/10/2017: %.2f", media);

        } catch (IOException e) {
            System.err.println("Error leyendo o escribiendo archivos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
