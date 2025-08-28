package edu.dosw.lab.estructurales.Reto5;

public class CafeBase implements Cafe {
    @Override
    public String getDescripcion() {
        return "Café base";
    }

    @Override
    public double getPrecio() {
        return 3000;
    }
}

