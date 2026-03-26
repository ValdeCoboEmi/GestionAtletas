import modelo.Boxeador;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner leer = new Scanner(System.in, "UTF-8");
    private static ArrayList<Boxeador> listaBoxeador = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN DE ATLETAS ---");
            System.out.println("1. Registrar nuevo atleta (con todos los datos)");
            System.out.println("2. Ver lista de atletas y sus promedios");
            System.out.println("3. Ver reporte detallado (IMC + Rendimiento)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    registrarAtleta();
                    break;
                case 2:
                    mostrarListaSimple();
                    break;
                case 3:
                    mostrarReporteDetallado();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    // Método para capturar todos los datos de la clase Atleta
    public static void registrarAtleta() {
        System.out.println("\n--- Nuevo Registro ---");
        System.out.print("Nombre completo: ");
        String nombre = leer.nextLine();
        System.out.print("Edad: ");
        int edad = leer.nextInt();
        leer.nextLine();
        System.out.print("Deporte: ");
        String deporte = leer.nextLine();
        System.out.print("Peso (kg): ");
        float peso = leer.nextFloat();
        System.out.print("Altura (m): ");
        float altura = leer.nextFloat();

        // Creamos el objeto con el constructor
        Boxeador nuevo = new Boxeador(nombre, edad, deporte, altura, peso);



        // Para llenar las horas de entreno
        System.out.println("Ingrese las horas de entrenamiento de la semana:");
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        for (int i = 0; i < 7; i++) {
            System.out.print(dias[i] + ": ");
            float h = leer.nextFloat();
            nuevo.registrarHorasDia(i, h);
        }

        // Calculamos el IMC
        nuevo.calcularIMC();

        // Guardamos en la lista
        listaBoxeador.add(nuevo);
        System.out.println("¡Atleta registrado con éxito!");
    }

    public static void mostrarListaSimple() {
        if (listaBoxeador.isEmpty()) {
            System.out.println("No hay atletas registrados.");
            return;
        }
        System.out.println("\n--- Lista de Atletas ---");
        for (Boxeador a : listaBoxeador) {
            System.out.printf("Nombre: %-15s | Deporte: %-10s | Promedio: %.2f hrs\n",
                    a.getNombre(), a.getDeporte(), a.calcularPromedioSemanal());
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
            System.out.println("========================================");
        }
    }
}