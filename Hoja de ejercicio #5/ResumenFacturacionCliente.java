
package com.mycompany.resumenfacturacioncliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Factura {
    private int idFactura;
    private String cliente;
    private double monto;

    public Factura(int idFactura, String cliente, double monto) {
        this.idFactura = idFactura;
        this.cliente = cliente;
        this.monto = monto;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public String getCliente() {
        return cliente;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Factura #" + idFactura + " | Cliente: " + cliente + " | Monto: Q" + String.format("%.2f", monto);
    }
}

public class ResumenFacturacionCliente {

    public static Map<String, Double> generarResumenFacturacion(ArrayList<Factura> facturas) {
        Map<String, Double> resumen = new HashMap<>();

        for (Factura f : facturas) {
            String cliente = f.getCliente();
            double monto = f.getMonto();

            resumen.put(cliente, resumen.getOrDefault(cliente, 0.0) + monto);
        }

        return resumen;
    }

    public static void main(String[] args) {
        ArrayList<Factura> listaFacturas = new ArrayList<>();

        listaFacturas.add(new Factura(1, "Carlos Gomez", 1500.00));
        listaFacturas.add(new Factura(2, "Ana Martinez", 850.50));
        listaFacturas.add(new Factura(3, "Carlos Gomez", 2200.00));
        listaFacturas.add(new Factura(4, "Luis Garcia", 450.00));
        listaFacturas.add(new Factura(5, "Ana Martinez", 1150.00));

        System.out.println("--- DETALLE DE FACTURAS REGISTRADAS ---");
        for (Factura f : listaFacturas) {
            System.out.println(f);
        }

        Map<String, Double> resumenClientes = generarResumenFacturacion(listaFacturas);

        System.out.println("\n--- RESUMEN TOTAL FACTURADO POR CLIENTE ---");
        for (Map.Entry<String, Double> entry : resumenClientes.entrySet()) {
            System.out.printf("Cliente: %-15s | Total Acumulado: Q%.2f\n", entry.getKey(), entry.getValue());
        }
    }
}