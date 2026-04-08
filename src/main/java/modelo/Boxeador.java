package modelo;

public class Boxeador extends Atleta {

    private String categoria;
    private int fuerzaGolpe;
    private int luchasLuchadas;
    private int luchasGanadas;

    public Boxeador() {};

    // Constructor de  boxeador
    public Boxeador(String nombre, int edad, String deporte, float altura, float peso, int fuerzaGolpe, int luchasLuchadas, int luchasGanadas) {
        super(nombre, edad, deporte, altura, peso);
        this.fuerzaGolpe = fuerzaGolpe;
        this.luchasLuchadas = luchasLuchadas;
        this.luchasGanadas = luchasGanadas;
        this.categoria = asignarCategoria(peso);
    }

    // --- MÉTODOS DE LA CLASE BOXEADOR ---

    // Método para clasificar al boxeador según su peso (kg)
    private String asignarCategoria(float peso) {
        if (peso < 50.8f) return "Peso Mosca";
        else if (peso < 53.5f) return "Peso Gallo";
        else if (peso < 57.1f) return "Peso Pluma";
        else if (peso < 61.2f) return "Peso Ligero";
        else if (peso < 66.6f) return "Peso Wélter";
        else if (peso < 72.5f) return "Peso Mediano";
        else if (peso < 79.3f) return "Peso Mediopesado";
        else return "Peso Pesado";
    }

    // Método para calcular la efectividad del boxeador
    public float calcularEfectividad() {
        if (luchasLuchadas == 0) return 0f; // Evitar división por cero
        return ((float) luchasGanadas / luchasLuchadas) * 100;
    }

    // Método de acción
    public void lanzarGolpeFirma() {
        System.out.println("¡" + getNombre() + " lanza su golpe firma con una fuerza de " + fuerzaGolpe + " PSI!");
    }

    // Método para visualizar
    public void mostrarEstadisticasBoxeo() {
        System.out.println("--- PERFIL DE PUGILISTA ---");
        System.out.println("Categoría: " + categoria);
        System.out.println("Fuerza de Impacto: " + fuerzaGolpe + " PSI");
        System.out.println("Récord: " + luchasGanadas + " Victorias / " + (luchasLuchadas - luchasGanadas) + " Derrotas o Empates");
        System.out.printf("Efectividad de victorias: %.2f%%\n", calcularEfectividad());
    }

    @Override
    public void entrenar() {
        System.out.println("Iniciando entrenamiento...");
        System.out.println("En el campo de boxeo del Mágico González.");
    }

    // Getters y Setters
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getFuerzaGolpe() {
        return fuerzaGolpe;
    }

    public void setFuerzaGolpe(int fuerzaGolpe) {
        this.fuerzaGolpe = fuerzaGolpe;
    }

    public int getLuchasLuchadas() {
        return luchasLuchadas;
    }

    public void setLuchasLuchadas(int luchasLuchadas) {
        this.luchasLuchadas = luchasLuchadas;
    }

    public int getLuchasGanadas() {
        return luchasGanadas;
    }

    public void setLuchasGanadas(int luchasGanadas) {
        this.luchasGanadas = luchasGanadas;
    }
}