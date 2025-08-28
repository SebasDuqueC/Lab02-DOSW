package edu.dosw.lab.estructurales.Reto5;

public class Topping extends ToppingDecorator {
    private String nombre;
    private double precio;

    public Topping(Cafe cafe, String nombre, double precio) {
        super(cafe);
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + " + nombre;
    }

    @Override
    public double getPrecio() {
        return cafe.getPrecio() + precio;
    }
}

