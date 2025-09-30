package Excepciones.generaExcepcion;

public class generaExcepcion {

    public static void excepcionMaker(int i) {
        int t;
        int num[] = {2, 4, 6};
        System.out.println("Recibiendo " + i);
        try {
            switch (i) {
                case 0:
                    t = 10 / i; //division por cero
                    break;
                case 1:
                    num[4] = 4; //genera un error
                    break;
                case 2:
                    return;
            }
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por 0 ==> " + e);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("La posicion seleccionada del array se encuentra fuera del mismo (No existe) ==> "+ e);
        } finally {
            System.out.println("Ejecutando código de limpieza");
        }
    }

    public static void main(String[] args) {
        excepcionMaker(0);
        excepcionMaker(1);
        excepcionMaker(2);
    }
}
