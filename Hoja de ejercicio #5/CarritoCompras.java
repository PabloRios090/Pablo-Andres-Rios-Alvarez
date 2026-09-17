
package com.mycompany.carritocompras;

import java.util.ArrayList;

class ItemCarrito {
    private String producto;
    private int cantidad;
    private double precioUnitario;

    public ItemCarrito(String producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getSubtotal() {
        return cantidad * precioUnitario;
    }

    @Override
    public String toString() {
        return "Producto: " + producto + " | Cantidad: " + cantidad + " | Precio Unitario: Q" + String.format("%.2f", precioUnitario) + " | Subtotal: Q" + String.format("%.2f", getSubtotal());
    }
}

public class CarritoCompras {
    private ArrayList<ItemCarrito> items;

    public CarritoCompras() {
        this.items = new ArrayList<>();
    }

    public void agregarItem(String producto, int cantidad, double precioUnitario) {
        for (ItemCarrito item : items) {
            if (item.getProducto().equalsIgnoreCase(producto)) {
                item.setCantidad(item.getCantidad() + cantidad);
                System.out.println("-> Cantidad actualizada para '" + producto + "': +" + cantidad);
                return;
            }
        }
        items.add(new ItemCarrito(producto, cantidad, precioUnitario));
        System.out.println("-> Producto agregado: " + producto);
    }

    public void eliminarItem(String producto) {
        boolean eliminado = items.removeIf(item -> item.getProducto().equalsIgnoreCase(producto));
        if (eliminado) {
            System.out.println("-> Producto eliminado: " + producto);
        } else {
            System.out.println("-> El producto '" + producto + "' no existe en el carrito.");
        }
    }

    public void vaciarCarrito() {
        items.clear();
        System.out.println("-> Carrito vaciado completamente.");
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemCarrito item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void mostrarContenido() {
        System.out.println("\n--- DETALLE DEL CARRITO ---");
        if (items.isEmpty()) {
            System.out.println("El carrito esta vacio.");
        } else {
            for (ItemCarrito item : items) {
                System.out.println(item);
            }
            System.out.printf("TOTAL A PAGAR: Q%.2f\n", calcularTotal());
        }
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        CarritoCompras carrito = new CarritoCompras();

        carrito.agregarItem("Camisa", 2, 150.00);
        carrito.agregarItem("Pantalon", 1, 250.00);

        carrito.agregarItem("Camisa", 1, 150.00);

        carrito.mostrarContenido();

        carrito.eliminarItem("Pantalon");
        carrito.mostrarContenido();

        carrito.vaciarCarrito();
        carrito.mostrarContenido();
    }
}