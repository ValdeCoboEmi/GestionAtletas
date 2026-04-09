import catalogo.Deporte;
import modelo.Boxeador;
import modelo.Entrenador;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner leer = new Scanner(System.in, "UTF-8");
    private static ArrayList<Boxeador> listaBoxeador = new ArrayList<>();
    private static ArrayList<Entrenador> listaEntrenadores = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN DE ATLETAS Y ENTRENADORES ---");
            System.out.println("1. Registrar nuevo Boxeador");
            System.out.println("2. Registrar nuevo Entrenador");
            System.out.println("3. Asignar Boxeador a un Entrenador");
            System.out.println("4. Ver lista simple de Boxeadores");
            System.out.println("5. Ver lista de Entrenadores (Planilla)");
            System.out.println("6. Ver reporte detallado de Boxeadores");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();
            leer.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarAtleta();
                    break;
                case 2:
                    registrarEntrenador();
                    break;
                case 3:
                    asignarAtletaAEntrenador();
                    break;
                case 4:
                    mostrarListaSimple();
                    break;
                case 5:
                    mostrarListaEntrenadores();
                    break;
                case 6:
                    mostrarReporteDetallado();
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
    }

    public static void registrarAtleta() {
        System.out.println("\n--- Nuevo Registro de Boxeador ---");
        System.out.print("Nombre completo: ");
        String nombre = leer.nextLine();
        System.out.print("Edad: ");
        int edad = leer.nextInt();
        leer.nextLine();
        System.out.print("Deporte (BOXEO): ");
        String deporteStr = leer.nextLine().toUpperCase();
        Deporte deporte = Deporte.valueOf(deporteStr);
        System.out.print("Peso (kg): ");
        float peso = leer.nextFloat();
        System.out.print("Altura (m): ");
        float altura = leer.nextFloat();

        System.out.print("Fuerza de golpe (Ej. 1000): ");
        int fuerza = leer.nextInt();
        System.out.print("Total de luchas en su carrera: ");
        int luchasTotales = leer.nextInt();
        System.out.print("Luchas ganadas: ");
        int luchasGanadas = leer.nextInt();
        leer.nextLine();

        Boxeador nuevo = new Boxeador(nombre, edad, deporte, altura, peso, fuerza, luchasTotales, luchasGanadas);

        System.out.println("Ingrese las horas de entrenamiento de la semana:");
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        for (int i = 0; i < 7; i++) {
            System.out.print(dias[i] + ": ");
            float h = leer.nextFloat();
            nuevo.registrarHorasDia(i, h);
        }

        nuevo.calcularIMC();
        listaBoxeador.add(nuevo);
        System.out.println("¡Boxeador registrado con éxito!");
    }

    // --- NUEVO: Registro de Entrenador ---
    public static void registrarEntrenador() {
        System.out.println("\n--- Nuevo Registro de Entrenador ---");
        System.out.print("Nombre completo: ");
        String nombre = leer.nextLine();
        System.out.print("Edad: ");
        int edad = leer.nextInt();
        leer.nextLine();
        System.out.print("Deporte que enseña (BOXEO): ");
        String deporteStr = leer.nextLine().toUpperCase();
        Deporte deporte = Deporte.valueOf(deporteStr);
        System.out.print("Peso (kg): ");
        float peso = leer.nextFloat();
        System.out.print("Altura (m): ");
        float altura = leer.nextFloat();
        System.out.print("Años de experiencia: ");
        int exp = leer.nextInt();
        leer.nextLine(); // Limpiar buffer

        Entrenador nuevoEntrenador = new Entrenador(nombre, edad, deporte, altura, peso, exp);
        listaEntrenadores.add(nuevoEntrenador);

        System.out.println("¡Entrenador registrado con éxito! Su salario inicial es de: $" + nuevoEntrenador.getSalario());
    }

    // --- NUEVO: Relacionar Objetos ---
    public static void asignarAtletaAEntrenador() {
        if (listaEntrenadores.isEmpty() || listaBoxeador.isEmpty()) {
            System.out.println("\n[!] Debes tener al menos un entrenador y un boxeador registrados.");
            return;
        }

        System.out.println("\n--- Asignar Boxeador a Entrenador ---");

        // 1. Mostrar y seleccionar Entrenador
        System.out.println("Seleccione el Entrenador:");
        for (int i = 0; i < listaEntrenadores.size(); i++) {
            System.out.println((i + 1) + ". " + listaEntrenadores.get(i).getNombre());
        }
        System.out.print("Opción: ");
        int indexEntrenador = leer.nextInt() - 1;

        // 2. Mostrar y seleccionar Boxeador
        System.out.println("\nSeleccione el Boxeador a asignar:");
        for (int i = 0; i < listaBoxeador.size(); i++) {
            System.out.println((i + 1) + ". " + listaBoxeador.get(i).getNombre());
        }
        System.out.print("Opción: ");
        int indexBoxeador = leer.nextInt() - 1;
        leer.nextLine(); // Limpiar buffer

        // 3. Hacer la vinculación
        Entrenador coach = listaEntrenadores.get(indexEntrenador);
        Boxeador boxer = listaBoxeador.get(indexBoxeador);

        coach.asignarAtleta(boxer);

        System.out.println("\n¡Asignación exitosa!");
        System.out.println(boxer.getNombre() + " ahora entrena bajo la tutela de " + coach.getNombre());
        System.out.println("El salario de " + coach.getNombre() + " se ha actualizado a $" + coach.getSalario());
    }

    // --- NUEVO: Mostrar Entrenadores ---
    public static void mostrarListaEntrenadores() {
        if (listaEntrenadores.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
            return;
        }
        System.out.println("\n--- Planilla de Entrenadores ---");
        for (Entrenador e : listaEntrenadores) {
            System.out.println("----------------------------------------");
            e.imprimir();
            e.entrenar(); // Demostración del método sobrescrito
        }
        System.out.println("----------------------------------------");
    }

    public static void mostrarListaSimple() {
        if (listaBoxeador.isEmpty()) {
            System.out.println("No hay boxeadores registrados.");
            return;
        }
        System.out.println("\n--- Lista de Boxeadores ---");
        for (Boxeador a : listaBoxeador) {
            System.out.printf("Nombre: %-15s | Categoría: %-15s | Promedio: %.2f hrs\n",
                    a.getNombre(), a.getCategoria(), a.calcularPromedioSemanal());
        }
    }

    public static void mostrarReporteDetallado() {
        if (listaBoxeador.isEmpty()) {
            System.out.println("No hay datos para mostrar.");
            return;
        }
        for (Boxeador a : listaBoxeador) {
            System.out.println("\n========================================");
            a.imprimir();
            a.clasificarIMC();
            a.imprimirResumenEntreno();
            System.out.println("----------------------------------------");
            a.mostrarEstadisticasBoxeo();
            System.out.println();
            a.entrenar();
            a.lanzarGolpeFirma();
            System.out.println("========================================");
        }
    }
}