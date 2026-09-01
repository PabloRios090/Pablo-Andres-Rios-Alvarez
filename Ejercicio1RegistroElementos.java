
package com.mycompany.ejercicio1registroelementos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio1RegistroElementos {

    // Constante según convenciones (MAYÚSCULAS_CON_GUIONES_BAJO)
    private static final String CONDICION_SALIDA = "fin";

    // Atributo en lowerCamelCase
    private List<String> listaElementos;

    // Constructor
    public Ejercicio1RegistroElementos() {
        this.listaElementos = new ArrayList<>();
    }

    // Método en lowerCamelCase para registrar entradas
    public void registrarEntradas() {
        Scanner scanner = new Scanner(System.in);
        String entrada;

        System.out.println("Ingresa elementos (escribe \"" + CONDICION_SALIDA + "\" para terminar):");

        while (true) {
            System.out.print("> ");
            entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase(CONDICION_SALIDA)) {
                break;
            }

            if (!entrada.isEmpty()) {
                listaElementos.add(entrada);
            } else {
                System.out.println("El elemento no puede estar vacío.");
            }
        }
    }

    // Método en lowerCamelCase para mostrar los elementos ingresados
    public void mostrarElementos() {
        System.out.println("\n--- Elementos registrados (" + listaElementos.size() + ") ---");
        if (listaElementos.isEmpty()) {
            System.out.println("No se ingresó ningún elemento.");
        } else {
            for (int i = 0; i < listaElementos.size(); i++) {
                System.out.println((i + 1) + ". " + listaElementos.get(i));
            }
        }
    }

    // Método principal de ejecución
    public static void main(String[] args) {
        Ejercicio1RegistroElementos programa = new Ejercicio1RegistroElementos();
        programa.registrarEntradas();
        programa.mostrarElementos();
    }
}