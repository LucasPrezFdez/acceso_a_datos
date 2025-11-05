package Archivos.Serializable;


import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Escribimos objetos en el fichero usando try-with-resources
        try (FileOutputStream fs = new FileOutputStream("coches.txt");
             ObjectOutputStream os = new ObjectOutputStream(fs)) {

            for (int i = 0; i < 2; i++) {
                Coches c = new Coches(); // crear objeto nuevo en cada iteración

                System.out.println("Matricula: ");
                c.setMatricula(sc.nextLine());
                System.out.println("Marca: ");
                c.setMarca(sc.nextLine());
                System.out.println("Modelo: ");
                c.setModelo(sc.nextLine());
                System.out.println("Tamaño deposito: ");
                c.setTamanoDeposito(sc.nextInt());
                sc.nextLine(); // consumir salto de línea
                System.out.println("Precio: ");
                c.setPrecio(sc.nextDouble());
                sc.nextLine();

                os.writeObject(c);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Leemos los objetos y los mostramos por pantalla
        try (FileInputStream fis = new FileInputStream("coches.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (true) {
                try {
                    Coches c = (Coches) ois.readObject();
                    System.out.println(c);
                } catch (EOFException e) {
                    // fin del fichero -> salir del bucle
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
