package edu.dosw.lab.comportamiento.Reto7;

public class PlayMusicCommand implements Command {
    private String user;

    public PlayMusicCommand(String user) {
        this.user = user;
    }

    @Override
    public void execute() {
        System.out.println("Acción ejecutada por " + user + ": Música reproducida");
    }

    @Override
    public void undo() {
        System.out.println("Acción deshecha: Música detenida");
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Reproducir música - Usuario: " + user;
    }
}

