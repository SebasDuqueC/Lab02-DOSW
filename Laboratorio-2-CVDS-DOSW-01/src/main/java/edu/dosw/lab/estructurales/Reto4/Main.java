
package edu.dosw.lab.estructurales.Reto4;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CasaDeCambio casa = new CasaDeCambio();
        System.out.print("Ingrese número de transacciones: ");
        int n = Integer.parseInt(scanner.nextLine());
        List<Transaccion> transacciones = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("\n---- Transacción " + (i+1) + " ----");
            System.out.print("Ingrese monto: ");
            double monto = Double.parseDouble(scanner.nextLine());
            System.out.print("Ingrese moneda de origen (USD, EUR, JPY, COP): ");
            String origen = scanner.nextLine().trim().toUpperCase();
            System.out.print("Ingrese monedas destino (separadas por coma, ej: USD,JPY): ");
            String[] destinos = scanner.nextLine().split(",");
            transacciones.add(new Transaccion(monto, origen, Arrays.stream(destinos).map(String::trim).collect(Collectors.toList())));
        }

        Map<String, Double> totales = new HashMap<>();
        for (int i = 0; i < transacciones.size(); i++) {
            Transaccion t = transacciones.get(i);
            System.out.printf("\nTransacción %d: %.0f %s\n", i+1, t.getMonto(), t.getOrigen());
            for (String destino : t.getDestinos()) {
                double convertido = casa.convertir(t.getMonto(), t.getOrigen(), destino);
                System.out.printf("Convertido a %s: %,.3f %s\n", destino, convertido, destino);
                totales.put(destino, totales.getOrDefault(destino, 0.0) + convertido);
            }
        }
        System.out.println("\n--- Totales por moneda ---");
        totales.forEach((moneda, total) -> System.out.printf("%s: %,.3f %s\n", moneda, total, moneda));
        scanner.close();
    }
}
