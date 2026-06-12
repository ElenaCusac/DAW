package daw;

import com.opencsv.bean.CsvBindByName;

public class Vehiculo {
    @CsvBindByName(column = "vehicle_make")
    private String make;

    @CsvBindByName(column = "vehicle_model")
    private String model;

    @CsvBindByName(column = "vehicle_year")
    private int year;

    @CsvBindByName(column = "vehicle_vin")
    private String vin;

    @CsvBindByName(column = "vehicle_color")
    private String color;

    @CsvBindByName(column = "vehicle_license_plate")
    private String licensePlate;

    // Constructor vacío para OpenCSV
    public Vehiculo() {}

    // Getters y setters
    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", vin='" + vin + '\'' +
                ", color='" + color + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
}