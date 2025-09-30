package Excepciones.ej8;

public class Piscina {
    private int nivel;
    public final int MAX_NIVEL;

    public Piscina(int max) {
        if (max < 0) max = 0;
        MAX_NIVEL = max;
        nivel = 0;
    }

    public int getNivel() {
        return nivel;
    }

    public void vaciar(int cantidad) throws NivelPorDebajoDeCeroException {
        if (nivel - cantidad < 0) {
            throw new NivelPorDebajoDeCeroException("El nivel de la piscina no puede ser menor que cero.");
        }
        nivel -= cantidad;
    }

    public void llenar(int cantidad) throws NivelPorEncimaDeMaximoException {
        if (nivel + cantidad > MAX_NIVEL) {
            throw new NivelPorEncimaDeMaximoException("El nivel de la piscina no puede superar el máximo permitido.");
        }
        nivel += cantidad;
    }
}
