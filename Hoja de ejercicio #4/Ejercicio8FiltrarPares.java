package com.mycompany.ejercicio8filtrarpares;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ejercicio8FiltrarPares {

    private static final int CONDICION_SALIDA = -999;

    private List<Integer> listaNumeros;
    private List<Integer> listaPares;
    private Scanner scanner;

    public Ejercicio8FiltrarPares() {
        this.listaNumeros = new ArrayList<>();
        this.listaPares = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void ingresarNumeros() {
        System.out.println("--- INGRESO DE NÚMEROS ENTEROS ---");
        System.out.println("Ingresa números a la lista. Escribe " + CONDICION_SALIDA + " para terminar:");

        while (true) {
            System.out.print("Número: ");
            try {
                int numero = scanner.nextInt();

                if (numero == CONDICION_SALIDA) {
                    break;
                }

                listaNumeros.add(numero);
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero válido.");
                scanner.next();
            }
        }
    }

    public void filtrarPares() {
        listaPares.clear();

        for (int numero : listaNumeros) {
           
            if (numero % 2 == 0) {
                listaPares.add(numero);
            }
        }
    }

    public void mostrarResultados() {
        System.out.println("\n--- RESULTADOS DEL FILTRADO ---");
        System.out.println("Lista completa ingresada (" + listaNumeros.size() + " elementos): " + listaNumeros);

        filtrarPares();

        if (listaPares.isEmpty()) {
            System.out.println("No se encontraron números pares en la lista.");
        } else {
            System.out.println("Lista de números pares filtrados (" + listaPares.size() + " elementos): " + listaPares);
        }
    }

    public static void main(String[] args) {
        Ejercicio8FiltrarPares programa = new Ejercicio8FiltrarPares();
        programa.ingresarNumeros();
        programa.mostrarResultados();
    }
}