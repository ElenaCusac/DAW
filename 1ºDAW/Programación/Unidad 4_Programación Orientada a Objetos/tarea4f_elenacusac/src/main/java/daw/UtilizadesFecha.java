package daw;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class UtilizadesFecha {

    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        LocalDate fecha = LocalDate.now();
        LocalDate copia = copia(fecha);

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("¿Este año es bisiesto?: " + bisiesto(copia));
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("¿Cuántos días tiene este mes?: " + diaMes(copia));
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("¿Qué día de la semana es hoy?: " + diaSemana(copia));
        System.out.println("--------------------------------------------------------------------------------------");
        mostrarFechaLarga(copia);
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Introduce el número de días que quieres adelantar: ");
        int diasAdelantados = teclado.nextInt();
        LocalDate fechaAdelantada = sumarDias(diasAdelantados, copia);
        System.out.println("La fecha se ha adelantado a " + fechaAdelantada);
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Han transcurrido " + diasTranscurridos(fechaAdelantada, copia) + " días");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("El día siguiente de la fecha es: " + siguienteDia(copia));
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("El día anterior de la fecha es: " + anteriorDia(copia));
        System.out.println("--------------------------------------------------------------------------------------");
        LocalDateTime f1 = copia.atStartOfDay();
        LocalDateTime f2 = fechaAdelantada.atStartOfDay();
        System.out.println("La diferencia de minutos entre la fecha original y la adelantada son: " + minutosEntre(f1, f2) + " minutos");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Introduce los segundos que le quieres sumar a la fecha actual: ");
        int segundosAdelantados = teclado.nextInt();
        LocalDateTime fechaConSegundos = sumarSegundos(segundosAdelantados, LocalDateTime.now());
        System.out.println("La fecha con los segundos sumados es: " + fechaConSegundos);
        System.out.println("--------------------------------------------------------------------------------------");
    }

    // - bisiesto(LocalDate fecha): devolverá si el año de la fecha es bisiesto o no.
    public static boolean bisiesto(LocalDate fecha) {
        return fecha.isLeapYear();
    }

    // - copia(LocalDate fecha): devolverá un nuevo objeto LocalDate haciendo una copia de fecha.
    public static LocalDate copia(LocalDate fecha){
        return LocalDate.of(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth());
    }

    // - diasMes(LocalDate fecha): devolverá el número de días que tiene el mes para la fecha.
    public static int diaMes(LocalDate fecha) {
        return fecha.lengthOfMonth();
    }

    // - diaSemana(LocalDate fecha): devolverá el día de la semana de la fecha (0 para domingo, ..., 6 para sábado). 
    public static int diaSemana(LocalDate fecha) {
        return fecha.getDayOfWeek().getValue() % 7;
    }

    // - mostrarFechaLarga(LocalDate fecha): mostrará la fecha en formato largo, empezando por el día de la semana 
    // (ejemplo: martes 2 de septiembre de 2003). 
    public static void mostrarFechaLarga(LocalDate fecha){
        System.out.println("Hoy es " + fecha.getDayOfWeek() + " " + fecha.getDayOfMonth() + " de " + fecha.getMonth() + " de " + fecha.getYear());
    }

    // - sumarDias(long numeroDias, LocalDate fecha): devolverá una nueva fecha después de haber sumado los días 
    // que se pasan como parámetro al objeto fecha.
    public static LocalDate sumarDias(long numeroDias, LocalDate fecha){
        return fecha.plus(numeroDias, ChronoUnit.DAYS);
    }

    //- diasTranscurridos(LocalDate fechaInicial, LocalDate fechaFinal): método que devolverá el número de días transcurridos 
    // desde la fecha inicial hasta la fecha final.
    public static long diasTranscurridos(LocalDate fechaFinal, LocalDate fechaInicial){
        return ChronoUnit.DAYS.between(fechaInicial, fechaFinal);
    }

    // - siguienteDia(LocalDate fecha): devolverá un nuevo objeto LocalDate, pasando al día siguiente de la fecha pasada.
    public static LocalDate siguienteDia(LocalDate fecha) {
        return fecha.plusDays(1);
    }

    //- anteriorDia(LocalDate fecha): igual que el método anterior pero pasando al día anterior.
    public static LocalDate anteriorDia(LocalDate fecha) {
        return fecha.minusDays(1);
    }

    // - minutosEntre(LocalDateTime fecha1, LocalDateTime fecha2): calcula los minutos entre los dos objetos, fecha1 y fecha2.
    public static long minutosEntre(LocalDateTime fecha1, LocalDateTime fecha2){
        return ChronoUnit.MINUTES.between(fecha1, fecha2);
    }

    // - sumarSegundos(long numeroSegundos, LocalDateTime fecha): devolverá un nuevo objeto LocalDateTime después de haber 
    // sumado los segundos que se pasan como parámetro.
    public static LocalDateTime sumarSegundos(long numeroSegundos, LocalDateTime fecha){
        return fecha.plusSeconds(numeroSegundos);
    }
}
