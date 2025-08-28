package edu.dosw.lab.creacionales.Reto3;

import java.util.ArrayList;
import java.util.List;

public class VehiculoBuilder {
    private String modelo;
    private CategoriaVehiculo categoria;
    private TipoVehiculo tipo;
    private List<String> equipamiento = new ArrayList<>();

    public VehiculoBuilder setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }
    public VehiculoBuilder setCategoria(CategoriaVehiculo categoria) {
        this.categoria = categoria;
        return this;
    }
    public VehiculoBuilder setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
        return this;
    }
    public VehiculoBuilder addEquipamiento(String eq) {
        equipamiento.add(eq);
        return this;
    }
    public Vehiculo build() {
        switch (modelo) {
            case "Auto": return new Auto(categoria, equipamiento);
            case "Avioneta": return new Avioneta(categoria, equipamiento);
            // Agrega aquí los demás modelos
            default: throw new IllegalArgumentException("Modelo no soportado");
        }
    }
}
