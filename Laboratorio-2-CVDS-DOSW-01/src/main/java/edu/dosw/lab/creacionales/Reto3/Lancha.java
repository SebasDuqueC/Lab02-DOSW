package edu.dosw.lab.creacionales.Reto3;

import java.util.List;

public class Lancha extends Vehiculo {
    public Lancha(CategoriaVehiculo categoria, List<String> equipamiento) {
        super("Lancha", categoria, TipoVehiculo.ACUATICO,
            categoria == CategoriaVehiculo.LUJO ? 90 : categoria == CategoriaVehiculo.ECONOMICO ? 70 : 60,
            categoria == CategoriaVehiculo.LUJO ? 80000000 : categoria == CategoriaVehiculo.ECONOMICO ? 50000000 : 30000000,
            equipamiento);
    }

    @Override
    public String getDescripcion() {
        return "Tipo: Lancha\n" +
               "Categoría: " + categoria + "\n" +
               "Velocidad máxima: " + velocidadMaxima + " km/h\n" +
               "Precio: $" + String.format("%,.0f", precio) + "\n" +
               "Equipamiento: " + String.join(" + ", equipamiento);
    }
}
