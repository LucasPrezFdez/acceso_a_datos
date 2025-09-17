package EjercicioHerencia;

public class ProductosConjelados extends Producto {

    int temperaturaRecomendada;

    public ProductosConjelados(int fechaDeCaducidad, int numeroDeLote, int temperaturaRecomendada) {
        super(fechaDeCaducidad, numeroDeLote);
        this.temperaturaRecomendada = temperaturaRecomendada;
    }

    public int getTemperaturaRecomendada() {
        return temperaturaRecomendada;
    }

    public void setTemperaturaRecomendada(int temperaturaRecomendada) {
        this.temperaturaRecomendada = temperaturaRecomendada;
    }

    @Override
    public String toString() {
        return "ProductosConjelados{" +
                "temperaturaRecomendada=" + temperaturaRecomendada +
                "} " + super.toString();
    }
}
