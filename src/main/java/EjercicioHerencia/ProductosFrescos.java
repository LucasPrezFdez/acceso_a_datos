package EjercicioHerencia;

public class ProductosFrescos extends Productos {

    int fechaDeEnvasado;
    String PaisDeOrigen;

    public ProductosFrescos(int fechaDeCaducidad, int numeroDeLote, int fechaDeEnvasado, String paisDeOrigen) {
        super(fechaDeCaducidad, numeroDeLote);
        this.fechaDeEnvasado = fechaDeEnvasado;
        PaisDeOrigen = paisDeOrigen;
    }

    public int getFechaDeEnvasado() {
        return fechaDeEnvasado;
    }

    public void setFechaDeEnvasado(int fechaDeEnvasado) {
        this.fechaDeEnvasado = fechaDeEnvasado;
    }

    public String getPaisDeOrigen() {
        return PaisDeOrigen;
    }

    public void setPaisDeOrigen(String paisDeOrigen) {
        PaisDeOrigen = paisDeOrigen;
    }
}
