package Excepciones.NumberDivisions;

public class NumberDivision {

    public static void division(String uno, String dos) {

        try {

            int primero = Integer.parseInt(uno);
            int segundo = Integer.parseInt(dos);

            System.out.println("Calculo : " + primero / segundo);
        } catch (NumberFormatException e) {
            System.out.println("Numero no valido ==> " + e);
        } catch (ArithmeticException e) {
            System.out.println("No es posible dividir por 0 ==> " + e);
        }


    }

    public static void main(String[] args) {

        division("quince","6");
        division("12","0");

        System.out.println("FIN DEL CODIGO");

    }

}
