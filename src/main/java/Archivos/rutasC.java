package Archivos;

import java.io.File;

public class rutasC {
    public static void main(String[] args) {
        String ruta = "C:\\";
        File file = new File(ruta);

        if (file.exists() && file.isDirectory()) {
            File[] archivos = file.listFiles();
            if (archivos != null) {
                for (File f : archivos) {
                    System.out.println(f.getName());
                }
            } else {
                System.out.println("No se pudieron listar los archivos.");
            }
        } else {
            System.out.println("La ruta no existe o no es un directorio.");
        }
    }
}
