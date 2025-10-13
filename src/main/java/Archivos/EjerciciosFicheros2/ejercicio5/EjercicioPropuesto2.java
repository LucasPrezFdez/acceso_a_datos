package Archivos.EjerciciosFicheros2.ejercicio5;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.Scanner;

public class EjercicioPropuesto2 {

    public static void main(String[] args) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a text file");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt");
        fileChooser.setFileFilter(filter);
        fileChooser.setCurrentDirectory(new File("."));

        Scanner sc = new Scanner(System.in);
        boolean sigue = true;
        while (sigue) {

        int response;
        System.out.println("Dame una opcion del 1 al 4." +
                "\n1 Crear el fichero con tu nombre, apellidos y lugar de nacimiento" +
                "\n2 Leer el archivo creado anteriormente" +
                "\n3 Mayusculas y minusculas invertidas" +
                "\n4 Para salir");
        response = sc.nextInt();

        if (response == 1){

        }

        }
    }

}
