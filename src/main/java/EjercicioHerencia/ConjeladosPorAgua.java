package EjercicioHerencia;

public class ConjeladosPorAgua extends ProductosConjelados{

    double gramosSalxLitroAgua;

    public ConjeladosPorAgua(int fechaDeCaducidad, int numeroDeLote, int temperaturaRecomendada,
                             double gramosSalxLitroAgua) {
        super(fechaDeCaducidad, numeroDeLote, temperaturaRecomendada);
        this.gramosSalxLitroAgua = gramosSalxLitroAgua;
    }

    public double getGramosSalxLitroAgua() {
        return gramosSalxLitroAgua;
    }

    public void setGramosSalxLitroAgua(double gramosSalxLitroAgua) {
        this.gramosSalxLitroAgua = gramosSalxLitroAgua;
    }

    @Override
    public String toString() {
        return "ConjeladosPorAgua{" +
                "gramosSalxLitroAgua=" + gramosSalxLitroAgua +
                "} " + super.toString();
    }
}
