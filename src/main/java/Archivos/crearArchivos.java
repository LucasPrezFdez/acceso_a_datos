package Archivos;

import java.io.File;
import java.io.IOException;

public class crearArchivos {

    public static void main(String[] args) throws IOException {
        String ruta1 = "C:\\Users\\DAM2\\Desktop\\cochinoide\\nuevoArchivo.txt";
        File file = new File(ruta1);

        String ruta2 = "C:\\Users\\DAM2\\Desktop\\tuMadreRobaaaa\\nuevoArchivo2.txt";
        File file2 = new File(ruta2);

        file.getParentFile().mkdirs();
        if (file.createNewFile()) {
            System.out.println("Archivo creado: " + file.getName());
        } else {
            System.out.println("El archivo ya existe.");
        }

        file2.getParentFile().mkdirs();
        if (file2.createNewFile()) {
            System.out.println("Archivo creado: " + file2.getName());
        } else {
            System.out.println("El archivo ya existe");
        }


    }
}
