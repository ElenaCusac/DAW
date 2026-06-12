package ficheros;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {
    public static void escribir(String archivo, List<Vehiculo> vehiculos) throws IOException, CsvException {
        try (FileWriter writer = new FileWriter(archivo)) {
            ColumnPositionMappingStrategy<Vehiculo> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Vehiculo.class);
            strategy.setColumnMapping("vin", "licensePlate"); // Solo estos campos

            StatefulBeanToCsv<Vehiculo> beanToCsv = new StatefulBeanToCsvBuilder<Vehiculo>(writer)
                    .withMappingStrategy(strategy)
                    .withSeparator(';')
                    .withApplyQuotesToAll(false)
                    .build();

            beanToCsv.write(vehiculos);
        }
    }
}