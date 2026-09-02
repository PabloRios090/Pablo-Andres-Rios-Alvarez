package com.mycompany.ejercicio6controltareas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ejercicio6ControlTareas {

    private static final int OPCION_AGREGAR = 1;
    private static final int OPCION_COMPLETAR = 2;
    private static final int OPCION_MOSTRAR = 3;
    private static final int OPCION_SALIR = 4;

    private List<String> tareasPendientes;
    private Scanner scanner;

    public Ejercicio6ControlTareas() {
        this.tareasPendientes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void ejecutarMenu() {
        int opcion = 0;

        do {
            System.out.println("\n--- CONTROL DE TAREAS PENDIENTES ---");
            System.out.println("1. Agregar nueva tarea");
            System.out.println("2. Marcar tarea como completada (Eliminar)");
            System.out.println("3. Ver tareas pendientes");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case OPCION_AGREGAR:
                        agregarTarea();
                        break;
                    case OPCION_COMPLETAR:
                        marcarComoCompletada();
                        break;
                    case OPCION_MOSTRAR:
                        mostrarTareas();
                        break;
                    case OPCION_SALIR:
                        System.out.println("Saliendo del gestor de tareas...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero.");
                scanner.nextLine(); // Limpiar buffer
            }

        } while (opcion != OPCION_SALIR);
    }

    public void agregarTarea() {
        System.out.print("Descripción de la nueva tarea: ");
        String tarea = scanner.nextLine().trim();

        if (!tarea.isEmpty()) {
            tareasPendientes.add(tarea);
            System.out.println("Tarea \"" + tarea + "\" registrada exitosamente.");
        } else {
            System.out.println("No se puede registrar una tarea vacía.");
        }
    }

    public void marcarComoCompletada() {
        if (tareasPendientes.isEmpty()) {
            System.out.println("No hay tareas pendientes por completar.");
            return;
        }

        mostrarTareas();
        System.out.print("Ingresa el número del índice de la tarea completada: ");

        try {
            int indice = scanner.nextInt();
            scanner.nextLine(); 

            if (indice >= 0 && indice < tareasPendientes.size()) {
                String tareaCompletada = tareasPendientes.remove(indice);
                System.out.println("✓ ¡Excelente! Tarea \"" + tareaCompletada + "\" completada y eliminada de la lista.");
            } else {
                System.out.println("Error: Índice no válido (debe estar entre 0 y " + (tareasPendientes.size() - 1) + ").");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresa un número de índice válido.");
            scanner.nextLine(); 
        }
    }

    public void mostrarTareas() {
        System.out.println("\n--- Lista de Tareas Pendientes (" + tareasPendientes.size() + ") ---");
        if (tareasPendientes.isEmpty()) {
            System.out.println("¡Felicidades! No tienes tareas pendientes.");
        } else {
            for (int i = 0; i < tareasPendientes.size(); i++) {
                System.out.println("Índice [" + i + "]: " + tareasPendientes.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Ejercicio6ControlTareas programa = new Ejercicio6ControlTareas();
        programa.ejecutarMenu();
    }
}