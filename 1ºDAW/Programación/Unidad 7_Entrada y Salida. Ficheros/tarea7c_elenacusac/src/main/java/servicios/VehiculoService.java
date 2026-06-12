package servicios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import modelos.Vehiculo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class VehiculoService {

    public static List<Vehiculo> leerVehiculos() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = VehiculoService.class.getClassLoader().getResourceAsStream("vehiculos.json");
        if (inputStream == null) {
            throw new IOException("Archivo vehiculos.json no encontrado en resources");
        }
        return objectMapper.readValue(inputStream, new TypeReference<List<Vehiculo>>() {});
    }
}