package com.mycompany.ejercicio5buscarnombre;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio5BuscarNombre {

    private static final String CONDICION_SALIDA = "fin";

    private List<String> listaNombres;
    private Scanner scanner;
    
    public Ejercicio5BuscarNombre() {
        this.listaNombres = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void ingresarNombres() {
        System.out.println("--- Carga de nombres ---");
        System.out.println("Ingresa nombres a la lista (escribe \"" + CONDICION_SALIDA + "\" para terminar de cargar):");

        while (true) {
            System.out.print("Nombre: ");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase(CONDICION_SALIDA)) {
                break;
            }

            if (!entrada.isEmpty()) {
                listaNombres.add(entrada);
            } else {
                System.out.println("El nombre no puede estar vacío.");
            }
        }
    }

    public void buscarNombre() {
        if (listaNombres.isEmpty()) {
            System.out.println("\nLa lista está vacía. No hay nombres para buscar.");
            return;
        }

        System.out.println("\n--- Búsqueda de nombres ---");
        System.out.print("Ingresa el nombre que deseas buscar: ");
        String nombreBuscado = scanner.nextLine().trim();

        if (listaNombres.contains(nombreBuscado)) {
            System.out.println("El nombre \"" + nombreBuscado + "\" SÍ existe en la lista.");
        } else {
            System.out.println("El nombre \"" + nombreBuscado + "\" NO se encuentra registrado.");
        }
    }

    public static void main(String[] args) {
        Ejercicio5BuscarNombre programa = new Ejercicio5BuscarNombre();
        programa.ingresarNombres();
        programa.buscarNombre();
    }
}