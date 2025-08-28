package edu.dosw.lab.creacionales.Reto2;

import java.util.ArrayList;
import java.util.List;

public class HamburguesaBuilder {
    private final List<Ingrediente> ingredientes = new ArrayList<>();

    public HamburguesaBuilder agregarPan() {
        ingredientes.add(new Ingrediente("Pan", 1.0));
        return this;
    }

    public HamburguesaBuilder agregarCarne() {
        ingredientes.add(new Ingrediente("Carne", 3.0));
        return this;
    }

    public HamburguesaBuilder agregarQueso() {
        ingredientes.add(new Ingrediente("Queso", 1.5));
        return this;
    }

    public HamburguesaBuilder agregarVegetales() {
        ingredientes.add(new Ingrediente("Vegetales", 1.0));
        return this;
    }

    public HamburguesaBuilder agregarSalsas() {
        ingredientes.add(new Ingrediente("Salsas", 0.5));
        return this;
    }

    public Hamburguesa build() {
        return new Hamburguesa(new ArrayList<>(ingredientes));
    }
}
