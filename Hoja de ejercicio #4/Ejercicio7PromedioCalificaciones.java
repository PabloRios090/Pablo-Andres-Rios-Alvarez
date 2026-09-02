package com.mycompany.ejercicio7promediocalificaciones;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ejercicio7PromedioCalificaciones {

    private static final double CONDICION_SALIDA = -1.0;

    private List<Double> listaCalificaciones;
    private Scanner scanner;

    // Constructor
    public Ejercicio7PromedioCalificaciones() {
        this.listaCalificaciones = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void ingresarCalificaciones() {
        System.out.println("--- REGISTRO DE CALIFICACIONES ---");
        System.out.println("Ingresa notas (de 0 a 100). Escribe -1 para terminar el ingreso:");

        while (true) {
            System.out.print("Calificación: ");
            try {
                double nota = scanner.nextDouble();

                if (nota == CONDICION_SALIDA) {
                    break;
                }

                if (nota >= 0 && nota <= 100) {
                    listaCalificaciones.add(nota);
                } else {
                    System.out.println("Por favor ingresa una nota válida entre 0 y 100 (o -1 para salir).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número decimal o entero válido.");
                scanner.next(); // Limpiar el buffer
            }
        }
    }

    public double calcularPromedio() {
        if (listaCalificaciones.isEmpty()) {
            return 0.0;
        }

        double suma = 0.0;
        for (double nota : listaCalificaciones) {
            suma += nota;
        }

        return suma / listaCalificaciones.size();
    }

    public void mostrarResultados() {
        System.out.println("\n--- RESULTADOS ---");
        if (listaCalificaciones.isEmpty()) {
            System.out.println("No se ingresaron calificaciones.");
        } else {
            System.out.println("Notas ingresadas (" + listaCalificaciones.size() + "): " + listaCalificaciones);
            double promedio = calcularPromedio();
            System.out.printf("El promedio general es: %.2f\n", promedio);
        }
    }

    public static void main(String[] args) {
        Ejercicio7PromedioCalificaciones programa = new Ejercicio7PromedioCalificaciones();
        programa.ingresarCalificaciones();
        programa.mostrarResultados();
    }
}