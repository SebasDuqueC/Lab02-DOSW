package edu.dosw.lab.creacionales.Reto3;

public class AereoFactory extends VehiculoFactory {
    @Override
    public VehiculoBuilder crearBuilder(String modelo, CategoriaVehiculo categoria) {
        VehiculoBuilder builder = new VehiculoBuilder();
        builder.setModelo(modelo).setCategoria(categoria).setTipo(TipoVehiculo.AEREO);
        return builder;
    }
}
