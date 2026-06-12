package modelos;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListaPlatos {

    private final ArrayList<Plato> listaPlatos;

    public ListaPlatos() {
        listaPlatos = new ArrayList<>();
        cargarPlatosCSV();
    }

    private void cargarPlatosCSV() {
        Path csvPath = Paths.get("restaurante.csv");
        if (!Files.exists(csvPath)) {
            csvPath = Paths.get(System.getProperty("user.dir"), "restaurante.csv");
        }
        if (!Files.exists(csvPath)) {
            System.err.println("No se encontró el fichero restaurante.csv en la carpeta del proyecto.");
            return;
        }

        try (Reader reader = Files.newBufferedReader(csvPath)) {
            CsvToBean<Plato> csvToBean = new CsvToBeanBuilder<Plato>(reader)
                    .withType(Plato.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreQuotations(true)
                    .withSeparator(',')
                    .build();

            listaPlatos.addAll(csvToBean.parse().stream()
                    .filter(plato -> plato.getPrecio() > 10.0)
                    .limit(15)
                    .collect(Collectors.toList()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Plato> getLista() {
        return listaPlatos;
    }

    public Plato getPlato(String idPlato) {
        return listaPlatos.stream()
                .filter(plato -> plato.getIdPlato().equalsIgnoreCase(idPlato))
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Plato no encontrado"));
    }
}
