package EjercicioInterfaces;

import java.util.Random;

public class ArrayReales implements Estadisticas {
    private double[] datos;

    public ArrayReales(int tamaño) {
        datos = new double[tamaño];
    }

    public void asignar() {
        Random rand = new Random();
        for (int i = 0; i < datos.length; i++) {
            datos[i] = rand.nextDouble() * 100; // Números aleatorios entre 0 y 100
        }
    }

    @Override
    public double minimo() {
        double min = datos[0];
        for (double i : datos) {
            if (i < min) min = i;
        }
        return min;
    }

    @Override
    public double maximo() {
        double max = datos[0];
        for (double i : datos) {
            if (i > max) max = i;
        }
        return max;
    }

    @Override
    public double sumatorio() {
        double suma = 0;
        for (double i : datos) {
            suma += i;
        }
        return suma;
    }

    public void imprimir() {
        for (double d : datos) {
            System.out.printf("%.2f ", d);
        }
        System.out.println();
    }
}

