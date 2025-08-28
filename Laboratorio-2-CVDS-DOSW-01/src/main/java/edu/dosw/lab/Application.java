package edu.dosw.lab;

import edu.dosw.lab.comportamiento.Reto1.Reto1;
import edu.dosw.lab.creacionales.Reto2.Reto2;
import edu.dosw.lab.creacionales.Reto3.Reto3;
import edu.dosw.lab.estructurales.Reto4.Reto4;
import edu.dosw.lab.estructurales.Reto5.Reto5;
import edu.dosw.lab.comportamiento.Reto6.Reto6;
import edu.dosw.lab.comportamiento.Reto7.Reto7;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		System.out.println("✅ Proyecto Spring Boot corriendo correctamente");
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("=== MENÚ DE RETOS ===");
			System.out.println("1. Ejecutar Reto 1");
			System.out.println("2. Ejecutar Reto 2");
			System.out.println("3. Ejecutar Reto 3");
			System.out.println("4. Ejecutar Reto 4");
			System.out.println("5. Ejecutar Reto 5");
			System.out.println("6. Ejecutar Reto 6");
			System.out.println("7, Ejecutar Reto 7");
			System.out.println("0. Salir");
			System.out.print("Seleccione una opción: ");

			int opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
				case 1:
					Reto1.main(new String[]{});
					break;
				case 2:
					Reto2.main(new String[]{});
					break;
				case 3:
					Reto3.main(new String[]{});
					break;
				case 4:
					Reto4.main(new String[]{});
					break;
				case 5:
					Reto5.main(new String[]{});
					break;
				case 6:
					Reto6.main(new String[]{});
					break;
				case 7:
					Reto7.main(new String[]{});
					break;
				case 0:
					System.out.println("Adi0ss!");
					return;
				default:
					System.out.println("Opción inválida. Intente de nuevo.");
			}
			System.out.println();
		}
	}
}