package Ejercicio1;

public class TestCoche {

    public static void main(String[] args) {

        Coche coche1 = new Coche("Toyota", "Corolla", 2020, "Blanco", 35000.5);
        Coche coche2 = new Coche("Ford", "Mustang", 2018, "Rojo", 52000.0);
        Coche coche3 = new Coche("Honda", "Civic", 2022, "Negro", 15000.75);


        coche2.setColor("Zapato");
        coche1.conducir(100);

        System.out.println(coche1.toString());
        System.out.println(coche2.toString());
        System.out.println(coche3.toString());
        System.out.println(Coche.getNumCoches());
    }
}
