package edu.dosw.lab.comportamiento.Reto6;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Número de tickets: ");
        int n = Integer.parseInt(scanner.nextLine());
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("\nTicket " + (i+1) + ":");
            System.out.print("Nivel (básico, intermedio, avanzado): ");
            String nivel = scanner.nextLine().trim().toLowerCase();
            System.out.print("Prioridad (baja, media, alta): ");
            String prioridad = scanner.nextLine().trim().toLowerCase();
            System.out.print("Descripción: ");
            String descripcion = scanner.nextLine();
            tickets.add(new Ticket(i+1, nivel, prioridad, descripcion));
        }

        // Crear técnicos y cadena
        Tecnico basico = new Tecnico("Básico", "básico", "baja") {};
        Tecnico intermedio = new Tecnico("Intermedio", "intermedio", "alta") {};
        Tecnico avanzado = new Tecnico("Avanzado", "avanzado", "media") {};
        basico.setSiguiente(intermedio);
        intermedio.setSiguiente(avanzado);

        // Procesar tickets
        List<String> resultados = new ArrayList<>();
        for (Ticket t : tickets) {
            String resultado = basico.procesar(t);
            resultados.add("Ticket " + t.getId() + ": " + resultado);
        }

        // Mostrar resultados
        resultados.forEach(System.out::println);

        // Estadísticas
        System.out.println("\n-- Estadísticas ---");
        // Tickets resueltos por nivel
        Map<String, Long> resueltosPorNivel = Arrays.stream(new String[]{"básico", "intermedio", "avanzado"})
            .collect(Collectors.toMap(
                nivel -> nivel,
                nivel -> tickets.stream()
                    .filter(t -> basico.procesar(t).contains("resolvió") && t.getNivel().equals(nivel))
                    .count()
            ));
        System.out.println("Tickets resueltos:");
        resueltosPorNivel.forEach((nivel, count) -> System.out.println(capitalize(nivel) + ": " + count));

        // Tickets pendientes
        long pendientes = tickets.stream()
            .filter(t -> basico.procesar(t).contains("escalamiento"))
            .count();
        System.out.println("\nTickets pendientes: " + pendientes);

        // Promedio de prioridad de tickets resueltos
        Map<String, Integer> prioridadMap = new HashMap<>();
        prioridadMap.put("baja", 1);
        prioridadMap.put("media", 2);
        prioridadMap.put("alta", 3);
        Double promedioPrioridad = tickets.stream()
            .filter(t -> basico.procesar(t).contains("resolvió"))
            .mapToInt(t -> prioridadMap.getOrDefault(t.getPrioridad(), 0))
            .average()
            .orElse(0.0);
        System.out.printf("\nPromedio de prioridad de tickets resueltos: %.1f\n", promedioPrioridad);
        scanner.close();
    }

    private static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }
}
