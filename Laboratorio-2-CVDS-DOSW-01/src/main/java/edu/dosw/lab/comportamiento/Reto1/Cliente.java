package edu.dosw.lab.comportamiento.Reto1;

public class Cliente {
    private String nombre;
    private TipoCliente tipo;

    public Cliente(String nombre, TipoCliente tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoCliente getTipo() {
        return tipo;
    }
}


