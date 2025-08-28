package edu.dosw.lab.comportamiento.Reto7;

public class DoorOpenCommand implements Command {
    private String user;

    public DoorOpenCommand(String user) {
        this.user = user;
    }

    @Override
    public void execute() {
        System.out.println("Acción ejecutada por " + user + ": Puerta abierta");
    }

    @Override
    public void undo() {
        System.out.println("Acción deshecha: Puerta cerrada");
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Abrir puerta - Usuario: " + user;
    }
}

