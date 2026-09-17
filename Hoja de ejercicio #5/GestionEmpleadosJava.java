
package com.mycompany.gestionempleados.java;
import java.util.ArrayList;

// Clase Empleado con sus atributos, constructor, getters y toString
class Empleado {
    private String nombre;
    private String departamento;
    private double salario;

    public Empleado(String nombre, String departamento, double salario) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Empleado{nombre='" + nombre + "', departamento='" + departamento + "', salario=Q" + salario + "}";
    }
}

// Clase principal que contiene la lógica
public class GestionEmpleadosJava {

    // Método que filtra por departamento y salario mayor a Q5,000
    public static ArrayList<Empleado> filtrarEmpleados(ArrayList<Empleado> lista, String departamentoBuscado) {
        ArrayList<Empleado> filtrados = new ArrayList<>();

        for (Empleado emp : lista) {
            // Se usa equalsIgnoreCase para que no afecten mayúsculas/minúsculas
            if (emp.getDepartamento().equalsIgnoreCase(departamentoBuscado) && emp.getSalario() > 5000) {
                filtrados.add(emp);
            }
        }

        return filtrados;
    }

    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();

        // Datos de prueba
        empleados.add(new Empleado("Carlos Gómez", "Sistemas", 6500.00));
        empleados.add(new Empleado("Ana Martínez", "Sistemas", 4500.00));
        empleados.add(new Empleado("Luis Hernández", "Ventas", 7000.00));
        empleados.add(new Empleado("María Rodríguez", "Sistemas", 8000.00));
        empleados.add(new Empleado("Pedro López", "Contabilidad", 5200.00));

        String deptoFiltro = "Sistemas";

        System.out.println("--- Todos los empleados ---");
        for (Empleado e : empleados) {
            System.out.println(e);
        }

        // Llamada al método de filtrado
        ArrayList<Empleado> resultado = filtrarEmpleados(empleados, deptoFiltro);

        System.out.println("\n--- Empleados de '" + deptoFiltro + "' con salario mayor a Q5,000 ---");
        for (Empleado e : resultado) {
            System.out.println(e);
        }
    }
}