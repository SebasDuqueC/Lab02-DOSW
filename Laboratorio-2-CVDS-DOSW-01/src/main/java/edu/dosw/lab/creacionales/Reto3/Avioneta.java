package edu.dosw.lab.creacionales.Reto3;

import java.util.List;

public class Avioneta extends Vehiculo {
    public Avioneta(CategoriaVehiculo categoria, List<String> equipamiento) {
        super("Avioneta", categoria, TipoVehiculo.AEREO,
            categoria == CategoriaVehiculo.LUJO ? 300 : categoria == CategoriaVehiculo.ECONOMICO ? 250 : 200,
            categoria == CategoriaVehiculo.LUJO ? 250000000 : categoria == CategoriaVehiculo.ECONOMICO ? 150000000 : 100000000,
            equipamiento);
    }

    @Override
    public String getDescripcion() {
        return "Tipo: Avioneta\n" +
               "Categoría: " + categoria + "\n" +
               "Velocidad máxima: " + velocidadMaxima + " km/h\n" +
               "Precio: $" + String.format("%,.0f", precio) + "\n" +
               "Equipamiento: " + String.join(" + ", equipamiento);
    }
}
