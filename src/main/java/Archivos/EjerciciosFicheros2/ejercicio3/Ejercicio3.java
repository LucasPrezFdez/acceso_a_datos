package Archivos.EjerciciosFicheros2.ejercicio3;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Ejercicio3 {
    static String  DEFAULT_LOCATION ="C:\\Users\\DAM2\\IdeaProjects\\Trimestre1AccesoADatos\\src\\main\\java\\Archivos";

    private static int calculatorFinalArrayLenght(JFileChooser fileChooser) throws IOException {
        String paContar;
        int finalArrayLenth = 0;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
        while ((paContar = bufferedReader.readLine()) != null){
            char[] cosas = paContar.toCharArray();
            if (cosas.length > 0) finalArrayLenth++;
            for (int i = 1; i < cosas.length; i++) {
                if (cosas[i-1] == ' ') finalArrayLenth++;
            }
        }
        return finalArrayLenth;
    }

    public static void main(String[] args) throws IOException {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a text file");
        fileChooser.setCurrentDirectory(new File(DEFAULT_LOCATION));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt");
        fileChooser.setFileFilter(filter);

        int option = fileChooser.showOpenDialog(null);

        if (option == JFileChooser.APPROVE_OPTION) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
            String linea;
            int aux = 1;


            char[] arrayFinal = new char[calculatorFinalArrayLenght(fileChooser)];
            while ((linea = bufferedReader.readLine()) != null) {
                char[] array = linea.toCharArray();
                arrayFinal[0] = array[0];
                for (int i = 1 ; i<array.length;i++){
                    if (array[i-1] == ' '){
                        arrayFinal[aux] = array[i];
                        aux++;
                    }
                }
            }
            System.out.println("Tenemos "+ Arrays.toString(arrayFinal));

        }

    }
}
