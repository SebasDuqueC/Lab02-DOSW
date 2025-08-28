package edu.dosw.lab.creacionales.Reto3;

import java.util.List;

public class Avion extends Vehiculo {
    public Avion(CategoriaVehiculo categoria, List<String> equipamiento) {
        super("Avión", categoria, TipoVehiculo.AEREO,
            categoria == CategoriaVehiculo.LUJO ? 900 : categoria == CategoriaVehiculo.ECONOMICO ? 700 : 500,
            categoria == CategoriaVehiculo.LUJO ? 800000000 : categoria == CategoriaVehiculo.ECONOMICO ? 600000000 : 400000000,
            equipamiento);
    }

    @Override
    public String getDescripcion() {
        return "Tipo: Avión\n" +
               "Categoría: " + categoria + "\n" +
               "Velocidad máxima: " + velocidadMaxima + " km/h\n" +
               "Precio: $" + String.format("%,.0f", precio) + "\n" +
               "Equipamiento: " + String.join(" + ", equipamiento);
    }
}
