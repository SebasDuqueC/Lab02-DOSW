package edu.dosw.lab.comportamiento.Reto7;

public class AdjustVolumeCommand implements Command {
    private String user;
    private int value;

    public AdjustVolumeCommand(String user, int value) {
        this.user = user;
        this.value = value;
    }

    @Override
    public void execute() {
        System.out.println("Acción ejecutada por " + user + ": Volumen ajustado a " + value + "%");
    }

    @Override
    public void undo() {
        System.out.println("Acción deshecha: Volumen regresado a 0%");
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Ajustar volumen a " + value + "% - Usuario: " + user;
    }
}

