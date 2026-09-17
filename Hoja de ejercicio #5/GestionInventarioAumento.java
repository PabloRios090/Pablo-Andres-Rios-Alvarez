
package com.mycompany.gestioninventarioaumento;
import java.util.ArrayList;

class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + nombre + " | Precio: Q" + String.format("%.2f", precio) + " | Stock: " + stock;
    }
}

public class GestionInventarioAumento {

    public static void actualizarPreciosBajoStock(ArrayList<Producto> lista, double porcentajeAumento) {
        for (Producto p : lista) {
            
            if (p.getStock() < 10) {
                double nuevoPrecio = p.getPrecio() * (1 + (porcentajeAumento / 100));
                p.setPrecio(nuevoPrecio);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Producto(101, "Teclado Mecánico", 250.00, 15));
        productos.add(new Producto(102, "Mouse Inalámbrico", 120.00, 5));
        productos.add(new Producto(103, "Monitor 24 pulgadas", 1200.00, 8));
        productos.add(new Producto(104, "Auriculares Gamer", 350.00, 20));

        System.out.println("--- Inventario Antes del Aumento ---");
        for (Producto p : productos) {
            System.out.println(p);
        }

        double porcentaje = 10.0;
        actualizarPreciosBajoStock(productos, porcentaje);

        System.out.println("\n--- Inventario Después del Aumento (" + porcentaje + "%) ---");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }
}
