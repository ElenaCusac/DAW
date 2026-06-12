package daw;

import java.time.Year;

public class Temperaturas {
    private String localidad;
    private Year anio;
    private double[][] matriz;

    // Inicializar localidad, año y la matriz con 12 filas y 31 columnas
    public Temperaturas(String localidad, Year anio) {
        this.localidad = localidad;
        this.anio = anio;
        this.matriz = new double[12][31];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = -200;
            }
        }
    }

    // guardarTemperatura: recibe las coordenadas del día/mes y la temperatura a guardar.
    public void guardarTemperatura(Coordenadas diaYMes, double temperatura){
        int mes = diaYMes.getFila();
        int dia = diaYMes.getColumna();

        matriz[mes][dia] = temperatura;
    }

    // borrarTemperatura: recibe las coordenadas y establece el valor a -200.0.
    public void borrarTemperatura(Coordenadas diaYMes){
        int mes = diaYMes.getFila();
        int dia = diaYMes.getColumna();

        matriz[mes][dia] = -200.0;
    }

    // mostrarTemperaturas: que muestra la localidad, el año y la matriz de valores.
    public void mostrarTemperaturas(){
        System.out.println("Localidad: " + this.localidad + "\nAño: " + this.anio);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println();
        }
    }

    // mostrarTemperaturaMes, que recibe un mes y muestra las temperaturas de los días de ese mes.
    public void mostrarTemperaturaMes(int mes){
        System.out.println("-----------------------------------------------------");
        System.out.println("Localidad: " + this.localidad + "\n Año: " + this.anio);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == mes) {
                    System.out.print(" " + matriz[i][j]);;
                }
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------------");
    }

    // mostrarTemperaturaDia, que recibe un día y muestra las temperaturas de ese día de todos los meses.
    public void mostrarTemperaturaDia(int dia){
        System.out.println("Localidad: " + this.localidad + "\n Año: " + this.anio);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (j == dia) {
                    System.out.print(" " + matriz[i][j]);
                }
            }
            System.out.println();
        }
    }
}
