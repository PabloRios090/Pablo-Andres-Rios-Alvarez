package com.mycompany.ejercicio2listanumeros;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2ListaNumeros {

    // Constante según convenciones (MAYÚSCULAS_CON_GUIONES_BAJO)
    private static final int CANTIDAD_MAXIMA = 10;

    // Atributo en lowerCamelCase
    private List<Integer> listaNumeros;

    // Constructor
    public Ejercicio2ListaNumeros() {
        this.listaNumeros = new ArrayList<>();
    }

    // Método en lowerCamelCase para ingresar los números
    public void ingresarNumeros() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingresa " + CANTIDAD_MAXIMA + " números enteros:");

        int contador = 1;
        while (contador <= CANTIDAD_MAXIMA) {
            System.out.print("Número " + contador + ": ");
            try {
                int numero = scanner.nextInt();
                listaNumeros.add(numero);
                contador++;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero válido.");
                scanner.next(); // Limpiar el buffer de entrada
            }
        }
    }

    // Método en lowerCamelCase para imprimir los números
    public void imprimirNumeros() {
        System.out.println("\n--- Lista de números ingresados ---");
        for (int i = 0; i < listaNumeros.size(); i++) {
            System.out.println("Posición [" + i + "]: " + listaNumeros.get(i));
        }
    }

    // Método principal de ejecución
    public static void main(String[] args) {
        Ejercicio2ListaNumeros programa = new Ejercicio2ListaNumeros();
        programa.ingresarNumeros();
        programa.imprimirNumeros();
    }
}