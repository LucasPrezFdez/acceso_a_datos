package Ejercicio1;

public class Coche {

    private String marca;
    private String modelo;
    private int anio;
    private String color;
    private double kilometros;

    private static int numCoches = 0;

    public Coche(){
    numCoches++;
    };

    public Coche(String marca, String modelo, int anio, String color, double kilometros) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.kilometros = kilometros;
        numCoches++;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getKilometros() {
        return kilometros;
    }

    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
    }

    public static int getNumCoches() {
        return numCoches;
    }

    public static void setNumCoches(int numCoches) {
        Coche.numCoches = numCoches;
    }

    public double conducir(double km){
        this.kilometros += km;
        return km;
    }

    @Override
    public String toString() {
        return "Ejercicio1.Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", color='" + color + '\'' +
                ", kilometros=" + kilometros +
                '}';
    }
}
