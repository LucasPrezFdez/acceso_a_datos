package EjercicioHerencia;

public class ConjeladoPorAire extends ProductosConjelados {

    double nitrogeno;
    double oxigeno;
    double dioxidoDeCarbono;
    double vaporDeAgua;

    public ConjeladoPorAire(int fechaDeCaducidad, int numeroDeLote, int temperaturaRecomendada, double nitrogeno,
                            double oxigeno, double dioxidoDeCarbono, double vaporDeAgua) {
        super(fechaDeCaducidad, numeroDeLote, temperaturaRecomendada);
        this.nitrogeno = nitrogeno;
        this.oxigeno = oxigeno;
        this.dioxidoDeCarbono = dioxidoDeCarbono;
        this.vaporDeAgua = vaporDeAgua;
    }

    public double getNitrogeno() {
        return nitrogeno;
    }

    public void setNitrogeno(double nitrogeno) {
        this.nitrogeno = nitrogeno;
    }

    public double getOxigeno() {
        return oxigeno;
    }

    public void setOxigeno(double oxigeno) {
        this.oxigeno = oxigeno;
    }

    public double getDioxidoDeCarbono() {
        return dioxidoDeCarbono;
    }

    public void setDioxidoDeCarbono(double dioxidoDeCarbono) {
        this.dioxidoDeCarbono = dioxidoDeCarbono;
    }

    public double getVaporDeAgua() {
        return vaporDeAgua;
    }

    public void setVaporDeAgua(double vaporDeAgua) {
        this.vaporDeAgua = vaporDeAgua;
    }

    @Override
    public String toString() {
        return "ConjeladoPorAire{" +
                "nitrogeno=" + nitrogeno +
                ", oxigeno=" + oxigeno +
                ", dioxidoDeCarbono=" + dioxidoDeCarbono +
                ", vaporDeAgua=" + vaporDeAgua +
                "} " + super.toString();
    }


}
