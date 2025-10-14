package Archivos.EjerciciosFicheros2.ejercicio5;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Scanner;


public class ejercicioFicheroATexto {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File fichero = null;
        int opcion = 0;
        do {
            System.out.println("1.Crear fichero");
            System.out.println("2.Mostrar fichero");
            System.out.println("3.Crear e invertir fichero");
            System.out.println("4.Salir");
            opcion = sc.nextInt();

            if (opcion == 1)
                fichero=crearFichero();
            if (opcion == 2)
                mostrarFichero(seleccionarFichero());
            if (opcion == 3)
                crearEinvertirFichero();
            if((opcion<1)||(opcion>4))
                System.out.println("Opcion no valida");
        } while ((opcion!=4));




    }

    public static File crearFichero() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Crear archivo");

        int userSelection = fileChooser.showSaveDialog(null);
        File archivo = null;
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            archivo = fileChooser.getSelectedFile();
            try {
                if (archivo.createNewFile()) {
                    System.out.println("Archivo creado: " + archivo.getAbsolutePath());
                } else {
                    System.out.println("El archivo ya existía: " + archivo.getAbsolutePath());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        FileWriter fw = new FileWriter(archivo);
        PrintWriter pw = new PrintWriter(fw);

        pw.println("Antonio Benito González");
        pw.println("Colmenar de Oreja");
        pw.flush();
        pw.close();


        return archivo;
    }

    public static File seleccionarFichero() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona un archivo");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
        fileChooser.setFileFilter(filter);

        File origen = new File("/Users/Antonio/Desktop");
        fileChooser.setCurrentDirectory(origen);
        // Mostrar el diálogo de selección
        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            return archivoSeleccionado;
        } else return null;
    }

    public static void mostrarFichero(File archivo) throws IOException {
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }

    }

    public static void crearEinvertirFichero() throws IOException {
        File fichero = crearFichero();
        FileReader fr = new FileReader(fichero);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {

            StringBuilder resultado = new StringBuilder();

            // Recorremos cada carácter
            for (int i = 0; i < linea.length(); i++) {
                char c = linea.charAt(i);

                // Si es letra minúscula, la pasamos a mayúscula
                if (Character.isLowerCase(c)) {
                    resultado.append(Character.toUpperCase(c));
                }
                // Si es letra mayúscula, la pasamos a minúscula
                else if (Character.isUpperCase(c)) {
                    resultado.append(Character.toLowerCase(c));
                }
                // Si no es letra, la dejamos igual
                else {
                    resultado.append(c);
                }
            }

            System.out.println(resultado.toString());

        }


    }
}