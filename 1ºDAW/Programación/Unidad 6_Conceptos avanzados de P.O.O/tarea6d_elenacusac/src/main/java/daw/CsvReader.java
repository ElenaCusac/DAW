package daw;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvReader {
    public static List<Vehiculo> leerVehiculos(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            CsvToBean<Vehiculo> csvToBean = new CsvToBeanBuilder<Vehiculo>(reader)
                    .withType(Vehiculo.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        }
    }
}