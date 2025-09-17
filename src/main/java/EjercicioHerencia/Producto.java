package EjercicioHerencia;

public class Producto {

    int fechaDeCaducidad;
    int numeroDeLote;

    public Producto(int fechaDeCaducidad, int numeroDeLote) {
        this.fechaDeCaducidad = fechaDeCaducidad;
        this.numeroDeLote = numeroDeLote;
    }

    public int getFechaDeCaducidad() {
        return fechaDeCaducidad;
    }

    public void setFechaDeCaducidad(int fechaDeCaducidad) {
        this.fechaDeCaducidad = fechaDeCaducidad;
    }

    public int getNumeroDeLote() {
        return numeroDeLote;
    }

    public void setNumeroDeLote(int numeroDeLote) {
        this.numeroDeLote = numeroDeLote;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "fechaDeCaducidad=" + fechaDeCaducidad +
                ", numeroDeLote=" + numeroDeLote +
                '}';
    }
}
