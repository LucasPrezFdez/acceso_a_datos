package Archivos.Binario;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Binario1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona el fichero binario");
        int seleccion = fileChooser.showOpenDialog(null);
        String ruta = null;
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            ruta = fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            System.out.println("No se seleccionó ningún fichero. Saliendo...");
            sc.close();
            return;
        }
        int cantidadActual = contarNumeros(ruta);
        if (cantidadActual >= 100) {
            System.out.println("El archivo ya contiene 100 números. No se pueden añadir más.");
            sc.close();
            return;
        }
        System.out.print("¿Cuántos números aleatorios quieres generar?: ");
        int cantidad = sc.nextInt();
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor que 0.");
            sc.close();
            return;
        }
        if (cantidadActual + cantidad > 100) {
            System.out.println("No se pueden añadir esa cantidad. El archivo solo puede tener 100 números en total.");
            sc.close();
            return;
        }
        generarNumeros(ruta, cantidad);
        System.out.println("Números en el fichero:");
        leerNumeros(ruta);
        sc.close();
    }

    public static int contarNumeros(String ruta) {
        int contador = 0;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(ruta))) {
            while (true) {
                dis.readInt();
                contador++;
            }
        } catch (EOFException e) {
            // Fin del fichero
        } catch (IOException e) {
            //
            // Error al leer el fichero
        }
        return contador;
    }

    public static void generarNumeros(String ruta, int cantidad) {
        Random rand = new Random();
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(ruta, true))) {

            for (int i = 0; i < cantidad; i++) {
                int num = rand.nextInt(101);
                dos.writeInt(num);
            }
            System.out.println(cantidad + " números añadidos correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }

    public static void leerNumeros(String ruta) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(ruta))) {
            while (true) {
                int num = dis.readInt();
                System.out.println(num);
            }
        } catch (EOFException e) {
            // Fin del fichero
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}
