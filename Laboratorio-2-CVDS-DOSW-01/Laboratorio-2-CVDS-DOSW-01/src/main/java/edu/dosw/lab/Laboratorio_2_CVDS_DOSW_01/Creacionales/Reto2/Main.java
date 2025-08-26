
package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Creacionales.Reto2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Ingrediente> ingredientesMenu = Arrays.asList(
            new Ingrediente("Pan", 3000),
            new Ingrediente("Carne", 10000),
            new Ingrediente("Queso", 5000),
            new Ingrediente("Lechuga", 2000),
            new Ingrediente("Tomate", 2000),
            new Ingrediente("Salsa especial", 3000)
        );

        System.out.println("Seleccione ingredientes para su hamburguesa:");
        for (int i = 0; i < ingredientesMenu.size(); i++) {
            System.out.printf("%d. %s ($%,.0f)%n", i+1, ingredientesMenu.get(i).getNombre(), ingredientesMenu.get(i).getPrecio());
        }
        System.out.println("7. Agregar un nuevo ingrediente");
        System.out.println("Ingrese los números separados por coma: 1,2,3,7");

        String seleccion = scanner.nextLine();
        String[] seleccionNumeros = seleccion.split(",");
        List<Ingrediente> seleccionados = new ArrayList<>();

        for (String numStr : seleccionNumeros) {
            int num = Integer.parseInt(numStr.trim());
            if (num >= 1 && num <= ingredientesMenu.size()) {
                seleccionados.add(ingredientesMenu.get(num-1));
            } else if (num == 7) {
                System.out.print("Ingrese el nombre del nuevo ingrediente: ");
                String nombreNuevo = scanner.nextLine();
                System.out.print("Ingrese el precio del ingrediente: ");
                double precioNuevo = Double.parseDouble(scanner.nextLine().replace(",", "."));
                seleccionados.add(new Ingrediente(nombreNuevo, precioNuevo));
            }
        }

        // Mostrar resultado
    
        System.out.print("Ingredientes seleccionados: ");
        for (int i = 0; i < seleccionados.size(); i++) {
            System.out.print(seleccionados.get(i).getNombre());
            if (i < seleccionados.size()-1) System.out.print(", ");
        }
        double precioTotal = seleccionados.stream().mapToDouble(Ingrediente::getPrecio).sum();
        System.out.printf("%nPrecio total: $%,.0f%n", precioTotal);
        System.out.println("------------------------------");
        System.out.println("¡Disfrute su hamburguesa!");
    }
}

