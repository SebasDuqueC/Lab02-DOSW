package edu.dosw.lab.comportamiento.Reto7;

public interface Command {
    void execute();
    void undo();
    String getUser();
}


