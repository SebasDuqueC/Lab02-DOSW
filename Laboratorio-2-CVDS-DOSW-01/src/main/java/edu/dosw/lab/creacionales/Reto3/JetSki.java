package edu.dosw.lab.creacionales.Reto3;

import java.util.List;

public class JetSki extends Vehiculo {
    public JetSki(CategoriaVehiculo categoria, List<String> equipamiento) {
        super("JetSki", categoria, TipoVehiculo.ACUATICO,
            categoria == CategoriaVehiculo.LUJO ? 110 : categoria == CategoriaVehiculo.ECONOMICO ? 80 : 60,
            categoria == CategoriaVehiculo.LUJO ? 90000000 : categoria == CategoriaVehiculo.ECONOMICO ? 60000000 : 40000000,
            equipamiento);
    }

    @Override
    public String getDescripcion() {
        return "Tipo: JetSki\n" +
               "Categoría: " + categoria + "\n" +
               "Velocidad máxima: " + velocidadMaxima + " km/h\n" +
               "Precio: $" + String.format("%,.0f", precio) + "\n" +
               "Equipamiento: " + String.join(" + ", equipamiento);
    }
}
