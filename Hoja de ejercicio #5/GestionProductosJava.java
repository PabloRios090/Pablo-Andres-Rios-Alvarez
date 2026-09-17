

package com.mycompany.gestionproductos.java;
import java.util.ArrayList;

// Clase Producto
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

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + "', precio=" + precio + ", stock=" + stock + "}";
    }
}

// Clase Principal que ejecuta el programa
public class GestionProductosJava {

    public static void actualizarPrecioStockBajo(ArrayList<Producto> listaProductos, double porcentajeAumento) {
        for (Producto producto : listaProductos) {
            if (producto.getStock() < 10) {
                double precioActual = producto.getPrecio();
                double nuevoPrecio = precioActual * (1 + (porcentajeAumento / 100));
                producto.setPrecio(nuevoPrecio);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Producto> listaProductos = new ArrayList<>();

        listaProductos.add(new Producto(1, "Teclado", 150.00, 5));
        listaProductos.add(new Producto(2, "Mouse", 80.00, 15));
        listaProductos.add(new Producto(3, "Monitor", 1200.00, 8));

        System.out.println("--- Precios iniciales ---");
        for (Producto p : listaProductos) {
            System.out.println(p);
        }

        // Incrementa 10% a productos con stock menor a 10
        actualizarPrecioStockBajo(listaProductos, 10);

        System.out.println("\n--- Precios actualizados ---");
        for (Producto p : listaProductos) {
            System.out.println(p);
        }
    }
}