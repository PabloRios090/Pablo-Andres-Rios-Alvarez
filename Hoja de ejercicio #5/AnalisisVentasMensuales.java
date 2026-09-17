

package com.mycompany.analisisventasmensuales;
import java.util.ArrayList;
import java.util.Collections;

public class AnalisisVentasMensuales {

    public static double calcularPromedioMensual(ArrayList<Double> ventas) {
        if (ventas.isEmpty()) return 0.0;
        
        double sumaTotal = 0;
        for (double venta : ventas) {
            sumaTotal += venta;
        }
        return sumaTotal / ventas.size();
    }

    public static double obtenerVentaMaxima(ArrayList<Double> ventas) {
        if (ventas.isEmpty()) return 0.0;
        return Collections.max(ventas);
    }

    public static double obtenerVentaMinima(ArrayList<Double> ventas) {
        if (ventas.isEmpty()) return 0.0;
        return Collections.min(ventas);
    }

    public static int contarDiasSobrePromedio(ArrayList<Double> ventas, double promedio) {
        int contadorDias = 0;
        for (double venta : ventas) {
            if (venta > promedio) {
                contadorDias++;
            }
        }
        return contadorDias;
    }

    public static void main(String[] args) {
        ArrayList<Double> ventasDiarias = new ArrayList<>();

        ventasDiarias.add(1250.00);
        ventasDiarias.add(1800.50);
        ventasDiarias.add(2100.00);
        ventasDiarias.add(950.25);
        ventasDiarias.add(3200.00);
        ventasDiarias.add(1500.75);
        ventasDiarias.add(2800.00);
        ventasDiarias.add(4100.50);
        ventasDiarias.add(1900.00);
        ventasDiarias.add(2300.00);

        double promedio = calcularPromedioMensual(ventasDiarias);
        double maxima = obtenerVentaMaxima(ventasDiarias);
        double minima = obtenerVentaMinima(ventasDiarias);
        int diasSobrePromedio = contarDiasSobrePromedio(ventasDiarias, promedio);

        System.out.println("--- REPORTE DE VENTAS MENSUALES ---");
        System.out.printf("Promedio mensual: Q%.2f\n", promedio);
        System.out.printf("Venta maxima: Q%.2f\n", maxima);
        System.out.printf("Venta minima: Q%.2f\n", minima);
        System.out.println("Dias con ventas superiores al promedio: " + diasSobrePromedio + " dias");
    }
}