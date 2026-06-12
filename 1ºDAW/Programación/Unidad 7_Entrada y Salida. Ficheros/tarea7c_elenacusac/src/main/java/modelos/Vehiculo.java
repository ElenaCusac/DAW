package modelos;

public class Vehiculo {
    private String vehicle_make;
    private String vehicle_model;
    private int vehicle_year;
    private String vehicle_vin;
    private String vehicle_color;
    private String vehicle_license_plate;

    // Default constructor
    public Vehiculo() {}

    // Constructor with all fields
    public Vehiculo(String vehicle_make, String vehicle_model, int vehicle_year, String vehicle_vin, String vehicle_color, String vehicle_license_plate) {
        this.vehicle_make = vehicle_make;
        this.vehicle_model = vehicle_model;
        this.vehicle_year = vehicle_year;
        this.vehicle_vin = vehicle_vin;
        this.vehicle_color = vehicle_color;
        this.vehicle_license_plate = vehicle_license_plate;
    }

    // Getters and Setters
    public String getVehicle_make() {
        return vehicle_make;
    }

    public void setVehicle_make(String vehicle_make) {
        this.vehicle_make = vehicle_make;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public int getVehicle_year() {
        return vehicle_year;
    }

    public void setVehicle_year(int vehicle_year) {
        this.vehicle_year = vehicle_year;
    }

    public String getVehicle_vin() {
        return vehicle_vin;
    }

    public void setVehicle_vin(String vehicle_vin) {
        this.vehicle_vin = vehicle_vin;
    }

    public String getVehicle_color() {
        return vehicle_color;
    }

    public void setVehicle_color(String vehicle_color) {
        this.vehicle_color = vehicle_color;
    }

    public String getVehicle_license_plate() {
        return vehicle_license_plate;
    }

    public void setVehicle_license_plate(String vehicle_license_plate) {
        this.vehicle_license_plate = vehicle_license_plate;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "vehicle_make='" + vehicle_make + '\'' +
                ", vehicle_model='" + vehicle_model + '\'' +
                ", vehicle_year=" + vehicle_year +
                ", vehicle_vin='" + vehicle_vin + '\'' +
                ", vehicle_color='" + vehicle_color + '\'' +
                ", vehicle_license_plate='" + vehicle_license_plate + '\'' +
                '}';
    }
}