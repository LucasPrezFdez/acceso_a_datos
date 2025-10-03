package Excepciones.Swing;

public class Piscina {
    private double nivel;
    public final double MAX_NIVEL;

    public Piscina(double max) {
        if (max < 0) max = 0;
        this.MAX_NIVEL = max;
        this.nivel = 0;
    }

    public double getNivel() {
        return nivel;
    }

    public void vaciar(double cantidad) {
        if (nivel - cantidad < 0) {
            throw new IllegalArgumentException("\nNo puedes vaciar mas de lo que tiene");
        } else {
            nivel -= cantidad;
        }
    }

    public void llenar(double cantidad) {
    if ((nivel + cantidad) > MAX_NIVEL) {
            throw new IllegalArgumentException("\nNo puedes llenar la piscina con mas litros de los que soporta");

        } else {
            nivel += cantidad;
        }
    }
}
