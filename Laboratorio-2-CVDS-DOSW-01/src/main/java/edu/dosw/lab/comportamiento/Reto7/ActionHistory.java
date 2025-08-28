package edu.dosw.lab.comportamiento.Reto7;

import java.util.ArrayList;
import java.util.List;

public class ActionHistory {
    private List<String> history = new ArrayList<>();

    public void add(String action) {
        history.add(action);
    }

    public void printHistory() {
        System.out.println("\n--- Historial completo ---");
        history.forEach(System.out::println);
    }

    public List<String> getHistory() {
        return history;
    }
}

