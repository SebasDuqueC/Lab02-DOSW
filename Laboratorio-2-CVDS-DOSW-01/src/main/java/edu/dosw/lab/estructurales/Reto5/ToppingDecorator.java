package edu.dosw.lab.estructurales.Reto5;

public abstract class ToppingDecorator implements Cafe {
    protected Cafe cafe;

    public ToppingDecorator(Cafe cafe) {
        this.cafe = cafe;
    }
}

