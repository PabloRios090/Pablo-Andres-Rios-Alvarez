package com.mycompany.ejercicio4eliminarelemento;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ejercicio4EliminarElemento {

    private static final int OPCION_AGREGAR = 1;
    private static final int OPCION_ELIMINAR = 2;
    private static final int OPCION_MOSTRAR = 3;
    private static final int OPCION_SALIR = 4;

    private List<String> listaElementos;
    private Scanner scanner;

    public Ejercicio4EliminarElemento() {
        this.listaElementos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Agregar elemento");
            System.out.println("2. Eliminar elemento por índice");
            System.out.println("3. Mostrar elementos");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case OPCION_AGREGAR:
                        agregarElemento();
                        break;
                    case OPCION_ELIMINAR:
                        eliminarElementoPorIndice();
                        break;
                    case OPCION_MOSTRAR:
                        mostrarElementos();
                        break;
                    case OPCION_SALIR:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero.");
                scanner.nextLine(); 
            }

        } while (opcion != OPCION_SALIR);
    }

    
    public void agregarElemento() {
        System.out.print("Ingresa el elemento a agregar: ");
        String elemento = scanner.nextLine().trim();

        if (!elemento.isEmpty()) {
            listaElementos.add(elemento);
            System.out.println("Elemento \"" + elemento + "\" agregado correctamente.");
        } else {
            System.out.println("No se puede agregar un elemento vacío.");
        }
    }

    public void eliminarElementoPorIndice() {
        if (listaElementos.isEmpty()) {
            System.out.println("La lista está vacía, no hay elementos para eliminar.");
            return;
        }

        mostrarElementos();
        System.out.print("Ingresa el índice del elemento que deseas eliminar: ");

        try {
            int indice = scanner.nextInt();
            scanner.nextLine(); 

            if (indice >= 0 && indice < listaElementos.size()) {
                String eliminado = listaElementos.remove(indice);
                System.out.println("Elemento \"" + eliminado + "\" en la posición [" + indice + "] eliminado correctamente.");
            } else {
                System.out.println("Error: El índice [" + indice + "] está fuera de rango (0 a " + (listaElementos.size() - 1) + ").");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresa un índice numérico válido.");
            scanner.nextLine(); 
        }
    }

    public void mostrarElementos() {
        System.out.println("\n--- Lista actual (" + listaElementos.size() + " elementos) ---");
        if (listaElementos.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            for (int i = 0; i < listaElementos.size(); i++) {
                System.out.println("Índice [" + i + "]: " + listaElementos.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Ejercicio4EliminarElemento programa = new Ejercicio4EliminarElemento();
        programa.mostrarMenu();
    }
}