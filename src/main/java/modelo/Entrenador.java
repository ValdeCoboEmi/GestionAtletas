package modelo;

import catalogo.Deporte;
import java.util.ArrayList;

public class Entrenador extends Atleta implements Pagable, Imprimible {

    private int experiencia;
    private double salario;
    private ArrayList<Atleta> atletasACargo;
    private static final double SALARIO_BASE = 2000.0;

    public Entrenador() {
        this.atletasACargo = new ArrayList<>(); // Inicializamos la lista vacía
    }

    // Ya no pedimos el salario ni los atletas en el constructor inicial, eso se calcula y se asigna después
    public Entrenador(String nombre, int edad, Deporte deporte, float altura, float peso, int experiencia) {
        super(nombre, edad, deporte, altura, peso);
        this.experiencia = experiencia;
        this.atletasACargo = new ArrayList<>();
        calcularSalario(); // Lo calculamos al nacer el objeto
    }

    // --- MÉTODOS DE LA CLASE ---

    // Método para agregar un atleta bajo su tutela
    public void asignarAtleta(Atleta nuevoAtleta) {
        this.atletasACargo.add(nuevoAtleta);
        calcularSalario(); // Recalculamos el salario porque ahora tiene más carga de trabajo
    }

    @Override
    public void calcularSalario() {
        // Los años de exp > 3 incrementa en 5%
        if (this.experiencia > 3) {
            this.salario = SALARIO_BASE * 1.05;
        } else {
            this.salario = SALARIO_BASE;
        }

        // EXTRA: Bono de $50 por cada atleta a su cargo
        this.salario += (this.atletasACargo.size() * 50);
    }

    @Override
    public void entrenar() {
        System.out.println("El entrenador " + getNombre() + " está dirigiendo la rutina táctica de " + getDeporte() + ".");
    }

    @Override
    public void imprimir() {
        System.out.println("Nombre: " + getNombre() + " | Deporte: " + getDeporte());
        System.out.println("Experiencia: " + experiencia + " años");
        System.out.printf("Salario Actual: $%.2f\n", salario);
        System.out.println("Cantidad de atletas a cargo: " + atletasACargo.size());
    }

    // --- GETTERS Y SETTERS ---
    public int getExperiencia() { return experiencia; }
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
        calcularSalario(); // Si cambia su experiencia, su salario debe actualizarse
    }
    public double getSalario() { return salario; }
    public ArrayList<Atleta> getAtletasACargo() { return atletasACargo; }
}