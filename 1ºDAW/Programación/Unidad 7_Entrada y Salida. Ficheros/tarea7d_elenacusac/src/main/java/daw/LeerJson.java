package daw;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LeerJson {
    public static List<Precipitaciones> leerVehiculos() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path archivoRaiz = Paths.get("precipitacionesBadajoz.json");

        if (Files.exists(archivoRaiz)) {
            return objectMapper.readValue(archivoRaiz.toFile(), new TypeReference<List<Precipitaciones>>() {});
        }

        try (InputStream inputStream = LeerJson.class.getClassLoader().getResourceAsStream("precipitacionesBadajoz.json")) {
            if (inputStream == null) {
                throw new IOException("Archivo precipitacionesBadajoz.json no encontrado en la raíz del proyecto ni en resources");
            }
            return objectMapper.readValue(inputStream, new TypeReference<List<Precipitaciones>>() {});
        }
    }
}
