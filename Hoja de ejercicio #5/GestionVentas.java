
package com.mycompany.gestionventas;
import java.util.ArrayList;
import java.util.Collections;

public class GestionVentas {

    // 1. Método para calcular el promedio mensual
    public static double calcularPromedio(ArrayList<Double> ventas) {
        if (ventas.isEmpty()) return 0.0;
        
        double suma = 0;
        for (double venta : ventas) {
            suma += venta;
        }
        return suma / ventas.size();
    }

    // 2. Método para obtener la venta máxima
    public static double obtenerVentaMaxima(ArrayList<Double> ventas) {
        if (ventas.isEmpty()) return 0.0;
        return Collections.max(ventas);
    }

    // 3. Método para obtener la venta mínima
    public static double obtenerVentaMinima(ArrayList<Double> ventas) {
        if (ventas.isEmpty()) return 0.0;
        return Collections.min(ventas);
    }

    // 4. Método para contar cuántos días superaron el promedio
    public static int contarDiasSobrePromedio(ArrayList<Double> ventas, double promedio) {
        int contador = 0;
        for (double venta : ventas) {
            if (venta > promedio) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        ArrayList<Double> ventasMensuales = new ArrayList<>();

        // Datos de prueba para 10 días
        ventasMensuales.add(1500.50);
        ventasMensuales.add(2300.00);
        ventasMensuales.add(800.25);
        ventasMensuales.add(3100.00);
        ventasMensuales.add(1200.75);
        ventasMensuales.add(4500.00);
        ventasMensuales.add(2100.00);
        ventasMensuales.add(950.00);
        ventasMensuales.add(3800.50);
        ventasMensuales.add(2700.00);

        // Cálculos
        double promedio = calcularPromedio(ventasMensuales);
        double maximo = obtenerVentaMaxima(ventasMensuales);
        double minimo = obtenerVentaMinima(ventasMensuales);
        int diasSobrePromedio = contarDiasSobrePromedio(ventasMensuales, promedio);

        // Mostrar resultados
        System.out.println("--- Reporte de Ventas Mensuales ---");
        System.out.printf("Promedio mensual: Q%.2f\n", promedio);
        System.out.printf("Venta máxima: Q%.2f\n", maximo);
        System.out.printf("Venta mínima: Q%.2f\n", minimo);
        System.out.println("Días con ventas superiores al promedio: " + diasSobrePromedio + " días");
    }
}
