package edu.dosw.lab.creacionales.Reto2;

import java.util.List;

public class Hamburguesa {
    private final List<Ingrediente> ingredientes;

    public Hamburguesa(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void mostrarHamburguesa() {
        System.out.println("🍔 Hamburguesa con:");
        ingredientes.forEach(i -> System.out.println("- " + i));

        double precioTotal = ingredientes.stream()
                                         .mapToDouble(Ingrediente::getPrecio)
                                         .sum();
        System.out.println("💲 Precio total: $" + precioTotal);
    }
}
