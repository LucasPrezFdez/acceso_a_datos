package Archivos.Serializable;

import java.io.Serializable;

public class Coches implements Serializable {

    private String matricula;
    private String marca;
    private String modelo;
    private int tamanoDeposito;
    private double precio;

    public Coches() {
    }

    public Coches(String matricula, String marca, String modelo, int tamanoDeposito, double precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.tamanoDeposito = tamanoDeposito;
        this.precio = precio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public int getTamanoDeposito() {
        return tamanoDeposito;
    }

    public void setTamanoDeposito(int tamanoDeposito) {
        this.tamanoDeposito = tamanoDeposito;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Coches{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tamanoDeposito=" + tamanoDeposito +
                ", precio=" + precio +
                '}';
    }
}
