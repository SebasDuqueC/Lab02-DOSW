package edu.dosw.lab.creacionales.Reto3;

import java.util.*;
import java.util.stream.Collectors;

public class Reto3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Vehiculo> vehiculos = new ArrayList<>();
        boolean agregarOtro = true;
        while (agregarOtro) {
            System.out.println("Bienvenido al Reino de los Vehículos!");
            System.out.println("Seleccione el tipo de vehículo:");
            System.out.println("1. Tierra\n2. Acuático\n3. Aéreo");
            int tipoOpcion = sc.nextInt(); sc.nextLine();
            TipoVehiculo tipo = tipoOpcion == 1 ? TipoVehiculo.TIERRA : tipoOpcion == 2 ? TipoVehiculo.ACUATICO : TipoVehiculo.AEREO;

            System.out.println("Seleccione la categoría del vehículo:");
            System.out.println("1. Económico\n2. Lujo\n3. Usado");
            int catOpcion = sc.nextInt(); sc.nextLine();
            CategoriaVehiculo categoria = catOpcion == 1 ? CategoriaVehiculo.ECONOMICO : catOpcion == 2 ? CategoriaVehiculo.LUJO : CategoriaVehiculo.USADO;

            String[] modelosTierra = {"Auto", "Bicicleta", "Moto"};
            String[] modelosAcuatico = {"Lancha", "Velero", "JetSki"};
            String[] modelosAereo = {"Avión", "Avioneta", "Helicóptero"};
            String[] modelos;
            VehiculoFactory factory;
            if (tipo == TipoVehiculo.TIERRA) {
                modelos = modelosTierra;
                factory = new TierraFactory();
            } else if (tipo == TipoVehiculo.ACUATICO) {
                modelos = modelosAcuatico;
                factory = new AcuaticoFactory();
            } else {
                modelos = modelosAereo;
                factory = new AereoFactory();
            }

            System.out.println("Seleccione el modelo de vehículo:");
            for (int i = 0; i < modelos.length; i++) {
                System.out.println((i+1) + ". " + modelos[i]);
            }
            int modeloOpcion = sc.nextInt(); sc.nextLine();
            String modelo = modelos[modeloOpcion-1];

            VehiculoBuilder builder = factory.crearBuilder(modelo, categoria);
            // Equipamiento ejemplo
            if (modelo.equals("Auto")) {
                if (categoria == CategoriaVehiculo.LUJO) {
                    builder.addEquipamiento("Aire acondicionado").addEquipamiento("GPS");
                } else if (categoria == CategoriaVehiculo.ECONOMICO) {
                    builder.addEquipamiento("Aire acondicionado básico");
                } else {
                    builder.addEquipamiento("Sin equipamiento especial");
                }
            } else if (modelo.equals("Bicicleta")) {
                builder.addEquipamiento("Timbre");
            } else if (modelo.equals("Moto")) {
                builder.addEquipamiento("Casco incluido");
            } else if (modelo.equals("Lancha")) {
                builder.addEquipamiento("Radio marino");
            } else if (modelo.equals("Velero")) {
                builder.addEquipamiento("Velas reforzadas");
            } else if (modelo.equals("JetSki")) {
                builder.addEquipamiento("Chaleco salvavidas");
            } else if (modelo.equals("Avión")) {
                builder.addEquipamiento("Piloto automático");
            } else if (modelo.equals("Avioneta")) {
                builder.addEquipamiento("Instrumentos básicos de vuelo");
            } else if (modelo.equals("Helicóptero")) {
                builder.addEquipamiento("GPS aéreo");
            }

            Vehiculo vehiculo = builder.build();
            vehiculos.add(vehiculo);

            System.out.print("¿Desea agregar otro vehículo? (si/no): ");
            String resp = sc.nextLine();
            agregarOtro = resp.trim().equalsIgnoreCase("si");
        }

        System.out.println("\n---- RESUMEN DE COMPRA ----");
        int idx = 1;
        for (Vehiculo v : vehiculos) {
            System.out.println("Vehículo " + idx++ + ":");
            System.out.println(v.getDescripcion());
            System.out.println();
        }
        double subtotal = vehiculos.stream().mapToDouble(Vehiculo::getPrecio).sum();
        double descuento = 0; // lógica de descuento si aplica
        double total = subtotal - descuento;
        System.out.println("Subtotal: $" + String.format("%,.0f", subtotal));
        System.out.println("Descuento aplicado: $" + String.format("%,.0f", descuento));
        System.out.println("Total a pagar: $" + String.format("%,.0f", total));
        System.out.println("__________________________");
        System.out.println("¡Gracias por su compra en el Reino de los Vehículos!");
    }
}
