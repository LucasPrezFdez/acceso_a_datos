package Archivos.EjerciciosFicheros2.ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ContadorPalabras {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\DAM2\\IdeaProjects\\Trimestre1AccesoADatos\\src\\main\\java\\Archivos\\EjerciciosFicheros2\\ejercicio1\\texto.txt");
        int contadorPalabras = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.trim().split(" ");
                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        contadorPalabras++;
                    }
                }
            }
            System.out.println("Número total de palabras: " + contadorPalabras);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
