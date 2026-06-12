package ficheros;

public class Vehiculo {
    private String make;
    private String model;
    private int year;
    private String vin;
    private String color;
    private String licensePlate;

    // Constructor vacío para OpenCSV
    public Vehiculo() {}

    // Constructor con parámetros
    public Vehiculo(String make, String model, int year, String vin, String color, String licensePlate) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
        this.color = color;
        this.licensePlate = licensePlate;
    }

    // Getters y setters
    public String getMake() { 
        return make; 
    }

    public void setMake(String make) { 
        this.make = make; 
    }

    public String getModel() { 
        return model; 
    }

    public void setModel(String model) { 
        this.model = model; 
    }

    public int getYear() { 
        return year; 
    }

    public void setYear(int year) { 
        this.year = year; 
    }

    public String getVin() { 
        return vin; 
    }

    public void setVin(String vin) { 
        this.vin = vin; 
    }

    public String getColor() { 
        return color; 
    }

    public void setColor(String color) { 
        this.color = color; 
    }

    public String getLicensePlate() { 
        return licensePlate; 
    }

    public void setLicensePlate(String licensePlate) { 
        this.licensePlate = licensePlate; 
    }

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