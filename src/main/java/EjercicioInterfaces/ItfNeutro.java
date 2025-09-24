package EjercicioInterfaces;

public class ItfNeutro implements ItfImpresion, ItfImpresion2{

    @Override
    public String imprimir() {
        return "Las olas del mar";
    }

    @Override
    public String imprimirBonito() {
        return "---- Las olas del mar ----";
    }
}
