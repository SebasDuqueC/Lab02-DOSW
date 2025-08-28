package edu.dosw.lab.creacionales.Reto3;

import java.util.List;

public class Bicicleta extends Vehiculo {
    public Bicicleta(CategoriaVehiculo categoria, List<String> equipamiento) {
        super("Bicicleta", categoria, TipoVehiculo.TIERRA,
            categoria == CategoriaVehiculo.LUJO ? 40 : categoria == CategoriaVehiculo.ECONOMICO ? 30 : 25,
            categoria == CategoriaVehiculo.LUJO ? 2000000 : categoria == CategoriaVehiculo.ECONOMICO ? 1000000 : 500000,
            equipamiento);
    }

    @Override
    public String getDescripcion() {
        return "Tipo: Bicicleta\n" +
               "Categoría: " + categoria + "\n" +
               "Velocidad máxima: " + velocidadMaxima + " km/h\n" +
               "Precio: $" + String.format("%,.0f", precio) + "\n" +
               "Equipamiento: " + String.join(" + ", equipamiento);
    }
}
