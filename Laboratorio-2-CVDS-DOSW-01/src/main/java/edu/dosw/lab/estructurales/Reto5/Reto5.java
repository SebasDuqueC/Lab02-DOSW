package edu.dosw.lab.estructurales.Reto5;

import java.util.*;

public class Reto5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, String> toppingsDisponibles = new HashMap<>();
        Map<String, Double> preciosToppings = new HashMap<>();

        toppingsDisponibles.put(1, "Leche");
        preciosToppings.put("Leche", 1000.0);

        toppingsDisponibles.put(2, "Chocolate");
        preciosToppings.put("Chocolate", 1500.0);

        toppingsDisponibles.put(3, "Caramelo");
        preciosToppings.put("Caramelo", 1200.0);

        toppingsDisponibles.put(4, "Crema Batida");
        preciosToppings.put("Crema Batida", 2000.0);

        toppingsDisponibles.put(5, "Menta");
        preciosToppings.put("Menta", 1300.0);

        toppingsDisponibles.put(6, "Agregar nuevo topping");

        System.out.print("Número de cafés a personalizar: ");
        int numCafes = sc.nextInt();
        sc.nextLine();

        List<Cafe> cafes = new ArrayList<>();

        for (int i = 1; i <= numCafes; i++) {
            System.out.println("\n--- Café " + i + " ---");
            System.out.println("Seleccione toppings (números separados por coma):");

            toppingsDisponibles.forEach((num, nombre) -> {
                if (nombre.equals("Agregar nuevo topping")) {
                    System.out.println(num + ". " + nombre);
                } else {
                    System.out.println(num + ". " + nombre + " - $" + preciosToppings.get(nombre).intValue());
                }
            });

            String seleccion = sc.nextLine();
            String[] opciones = seleccion.split(",");

            Cafe cafe = new CafeBase();

            for (String opcionStr : opciones) {
                int opcion = Integer.parseInt(opcionStr.trim());

                if (opcion == 6) {
                    System.out.print("Ingrese nombre del nuevo topping: ");
                    String nombreNuevo = sc.nextLine();
                    System.out.print("Ingrese precio del topping: ");
                    double precioNuevo = sc.nextDouble();
                    sc.nextLine();

                    preciosToppings.put(nombreNuevo, precioNuevo);
                    toppingsDisponibles.put(toppingsDisponibles.size() + 1, nombreNuevo);

                    cafe = new Topping(cafe, nombreNuevo, precioNuevo);
                } else {
                    String nombreTopping = toppingsDisponibles.get(opcion);
                    double precioTopping = preciosToppings.get(nombreTopping);
                    cafe = new Topping(cafe, nombreTopping, precioTopping);
                }
            }

            cafes.add(cafe);
        }

        System.out.println("\n--- RESUMEN DE CAFÉ PERSONALIZADO ---");

        for (int i = 0; i < cafes.size(); i++) {
            Cafe cafe = cafes.get(i);
            System.out.println("Café " + (i + 1) + ":");
            System.out.println("Ingredientes: " + cafe.getDescripcion());
            System.out.println("Precio total: $" + String.format("%,.0f", cafe.getPrecio()));
            System.out.println();
        }

        // Calcular total con Streams
        double totalGeneral = cafes.stream()
                .mapToDouble(Cafe::getPrecio)
                .sum();

        System.out.println("---------------------------");
        System.out.println("Total a pagar por todos los cafés: $" + String.format("%,.0f", totalGeneral));
        System.out.println("¡Disfrute su café!");
    }
}

