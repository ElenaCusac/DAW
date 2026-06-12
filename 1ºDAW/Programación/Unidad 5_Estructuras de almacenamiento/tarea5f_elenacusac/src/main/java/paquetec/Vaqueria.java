package paquetec;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Vaqueria {

    // Estructura SET como atributo para que contenga un número de vacas indeterminado.
    Set<Vaca> vacas;

    // El constructor debe inicializar la estructura SET (no hay animales duplicados y el orden no importa).
    public Vaqueria() {
        this.vacas = new HashSet<>();
    }

    // 1. Saber el número de vacas que hay.
    public int cantidadVacas(){
        return vacas.size();
    }

    // 2. Añadir un animal a la vaquería.
    public void añadirVaca(Vaca vaca){
        vacas.add(vaca);
    }

    // 3. Saber si la vaquería tiene vacas.
    public boolean estaVacia(){
        return vacas.isEmpty();
    }

    // 4. Saber si un animal está en la vaquería.
    public boolean existeAnimal(Vaca vaca){
        return vacas.contains(vaca);
    }

    // 4. Sacar todos los animales en forma de ArrayList.
    public ArrayList<Vaca> mostrarVacas(){
        ArrayList<Vaca> lista = new ArrayList<>(vacas);
        return lista;
    }
    
    // 5. Dar de baja una vaca de la vaquería.
    public void eliminarVaca(Vaca vaca){
        vacas.remove(vaca);
    }
    
    @Override
    public String toString(){
        return "Vaqueria [Vacas: " + vacas.size() + "]";
    }

}

