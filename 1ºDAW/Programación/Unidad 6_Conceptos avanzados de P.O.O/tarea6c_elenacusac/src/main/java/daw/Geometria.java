package daw;

import java.util.*;

public class Geometria {
    public static void main(String[] args) {
        // 1. Crear un conjunto de objetos Figura y añadir dos objetos de cada tipo
        // HashSet no mantiene el orden, pero es eficiente para búsquedas
        Set<Figura> conjuntoFiguras = new HashSet<>();
        
        // Crear dos Círculos
        // Conversión implícita: Circulo es subclase de Figura
        conjuntoFiguras.add(new Circulo("C1", "Rojo", 5));
        conjuntoFiguras.add(new Circulo("C2", "Azul", 3));
        
        // Crear dos Rectángulos
        // Conversión implícita: Rectangulo es subclase de Figura
        conjuntoFiguras.add(new Rectangulo("R1", "Verde", 4, 6, 4));
        conjuntoFiguras.add(new Rectangulo("R2", "Amarillo", 5, 3, 4));
        
        // Crear dos Triángulos
        // Conversión implícita: Triangulo es subclase de Figura
        conjuntoFiguras.add(new Triangulo("T1", "Naranja", 8, 4, 3));
        conjuntoFiguras.add(new Triangulo("T2", "Rosa", 6, 5, 3));
        
        // 2. Mostrar los datos de las figuras usando un foreach con su área
        System.out.println("--- Mostrar Figuras con Área ---");
        for (Figura figura : conjuntoFiguras) {
            System.out.println(figura + " | Área = " + figura.area());
        }
        System.out.println();

        // 3. Crear una lista a partir del conjunto de figuras
        // Conversión implícita: List<Figura> puede almacenar cualquier subclase de Figura
        List<Figura> listaFiguras = new ArrayList<>(conjuntoFiguras);
        
        // 4. Ordenar la lista de figuras por id usando Comparator y expresión lambda
        System.out.println("--- Ordenar Figuras por ID ---");
        // El método sort utiliza un Comparator que compara identificadores
        listaFiguras.sort((f1, f2) -> f1.getId().compareTo(f2.getId()));
        for (Figura figura : listaFiguras) {
            System.out.println(figura);
        }
        System.out.println();
        
        // 5. Búsqueda binaria de una figura según id
        System.out.println("--- Búsqueda Binaria ---");
        String idBuscado = "R1";
        // Conversión implícita: estamos usando Rectangulo en contexto de Figura
        Figura figuraTemp = new Rectangulo(idBuscado, "temp", 1, 1, 4);
        
        // binarySearch requiere que la lista esté ordenada
        // Utilizamos un Comparator que solo compara IDs
        int posicion = Collections.binarySearch(listaFiguras, figuraTemp, 
            (Figura f1, Figura f2) -> f1.getId().compareTo(f2.getId()));
        
        if (posicion >= 0) {
            System.out.println("Figura con ID '" + idBuscado + "' encontrada en posición: " + posicion);
        } else {
            System.out.println("Figura con ID '" + idBuscado + "' no encontrada");
        }
        System.out.println();

        // 6. Ordenar la lista por color y luego por id usando thenComparing
        System.out.println("--- Ordenar por Color e ID ---");
        listaFiguras.sort(
            Comparator.comparing(Figura::getColor)
                      .thenComparing(Figura::getId)
        );
        for (Figura figura : listaFiguras) {
            System.out.println(figura);
        }
        
        // 7. Recorrer la lista y guardar en dos nuevas listas: Dibujables y Movibles
        // Conversión explícita: necesitamos hacer casting de Figura a las interfaces
        List<Dibujable> listaDibujables = new ArrayList<>();
        List<Movible> listaMovibles = new ArrayList<>();
        
        for (Figura figura : listaFiguras) {
            // Verificación de tipo antes de la conversión explícita
            if (figura instanceof Dibujable) {
                // Conversión explícita: casting de Figura a Dibujable
                listaDibujables.add((Dibujable) figura);
            }
            if (figura instanceof Movible) {
                // Conversión explícita: casting de Figura a Movible
                listaMovibles.add((Movible) figura);
            }
        }
        System.out.println();

        // 8. Recorrer la lista de Dibujable y llamar al método dibujar
        System.out.println("--- Dibujar Figuras ---");
        for (Dibujable dibujable : listaDibujables) {
            System.out.println("Dibujando:");
            dibujable.dibujar();
        }
        System.out.println();
        
        // 9. Recorrer la lista de Movible y mover:
        // - Rectángulos 2 unidades a la derecha (dx=2, dy=0)
        // - Círculos 3 unidades arriba (dx=0, dy=3)
        System.out.println("--- Mover Figuras---");
        for (Movible movible : listaMovibles) {
            // Conversión explícita: casting de Movible a Figura para acceder a getId()
            Figura figuraMovible = (Figura) movible;
            
            if (movible instanceof Rectangulo) {
                // El Rectángulo se mueve 2 unidades a la derecha
                System.out.println("Moviendo Rectángulo " + figuraMovible.getId() + " 2 unidades a la derecha");
                movible.mover(2, 0);
            } else if (movible instanceof Circulo) {
                // El Círculo se mueve 3 unidades hacia arriba
                System.out.println("Moviendo Círculo " + figuraMovible.getId() + " 3 unidades hacia arriba");
                movible.mover(0, 3);
            }
        }
        System.out.println();
        
        // 10. Método de clase que obtiene una estructura que asocie figura con su área
        System.out.println("--- Mapa de Figuras y Áreas ---");
        // Conversión implícita: la respuesta del método asociaFigurasConAreas es Map<Figura, Double>
        Map<Figura, Double> mapFigurasAreas = asociaFigurasConAreas(conjuntoFiguras);
        for (Map.Entry<Figura, Double> entrada : mapFigurasAreas.entrySet()) {
            // Conversión implícita: la clave del mapa es una Figura
            System.out.println(entrada.getKey() + " -> Área: " + entrada.getValue());
        }
    }
    
    /**
     * Método de clase (static) que asocia cada figura con su área
     * @param figuras: conjunto de figuras
     * @return: mapa que asocia figura con su área
     */
    public static Map<Figura, Double> asociaFigurasConAreas(Set<Figura> figuras) {
        // Creamos un LinkedHashMap para mantener el orden de inserción
        // Conversión implícita: LinkedHashMap es una subclase de Map
        Map<Figura, Double> mapaFigurasConAreas = new LinkedHashMap<>();
        
        // Recorremos el conjunto de figuras
        for (Figura figura : figuras) {
            // Conversión implícita: la clave es una Figura, el valor es un Double
            // El valor Double es conversión implícita de double primitivo a objeto Double (autoboxing)
            mapaFigurasConAreas.put(figura, figura.area());
        }
        
        return mapaFigurasConAreas;
    }
}