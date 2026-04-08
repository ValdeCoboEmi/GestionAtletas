package modelo;

import catalogo.Deporte;

public class Entrenador extends Atleta implements Pagable, Imprimible{
    private int experiencia;
    private double salario;
    private Atleta[] atleta;
    private static final double SALARIO_BASE = 2000.0; // Salario base constante

    //Constructor
    public Entrenador(){

    }

    public Entrenador(String nombre, int edad, Deporte deporte, float altura, float peso, int experiencia, double salario, Atleta[] atleta) {
        super(nombre, edad, deporte, altura, peso);
        this.experiencia = experiencia;
        this.salario = salario;
        this.atleta = atleta;
    }

    //GETTER Y SETTER
    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public double getSalario() {
        return salario;
    }

    public Atleta[] getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta[] atleta) {
        this.atleta = atleta;
    }

    @Override
    public void entrenar(){

    }

    @Override
    public void imprimir(){

    }

    @Override
    public void calcularSalario(){
        //Los años de exp > 3 incrementa en 5%
        //Salario base $2000 -- pasar a constante
        //Guardar en atributo salario
        if (this.experiencia > 3) {
            this.salario = SALARIO_BASE * 1.05; // Incremento del 5%
        } else {
            this.salario = SALARIO_BASE; // Salario base sin incremento
        }
    }
}
