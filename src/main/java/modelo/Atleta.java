package modelo;

import java.util.Arrays;

public abstract class Atleta implements Imprimible{
    private String nombre;
    private int edad;
    private String deporte;
    private float peso;
    private float altura;
    private float imc;
    private float horasDeEntrenoSemanal;
    private float[] horasEntrenoSemana;

    // Constructor vacío
    public Atleta() {
        horasEntrenoSemana = new float[7];
    }

    // Constructor con parámetros
    public Atleta(String nombre, int edad, String deporte, float altura, float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.deporte = deporte;
        this.altura = altura;
        this.peso = peso;
        horasEntrenoSemana = new float[7];
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public float getHorasDeEntrenoSemanal() {
        return horasDeEntrenoSemanal;
    }

    public float[] getHorasEntrenoSemana() {
        return horasEntrenoSemana;
    }

    public void setHorasEntrenoSemana(float[] horasEntrenoSemana) {
        this.horasEntrenoSemana = horasEntrenoSemana;
    }

    public void setHorasDeEntrenoSemanal(float horas) {
        this.horasDeEntrenoSemanal = horas;
    }

    public void setHorasDia(int dia, float horas) {
        this.horasEntrenoSemana[dia] = horas;
    }

    // Métodos de Lógica

    public float calcularIMC() {
        if (altura > 0) {
            // La fórmula correcta es peso / (altura * altura)
            this.imc = this.peso / (this.altura * this.altura);
        } else {
            this.imc = 0;
        }
        return imc;
    }

    // Metodo para establecer las horas de un día específico (0 a 6)
    public void registrarHorasDia(int dia, float horas) {
        if (dia >= 0 && dia < 7) {
            this.horasEntrenoSemana[dia] = horas;
        } else {
            System.out.println("Día inválido. Debe ser entre 0 y 6.");
        }
    }

    // Metodo que calcula la suma total y el promedio
    public double calcularPromedioSemanal() {
        float sumaTotal = 0;
        for (float hora : horasEntrenoSemana) {
            sumaTotal += hora;
        }
        return Math.round((sumaTotal / 7) * 100) / 100.0;
    }

    public float calcularPromedioDiario() {
        return this.horasDeEntrenoSemanal / 7;
    }

    public void imprimirResumenEntreno() {
        System.out.println("Historial de la semana: " + Arrays.toString(horasEntrenoSemana));
        System.out.printf("Promedio diario de entreno: %.2f horas\n", calcularPromedioSemanal());
    }

    public void clasificarIMC() {
        calcularIMC(); // Nos aseguramos de calcularlo antes de evaluar
        System.out.print("Clasificación IMC: ");
        if (imc <= 0) System.out.println("Datos inválidos");
        else if (imc < 18.5) System.out.println("Bajo peso");
        else if (imc < 25) System.out.println("Peso normal");
        else if (imc < 30) System.out.println("Sobrepeso");
        else System.out.println("Obesidad");
    }

    public void clasificarRendimiento() {
        float promedio = calcularPromedioDiario();
        System.out.print("Rendimiento: ");
        if (promedio < 1) System.out.println("Poco entrenamiento diario");
        else if (promedio < 3) System.out.println("Entrenamiento regular");
        else System.out.println("Alto rendimiento");
    }

    //VISUALIZACION DE POLIFORMISMO DE UNA INTERFACE
    @Override
    public void imprimir() {
        System.out.println("Nombre del atleta: " + this.nombre);
        System.out.println("Peso del atleta: " + this.peso);
        System.out.println("Altura del atleta: " + this.altura);
        System.out.println("Edad del atleta: " + this.edad);
        System.out.println("Deporte del atleta: " + this.deporte);
        System.out.println("Imc del atleta: " + this.imc);

    }

    //NO LLEVA LLAVES PORQUE NO LLEVA UN IMPLEMENTO/CUERPO
    public abstract void entrenar();
}