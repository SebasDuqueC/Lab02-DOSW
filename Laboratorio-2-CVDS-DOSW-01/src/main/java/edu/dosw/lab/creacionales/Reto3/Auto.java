package edu.dosw.lab.creacionales.Reto3;

import java.util.List;

public class Auto extends Vehiculo {
    public Auto(CategoriaVehiculo categoria, List<String> equipamiento) {
        super("Auto", categoria, TipoVehiculo.TIERRA,
            categoria == CategoriaVehiculo.LUJO ? 180 : categoria == CategoriaVehiculo.ECONOMICO ? 120 : 100,
            categoria == CategoriaVehiculo.LUJO ? 50000000 : categoria == CategoriaVehiculo.ECONOMICO ? 25000000 : 15000000,
            equipamiento);
    }

    @Override
    public String getDescripcion() {
        return "Tipo: Auto\n" +
               "Categoría: " + categoria + "\n" +
               "Velocidad máxima: " + velocidadMaxima + " km/h\n" +
               "Precio: $" + String.format("%,.0f", precio) + "\n" +
               "Equipamiento: " + String.join(" + ", equipamiento);
    }
}
