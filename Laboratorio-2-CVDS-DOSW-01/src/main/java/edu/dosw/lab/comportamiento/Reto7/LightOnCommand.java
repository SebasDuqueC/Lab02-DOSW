package edu.dosw.lab.comportamiento.Reto7;

public class LightOnCommand implements Command {
    private String user;

    public LightOnCommand(String user) {
        this.user = user;
    }

    @Override
    public void execute() {
        System.out.println("Acción ejecutada por " + user + ": Luz encendida");
    }

    @Override
    public void undo() {
        System.out.println("Acción deshecha: Luz apagada");
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Encender luz - Usuario: " + user;
    }
}


