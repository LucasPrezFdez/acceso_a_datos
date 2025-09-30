package Excepciones.NewException;

public class Cajero {

    public static void main(String[] args) {
        Cuenta c = new Cuenta();
        try {
            c.ingresar(100);
            c.extraer(20);
        } catch (Exception e) {
            System.out.println("La cuenta no puede quedar en números rojos");
        }
    }


}
