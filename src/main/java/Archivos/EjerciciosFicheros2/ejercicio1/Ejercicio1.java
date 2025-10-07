package Archivos.EjerciciosFicheros2.ejercicio1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {

    public static void main(String[] args) throws IOException {

        int[] manolo = new int[5]; // manolo[0]=a, manolo[1]=e, manolo[2]=i, manolo[3]=o, manolo[4]=u

        File file = new File("C:\\Users\\DAM2\\IdeaProjects\\Trimestre1AccesoADatos\\src\\main\\java\\Archivos\\EjerciciosFicheros2\\ejercicio1\\texto.txt");
        try (FileReader fileReader = new FileReader(file)) {
            int car;
            while ((car = fileReader.read()) != -1) {
                char c = Character.toLowerCase((char)car);
                if (c == 'a') manolo[0]++;
                else if (c == 'e') manolo[1]++;
                else if (c == 'i') manolo[2]++;
                else if (c == 'o') manolo[3]++;
                else if (c == 'u') manolo[4]++;
            }
        }
        System.out.println("Vocales encontradas:");
        System.out.println("a: " + manolo[0]);
        System.out.println("e: " + manolo[1]);
        System.out.println("i: " + manolo[2]);
        System.out.println("o: " + manolo[3]);
        System.out.println("u: " + manolo[4]);
    }
}











