package edu.dosw.lab.comportamiento.Reto7;

import java.util.Scanner;

import java.util.*;

public class Reto7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ActionHistory history = new ActionHistory();

        System.out.print("Número de acciones a registrar: ");
        int numAcciones = sc.nextInt();
        sc.nextLine();

        Map<String, Integer> contadorUsuarios = new HashMap<>();

        for (int i = 1; i <= numAcciones; i++) {
            System.out.println("\nAcción " + i + ":");
            System.out.print("Usuario: ");
            String usuario = sc.nextLine();

            System.out.println("Seleccione: 1. Encender luz  2. Abrir puerta  3. Reproducir música  4. Ajustar volumen");
            int opcion = sc.nextInt();
            sc.nextLine();

            Command comando = null;

            if (opcion == 1) comando = new LightOnCommand(usuario);
            else if (opcion == 2) comando = new DoorOpenCommand(usuario);
            else if (opcion == 3) comando = new PlayMusicCommand(usuario);
            else if (opcion == 4) {
                System.out.print("Ingrese valor (0–100): ");
                int valor = sc.nextInt();
                sc.nextLine();
                comando = new AdjustVolumeCommand(usuario, valor);
            }

            comando.execute();
            contadorUsuarios.put(usuario, contadorUsuarios.getOrDefault(usuario, 0) + 1);

            System.out.print("Deshacer acción? (si/no): ");
            String undo = sc.nextLine();

            if (undo.equalsIgnoreCase("si")) {
                comando.undo();
                history.add(comando.toString() + " (deshecha)");
            } else {
                history.add(comando.toString());
            }
        }

        history.printHistory();

        System.out.println("\n--- Investigando quién desconfiguró los electrodomésticos ---");
        contadorUsuarios.forEach((u, c) -> System.out.println(u + " realizó " + c + " acción(es)."));
    }
}


