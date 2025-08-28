package edu.dosw.lab.creacionales.Reto3;

import java.util.List;

public abstract class Vehiculo {
    protected String modelo;
    protected CategoriaVehiculo categoria;
    protected TipoVehiculo tipo;
    protected int velocidadMaxima;
    protected double precio;
    protected List<String> equipamiento;

    public Vehiculo(String modelo, CategoriaVehiculo categoria, TipoVehiculo tipo, int velocidadMaxima, double precio, List<String> equipamiento) {
        this.modelo = modelo;
        this.categoria = categoria;
        this.tipo = tipo;
        this.velocidadMaxima = velocidadMaxima;
        this.precio = precio;
        this.equipamiento = equipamiento;
    }

    public String getModelo() { return modelo; }
    public CategoriaVehiculo getCategoria() { return categoria; }
    public TipoVehiculo getTipo() { return tipo; }
    public int getVelocidadMaxima() { return velocidadMaxima; }
    public double getPrecio() { return precio; }
    public List<String> getEquipamiento() { return equipamiento; }

    public abstract String getDescripcion();
}
