package edu.dosw.lab.creacionales.Reto3;

import java.util.List;

public class Velero extends Vehiculo {
    public Velero(CategoriaVehiculo categoria, List<String> equipamiento) {
        super("Velero", categoria, TipoVehiculo.ACUATICO,
            categoria == CategoriaVehiculo.LUJO ? 60 : categoria == CategoriaVehiculo.ECONOMICO ? 40 : 30,
            categoria == CategoriaVehiculo.LUJO ? 60000000 : categoria == CategoriaVehiculo.ECONOMICO ? 35000000 : 20000000,
            equipamiento);
    }

    @Override
    public String getDescripcion() {
        return "Tipo: Velero\n" +
               "Categoría: " + categoria + "\n" +
               "Velocidad máxima: " + velocidadMaxima + " km/h\n" +
               "Precio: $" + String.format("%,.0f", precio) + "\n" +
               "Equipamiento: " + String.join(" + ", equipamiento);
    }
}
