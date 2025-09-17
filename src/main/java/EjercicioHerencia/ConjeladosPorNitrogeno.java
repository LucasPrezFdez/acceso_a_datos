package EjercicioHerencia;

public class ConjeladosPorNitrogeno extends ProductosConjelados{

    String metodoDeConjelacion;
    double exposicionNitrogeno;

    public ConjeladosPorNitrogeno(int fechaDeCaducidad, int numeroDeLote,
                                  int temperaturaRecomendada, String metodoDeConjelacion, double exposicionNitrogeno) {
        super(fechaDeCaducidad, numeroDeLote, temperaturaRecomendada);
        this.metodoDeConjelacion = metodoDeConjelacion;
        this.exposicionNitrogeno = exposicionNitrogeno;
    }

    public String getMetodoDeConjelacion() {
        return metodoDeConjelacion;
    }

    public void setMetodoDeConjelacion(String metodoDeConjelacion) {
        this.metodoDeConjelacion = metodoDeConjelacion;
    }

    public double getExposicionNitrogeno() {
        return exposicionNitrogeno;
    }

    public void setExposicionNitrogeno(double exposicionNitrogeno) {
        this.exposicionNitrogeno = exposicionNitrogeno;
    }

    @Override
    public String toString() {
        return "ConjeladosPorNitrogeno{" +
                "metodoDeConjelacion='" + metodoDeConjelacion + '\'' +
                ", exposicionNitrogeno=" + exposicionNitrogeno +
                "} " + super.toString();
    }

}
