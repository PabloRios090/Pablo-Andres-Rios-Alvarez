package com.mycompany.ejercicio9promediosalarios;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Empleado {

    private String nombre;
    private double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado: " + nombre + " | Salario: Q" + String.format("%.2f", salario);
    }
}

public class Ejercicio9promediosalarios {

    private static final String CONDICION_SALIDA = "fin";
    private List<Empleado> listaEmpleados;
    private Scanner scanner;

    public Ejercicio9promediosalarios() {
        this.listaEmpleados = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void ingresarEmpleados() {
        System.out.println("--- REGISTRO DE EMPLEADOS ---");
        System.out.println("Ingresa los datos de los empleados (escribe \"" + CONDICION_SALIDA + "\" en el nombre para finalizar):");

        while (true) {
            System.out.print("\nNombre del empleado: ");
            String nombre = scanner.nextLine().trim();

            if (nombre.equalsIgnoreCase(CONDICION_SALIDA)) {
                break;
            }

            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
                continue;
            }

            double salario = 0.0;
            boolean salarioValido = false;

            while (!salarioValido) {
                System.out.print("Salario de " + nombre + ": ");
                try {
                    salario = scanner.nextDouble();
                    scanner.nextLine();

                    if (salario >= 0) {
                        salarioValido = true;
                    } else {
                        System.out.println("El salario debe ser un valor positivo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debes ingresar un monto numérico válido.");
                    scanner.nextLine();
                }
            }

            listaEmpleados.add(new Empleado(nombre, salario));
        }
    }

    public double calcularPromedioSalarios() {
        if (listaEmpleados.isEmpty()) {
            return 0.0;
        }

        double sumaSalarios = 0.0;
        for (Empleado emp : listaEmpleados) {
            sumaSalarios += emp.getSalario();
        }

        return sumaSalarios / listaEmpleados.size();
    }

    public void mostrarResultados() {
        System.out.println("\n--- LISTA DE EMPLEADOS REGISTRADOS ---");
        if (listaEmpleados.isEmpty()) {
            System.out.println("No se registraron empleados.");
        } else {
            for (Empleado emp : listaEmpleados) {
                System.out.println(emp);
            }

            double promedio = calcularPromedioSalarios();
            System.out.println("\n------------------------------------");
            System.out.printf("Promedio de salarios: Q%.2f\n", promedio);
        }
    }

    public static void main(String[] args) {
        Ejercicio9promediosalarios programa = new Ejercicio9promediosalarios();
        programa.ingresarEmpleados();
        programa.mostrarResultados();
    }
}