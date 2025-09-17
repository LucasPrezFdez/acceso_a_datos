package EjercicioHerencia;

public class ProductosConjelados extends Productos {

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
}
