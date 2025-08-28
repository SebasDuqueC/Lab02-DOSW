package edu.dosw.lab.creacionales.Reto3;

import java.util.List;

public class Moto extends Vehiculo {
    public Moto(CategoriaVehiculo categoria, List<String> equipamiento) {
        super("Moto", categoria, TipoVehiculo.TIERRA,
            categoria == CategoriaVehiculo.LUJO ? 160 : categoria == CategoriaVehiculo.ECONOMICO ? 120 : 100,
            categoria == CategoriaVehiculo.LUJO ? 30000000 : categoria == CategoriaVehiculo.ECONOMICO ? 15000000 : 10000000,
            equipamiento);
    }

    @Override
    public String getDescripcion() {
        return "Tipo: Moto\n" +
               "Categoría: " + categoria + "\n" +
               "Velocidad máxima: " + velocidadMaxima + " km/h\n" +
               "Precio: $" + String.format("%,.0f", precio) + "\n" +
               "Equipamiento: " + String.join(" + ", equipamiento);
    }
}
