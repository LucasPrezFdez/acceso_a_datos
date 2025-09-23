// Principal.java
package Ejercicio8;

public class Principal {
    public static void main(String[] args) {
        Asalariado empleado1 = new Asalariado("Manuel Cortina", 12345678, 28, 1200);
        EmpleadoProduccion empleado2 = new EmpleadoProduccion("Jua Mota", 5333222, 30, 1200, "noche");
        EmpleadoDistribucion empleado3 = new EmpleadoDistribucion("Antonio Gil", 55333666, 35, 1200, "Cáceres");

        // Mostrar nombre y sueldo de empleado1 y empleado2
        System.out.println(empleado1.getNombre() + " - Sueldo: " + empleado1.getSalarioBase());
        System.out.println(empleado2.getNombre() + " - Sueldo: " + empleado2.getSalarioBase());
        System.out.println(empleado3.getNombre() + " - Sueldo: " + empleado3.getSalarioBase());


        // Mostrar nombre y sueldo de empleado1, empleado2 y empleado3, turno y región
        System.out.println("******************************");
        System.out.println(empleado1.getNombre() + " - Sueldo: " + empleado1.getSalarioBase());
        System.out.println(empleado2.getNombre() + " - Sueldo: " + empleado2.getSalarioBase() + " - Turno: " + empleado2.getTurno());
        System.out.println(empleado3.getNombre() + " - Sueldo: " + empleado3.getSalarioBase() + " - Región: " + empleado3.getRegion());

        // Array de asalariados
        Asalariado[] array_asal = new Asalariado[3];
        array_asal[0] = empleado1;
        array_asal[1] = empleado2;
        array_asal[2] = empleado3;

        System.out.println("******************************");
        for (Asalariado asalariado : array_asal) {
            System.out.println(asalariado.getNombre() + " - Sueldo: " + asalariado.getSalarioBase());
        }
    }
}
