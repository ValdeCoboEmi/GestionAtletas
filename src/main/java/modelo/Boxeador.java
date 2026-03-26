package modelo;

public class Boxeador extends Atleta{

    private String categoria;
    private int fuerzaGolpe;
    private int luchasLuchadas;
    private int luchasGanadas;

    public Boxeador(){};
    public Boxeador(String nombre, int edad, String deporte, float altura, float peso) {
        super(nombre, edad, deporte, altura, peso);
    }

    @Override
    public void entrenar() {
        System.out.println("Iniciando entrenamiento...");
        System.out.println("En el campo de boxeo del magico gonazales");
    }
}
