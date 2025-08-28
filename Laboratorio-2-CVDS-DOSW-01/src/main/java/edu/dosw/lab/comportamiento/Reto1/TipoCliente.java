package edu.dosw.lab.comportamiento.Reto1;

public enum TipoCliente {
    NUEVO(0.05),
    FRECUENTE(0.10);

    private final double descuento;

    TipoCliente(double descuento) {
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }
}


