package edu.dosw.lab.creacionales.Reto3;

import java.util.List;

public class Helicoptero extends Vehiculo {
    public Helicoptero(CategoriaVehiculo categoria, List<String> equipamiento) {
        super("Helicóptero", categoria, TipoVehiculo.AEREO,
            categoria == CategoriaVehiculo.LUJO ? 350 : categoria == CategoriaVehiculo.ECONOMICO ? 250 : 200,
            categoria == CategoriaVehiculo.LUJO ? 400000000 : categoria == CategoriaVehiculo.ECONOMICO ? 250000000 : 150000000,
            equipamiento);
    }

    @Override
    public String getDescripcion() {
        return "Tipo: Helicóptero\n" +
               "Categoría: " + categoria + "\n" +
               "Velocidad máxima: " + velocidadMaxima + " km/h\n" +
               "Precio: $" + String.format("%,.0f", precio) + "\n" +
               "Equipamiento: " + String.join(" + ", equipamiento);
    }
}
