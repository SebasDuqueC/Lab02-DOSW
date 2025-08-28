package edu.dosw.lab.creacionales.Reto3;

public abstract class VehiculoFactory {
    public abstract VehiculoBuilder crearBuilder(String modelo, CategoriaVehiculo categoria);
}
