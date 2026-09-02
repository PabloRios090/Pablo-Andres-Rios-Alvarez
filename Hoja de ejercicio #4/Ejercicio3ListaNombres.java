package com.mycompany.ejercicio3listanombres;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio3ListaNombres {

    private static final String CONDICION_SALIDA = "fin";

    private List<String> listaNombres;

    
    public Ejercicio3ListaNombres() {
        this.listaNombres = new ArrayList<>();
    }

    public void ingresarNombres() {
        Scanner scanner = new Scanner(System.in);
        String nombre;

        System.out.println("Ingresa nombres a la lista (escribe \"" + CONDICION_SALIDA + "\" para finalizar):");

        while (true) {
            System.out.print("Nombre: ");
            nombre = scanner.nextLine().trim();

            if (nombre.equalsIgnoreCase(CONDICION_SALIDA)) {
                break;
            }

            if (!nombre.isEmpty()) {
                listaNombres.add(nombre);
            } else {
                System.out.println("El nombre no puede estar vacío.");
            }
        }
    }

    public void recorrerLista() {
        System.out.println("\n--- Recorriendo la lista de nombres (" + listaNombres.size() + " en total) ---");
        if (listaNombres.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
          
            int indice = 1;
            for (String nombre : listaNombres) {
                System.out.println(indice + ". " + nombre);
                indice++;
            }
        }
    }

   
    public static void main(String[] args) {
        Ejercicio3ListaNombres programa = new Ejercicio3ListaNombres();
        programa.ingresarNombres();
        programa.recorrerLista();
    }
}