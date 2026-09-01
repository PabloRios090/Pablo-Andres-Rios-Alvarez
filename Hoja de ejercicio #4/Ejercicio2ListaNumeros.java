package com.mycompany.ejercicio2listanumeros;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2ListaNumeros {

    private static final int CANTIDAD_MAXIMA = 10;

   
    private List<Integer> listaNumeros;

    
    public Ejercicio2ListaNumeros() {
        this.listaNumeros = new ArrayList<>();
    }

    
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
                scanner.next(); 
            }
        }
    }

    
    public void imprimirNumeros() {
        System.out.println("\n--- Lista de números ingresados ---");
        for (int i = 0; i < listaNumeros.size(); i++) {
            System.out.println("Posición [" + i + "]: " + listaNumeros.get(i));
        }
    }

    
    public static void main(String[] args) {
        Ejercicio2ListaNumeros programa = new Ejercicio2ListaNumeros();
        programa.ingresarNumeros();
        programa.imprimirNumeros();
    }
}