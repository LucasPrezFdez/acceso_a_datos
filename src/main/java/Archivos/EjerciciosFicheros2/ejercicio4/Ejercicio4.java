package Archivos.EjerciciosFicheros2.ejercicio4;

import java.io.*;

public class Ejercicio4 {

    public static void main(String[] args) throws FileNotFoundException {

        try {

        File file = new File("C:\\Users\\DAM2\\IdeaProjects\\Trimestre1AccesoADatos\\src\\main\\java\\Archivos\\EjerciciosFicheros2\\ejercicio4\\texto.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String linea;
        int contador = 0;
        int contadorPalabras = 0;
        while ((linea = bufferedReader.readLine()) != null){
            char[] array = linea.toLowerCase().toCharArray();
            for (int i = 1; i<array.length; i++){
                if (array[i-1] != ' ' && array[i-1] != 'c' && array[i] == 'h'){
                    contador++;
                }
            }

            String[] palabras = linea.toLowerCase().split(" ");
            for (String palabra : palabras){
                if (!palabra.startsWith("h") && palabra.contains("h")){
                    contadorPalabras++;
                }
            }
        }

        System.out.println("Contador normal: "+contador);
        System.out.println("Contador palabras: "+contadorPalabras);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
