package edu.dosw.lab.comportamiento.Reto1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Reto1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a la tienda de Don Pepe");
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = sc.nextLine();

        System.out.print("¿El cliente es NUEVO o FRECUENTE? ");
        String tipoStr = sc.nextLine().trim().toUpperCase();
        TipoCliente tipo = tipoStr.equals("FRECUENTE") ? TipoCliente.FRECUENTE : TipoCliente.NUEVO;

        Cliente cliente = new Cliente(nombreCliente, tipo);

        Map<Integer, Producto> productosDisponibles = new HashMap<>();
        productosDisponibles.put(1, new Producto("Camiseta", 20000));
        productosDisponibles.put(2, new Producto("Pantalón", 50000));
        productosDisponibles.put(3, new Producto("Galletas", 500));
        productosDisponibles.put(4, new Producto("Jugo Natural", 3000));

        Carrito carrito = new Carrito(cliente);

        int opcion;
        do {
            System.out.println("\nProductos disponibles:");
            productosDisponibles.forEach((k, v) ->
                    System.out.println(k + ". " + v.getNombre() + " - $" + (int)v.getPrecioUnitario()));

            System.out.print("Ingrese el número del producto que desea o oprima '0' para finalizar): ");
            opcion = sc.nextInt();

            if (opcion != 0 && productosDisponibles.containsKey(opcion)) {
                System.out.print("Ingrese la cantidad: ");
                int cantidad = sc.nextInt();
                sc.nextLine();

                carrito.agregarProducto(productosDisponibles.get(opcion), cantidad);
            } else if (opcion != 0) {
                System.out.println("Opción inválida, intente de nuevo.");
            }

        } while (opcion != 0);

        carrito.generarRecibo();

        sc.close();
    }
}
