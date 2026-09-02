package com.mycompany.ejercicio10numerosaleatorios;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ejercicio10NumerosAleatorios {

    private static final int CANTIDAD_NUMEROS = 20;
    private static final int RANGO_MINIMO = 1;
    private static final int RANGO_MAXIMO = 100;

    private List<Integer> listaAleatorios;

    public Ejercicio10NumerosAleatorios() {
        this.listaAleatorios = new ArrayList<>();
    }

    public void generarNumeros() {
        Random random = new Random();

        for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
            
            int numeroAleatorio = random.nextInt(RANGO_MAXIMO - RANGO_MINIMO + 1) + RANGO_MINIMO;
            listaAleatorios.add(numeroAleatorio);
        }
    }

    public void mostrarNumeros() {
        System.out.println("--- LISTA DE " + CANTIDAD_NUMEROS + " NÚMEROS ALEATORIOS GENERADOS ---");
        System.out.println(listaAleatorios);

        System.out.println("\n--- Detalle elemento por elemento ---");
        for (int i = 0; i < listaAleatorios.size(); i++) {
            System.out.println("Posición [" + i + "]: " + listaAleatorios.get(i));
        }
    }

    public static void main(String[] args) {
        Ejercicio10NumerosAleatorios programa = new Ejercicio10NumerosAleatorios();
        programa.generarNumeros();
        programa.mostrarNumeros();
    }
}