package EjercicioHerencia;

public class ProductosRefrigerados extends Producto {

    int CodigoDeOrganismo;

    public ProductosRefrigerados(int fechaDeCaducidad, int numeroDeLote, int codigoDeOrganismo) {
        super(fechaDeCaducidad, numeroDeLote);
        CodigoDeOrganismo = codigoDeOrganismo;
    }

    public int getCodigoDeOrganismo() {
        return CodigoDeOrganismo;
    }

    public void setCodigoDeOrganismo(int codigoDeOrganismo) {
        CodigoDeOrganismo = codigoDeOrganismo;
    }

    @Override
    public String toString() {
        return "ProductosRefrigerados{" +
                "CodigoDeOrganismo=" + CodigoDeOrganismo +
                "} " + super.toString();
    }
}
