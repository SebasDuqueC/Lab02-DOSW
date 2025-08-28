package edu.dosw.lab.comportamiento.Reto1;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private final Cliente cliente;
    private final List<ItemCarrito> items;

    public Carrito(Cliente cliente) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        ItemCarrito item = new ItemCarrito(producto, cantidad);
        items.add(item);
        System.out.println(producto.getNombre() + " " + cantidad + " unidades agregado al carrito.");
    }

    public void generarRecibo() {
        System.out.println("\n---RECIBO DE COMPRA---");
        System.out.println("Cliente: " + cliente.getTipo());

        items.forEach(item ->
                System.out.println("- " + item.getProducto().getNombre() + " - $" + (int)item.getTotal())
        );

        double subtotal = items.stream()
                .mapToDouble(ItemCarrito::getTotal)
                .sum();

        // Calcular descuento
        double descuento = subtotal * cliente.getTipo().getDescuento();
        double total = subtotal - descuento;

        System.out.println("Subtotal: $" + (int)subtotal);
        System.out.println("Descuento aplicado: $" + (int)descuento);
        System.out.println("Total a pagar: $" + (int)total);
        System.out.println("---------------------------");
        System.out.println("Gracias por su compra!");
    }
}

