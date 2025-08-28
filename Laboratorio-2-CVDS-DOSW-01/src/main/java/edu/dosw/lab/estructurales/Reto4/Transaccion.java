package edu.dosw.lab.estructurales.Reto4;

import java.util.List;

public class Transaccion {
    private final double monto;
    private final String origen;
    private final List<String> destinos;

    public Transaccion(double monto, String origen, List<String> destinos) {
        this.monto = monto;
        this.origen = origen;
        this.destinos = destinos;
    }

    public double getMonto() {
        return monto;
    }

    public String getOrigen() {
        return origen;
    }

    public List<String> getDestinos() {
        return destinos;
    }
}
