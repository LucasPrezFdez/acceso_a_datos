package Excepciones.Swing;

public class Piscina {
    private int nivel;
    public final int MAX_NIVEL;

    public Piscina(int max) {
        if (max < 0) max = 0;
        this.MAX_NIVEL = max;
        this.nivel = 0;
    }

    public int getNivel() {
        return nivel;
    }

    public void vaciar(int cantidad) {
        if (nivel - cantidad < 0) {
            throw new IllegalArgumentException("No puedes vaciar mas de lo que tiene");
        } else {
            nivel -= cantidad;
        }
    }

    public void llenar(int cantidad) {
        if (nivel + cantidad > MAX_NIVEL) {
            throw new IllegalArgumentException("No puedes llenar la piscina con mas litros de los que soporta");
        } else {
            nivel += cantidad;
        }
    }
}
